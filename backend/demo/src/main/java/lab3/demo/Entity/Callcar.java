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

public class Callcar {
    @Id @GeneratedValue
    private Long id;

    String dest;
    String cur;

    @ManyToOne
    private CarType carType;

    @ManyToOne
    private Driver driver;

    @ManyToOne
    private Member member;


}