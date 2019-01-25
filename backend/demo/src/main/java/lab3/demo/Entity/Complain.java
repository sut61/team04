package lab3.demo.Entity;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode

public class Complain {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Member member;
    @ManyToOne 
    private Driver driver;
    @ManyToOne
    private DriverTaxi driverTaxi;

    private @NonNull String message;
    

}
