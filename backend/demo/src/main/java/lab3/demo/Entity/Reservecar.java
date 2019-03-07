package lab3.demo.Entity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class Reservecar {
    @Id @GeneratedValue
    @Column(name="reservecarId",unique = true, nullable = false)
    @NotNull
    private Long id;

    @NotNull
    @Size(min=10, max=15)
    @Pattern(regexp ="[\\w\\s]+")
    String dest;

    @NotNull
    @Size(min=10, max=15)
    @Pattern(regexp ="[\\w\\s]+")
    String cur;

    /* @NotNull
    @Pattern(regexp ="\\d\\d[-]\\d\\d[-]\\d\\d")
    String date; */

    @NotNull
    @Temporal(TemporalType.DATE)
    private  Date date;

    /* @NotNull
    @Pattern(regexp ="\\d\\d[:]\\d\\d")
    String time; */

    @NotNull
    @Temporal(TemporalType.TIME)
    private Date time;

    @NotNull
    @ManyToOne
    private CarType carType;

    @NotNull
    @ManyToOne
    private Driver driver;

    @NotNull
    @ManyToOne
    private Member member;


}