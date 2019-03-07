package lab3.demo.Entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
@Getter @Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Table(name="Driver")
public class Driver {

    @Id
    @GeneratedValue
    @Column(name="driverId",unique = true, nullable = false)
    private Long id;

    @ManyToOne
    private Gender gender;
    @ManyToOne
    private Province province;
    @ManyToOne
    private CarType carType;

    @Pattern(regexp ="[\\w\\s]+")
    private @NotNull String name;

    @Size(min=10 , max=10)
    @Pattern(regexp = "0[89]\\d+")
    private @NotNull String tel;

    @Size(min=10 , max=50)
    private @NotNull String address;

    @Pattern(regexp ="[\\w\\s]+@[\\w\\s]+[\\.]com")
    private @NotNull String email;

    @Size(min=0 , max=15)
    @Pattern(regexp ="[\\w\\d]+")
    private @NotNull String username;

    @Size(min=5 , max=15)
    @Pattern(regexp ="[\\w\\d]+")
    private @NotNull String password;


}
