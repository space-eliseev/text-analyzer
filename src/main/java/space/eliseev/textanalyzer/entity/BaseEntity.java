package space.eliseev.textanalyzer.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
@NoArgsConstructor
@Getter
@Setter
public abstract class BaseEntity implements Serializable {
    private static final long serialVersionUID = 5056718007612331015L;

    @Id
    @GeneratedValue(
            generator = "native_generator"
    )
    @GenericGenerator(
            name = "native_generator",
            strategy = "native"
    )
    @Access(AccessType.PROPERTY)
    private Long id;
}
