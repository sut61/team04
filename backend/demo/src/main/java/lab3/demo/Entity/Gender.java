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

public class Gender {
    @Id @GeneratedValue
    private Long id;

    @Pattern(regexp = "[WM]\\w+")
    @Size(min = 0, max = 10)
    @NotNull  private String sex;

}