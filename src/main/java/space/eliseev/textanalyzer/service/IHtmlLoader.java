package space.eliseev.textanalyzer.service;

import java.util.Optional;

/**
 * Интерфейс для загрузки html-страницы
 */
public interface IHtmlLoader {

    /**
     * Загрузить html-страницу
     *
     * @param url Адрес html-страницы
     * @return Результат зарузки
     */
    Optional<String> loadHtml(String url) throws Exception;
}
