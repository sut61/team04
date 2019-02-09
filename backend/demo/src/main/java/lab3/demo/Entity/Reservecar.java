package lab3.demo.Entity;
import lombok.*;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class Reservecar {
    @Id @GeneratedValue
    private Long id;

    @NotNull
    @Size(min=10, max=15)
    String dest;

    @NotNull
    @Size(min=10, max=15)
    String cur;

    @NotNull
    @Pattern(regexp ="\\d\\d[-]\\d\\d[-]\\d\\d")
    String date;

    @NotNull
    @Pattern(regexp ="\\d\\d[:]\\d\\d")
    String time;

    @ManyToOne
    private CarType carType;

    @ManyToOne
    private Driver driver;

    @ManyToOne
    private Member member;


}