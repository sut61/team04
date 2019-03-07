package lab3.demo.Entity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class Callcar {
    @Id
    @SequenceGenerator(name="callcar_seq",sequenceName="callcar_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="callcar_seq")
    @Column(name="callcarId",unique = true, nullable = false)
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

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = CarType.class)
    private CarType carType;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Driver.class)
    private Driver driver;
    
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Member.class)
    private Member member;


}