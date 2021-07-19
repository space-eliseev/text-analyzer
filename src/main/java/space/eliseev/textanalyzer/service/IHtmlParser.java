package space.eliseev.textanalyzer.service;

import space.eliseev.textanalyzer.dto.WordDto;

import java.util.List;

/**
 * Интерфейс для работы с html-страницами
 */
public interface IHtmlParser {

    /**
     * Запустить парсер
     */
    void start();

    /**
     * Распарсить html-страницу
     *
     * @param url Адрес html-страницы
     * @return Список уникальных слов и их количество
     */
    List<WordDto> parse(String url) throws Exception;

    /**
     * Сохранить данные по запросу
     *
     * @param url Адрес html-страницы
     */
    void save(String url, Boolean isSuccess, String text);
}
