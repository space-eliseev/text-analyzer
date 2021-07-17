package space.eliseev.textanalyzer.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * История запросов
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RequestHistory extends BaseEntity {
    private static final long serialVersionUID = 434841428825992288L;

    /**
     * Дата и время запроса
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date requestTime;

    /**
     * HTTP-адрес страницы
     */
    private String hostName;

    /**
     * Был ли успешным запрос
     */
    private Boolean isSuccess;

    /**
     * Текст ответа
     */
    @Lob
    private String text;
}
