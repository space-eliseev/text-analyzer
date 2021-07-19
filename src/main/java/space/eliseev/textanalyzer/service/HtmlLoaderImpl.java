package space.eliseev.textanalyzer.service;

import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.util.Optional;

@Log4j2
@Service
public class HtmlLoaderImpl implements IHtmlLoader {

    @Override
    public Optional<String> loadHtml(@NonNull String url) throws Exception {
        try {
            return Optional.of(Jsoup.connect(url).get().html());
        } catch (IllegalArgumentException | IOException exception) {
            if (ExceptionUtils.getRootCause(exception) instanceof MalformedURLException) {
                log.error("Отсутствует название протокола в имени файла");
            } else if (ExceptionUtils.getRootCause(exception) instanceof UnknownHostException) {
                log.error("Страница " + url + " не найдена");
            } else {
                log.error("Что-то пошло не так", exception);
            }
        }
        throw new Exception();
    }
}
