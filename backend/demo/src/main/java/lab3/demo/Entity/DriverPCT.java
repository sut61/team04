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

public class DriverPCT {
    @Id @GeneratedValue
    private Long id;


    String username;
    String password;

    @Size(min =1,max=20 ) @NotNull
    @Pattern(regexp ="[\\w\\s]+")
    String name;

    @Size(min =1,max=50 ) @NotNull
    String address;

    @Size(min =1,max=20 ) @NotNull
    @Pattern(regexp ="[\\w]+")
    String vehicleType;

    @Size(min=10 , max=10) @NotNull
    @Pattern(regexp = "0[89]\\d+")
    String phone;


    @ManyToOne
    private Gender gender;
    @ManyToOne
    private Province province;
    @ManyToOne
    private Career career;

}