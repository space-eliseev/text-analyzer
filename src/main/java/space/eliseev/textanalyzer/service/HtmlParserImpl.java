package space.eliseev.textanalyzer.service;

import com.google.gson.Gson;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import space.eliseev.textanalyzer.dto.WordDto;
import space.eliseev.textanalyzer.entity.RequestHistory;
import space.eliseev.textanalyzer.repository.RequestHistoryRepository;

import java.util.*;
import java.util.stream.Stream;

@Log4j2
@Service
@RequiredArgsConstructor
public class HtmlParserImpl implements IHtmlParser {

    private final IHtmlLoader loader;
    private final RequestHistoryRepository repository;

    @Override
    public void start() {
        log.info("Парсер запущен");
        while (true) {
            System.out.println("Введите имя HTML-страницы. Для выхода из программы введите 'exit'.");
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            List<WordDto> words = Collections.emptyList();

            if (s.length() == 0) {
                continue;
            }

            if ("exit".equals(s)) {
                log.info("Парсер остановлен");
                System.exit(1);
            }

            try {
                words = parse(s);
                System.out.println("Статистика по количеству уникальных слов:");
                words.forEach(word -> System.out.println(word.getWord() + ": " + word.getCount()));
            } catch (Exception e) {
                System.out.println("Возникла ошибка при загрузке html-страницы, повторите попытку!");
            }

            save(s, !words.isEmpty(), new Gson().toJson(words));
        }
    }

    @Override
    public List<WordDto> parse(@NonNull String url) throws Exception {

        String text = loader.loadHtml(url).orElseThrow();

        Map<String, Integer> map = Stream.of(text.split("[^А-Яа-яA-Za-z]+"))
                .map(String::toLowerCase)
                .collect(HashMap::new, (m, c) -> m.put(c, m.containsKey(c) ? (m.get(c) + 1) : 1), HashMap::putAll);

        List<WordDto> words = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            words.add(WordDto.builder()
                    .word(entry.getKey())
                    .count(entry.getValue())
                    .build());
        }

        words.sort(WordDto.COMPARE_BY_COUNT.reversed());

        return words;
    }

    @Override
    public void save(@NonNull String url, @NonNull Boolean isSuccess, @NonNull String text) {
        log.info("Данные по запросу сохранены");
        repository.save(RequestHistory.builder()
                .hostName(url)
                .requestTime(new Date())
                .isSuccess(isSuccess)
                .text(text)
                .build());
    }
}
