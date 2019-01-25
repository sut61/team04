package lab3.demo.Entity;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class DriverTaxi {

    @Id
    @GeneratedValue
    private Long id;

    // @ManyToOne
    // private Gender gender;
    // @ManyToOne
    // private Province province;
    // @ManyToOne
    // private CarType carType;

    private @NonNull String name;
    private @NonNull String tel;
    private @NonNull String address;
    private @NonNull String email;


}
