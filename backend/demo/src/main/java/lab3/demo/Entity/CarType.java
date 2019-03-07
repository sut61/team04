package lab3.demo.Entity;
import lombok.*;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class CarType {
    @Id @GeneratedValue
    private Long id;
    @Size (min = 0 , max = 20)
    @Pattern(regexp ="[\\w\\s]+")
    @NotNull private String name;

}