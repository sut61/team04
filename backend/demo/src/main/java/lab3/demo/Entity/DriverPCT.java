package lab3.demo.Entity;
import lombok.*;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class DriverPCT {
    @Id @GeneratedValue
    private Long id;

    String username;
    String password;
    String name;
    String address;
    String vehicleType;
    String phone;


    @ManyToOne
    private Gender gender;
    @ManyToOne
    private Province province;
    @ManyToOne
    private Career career;

}