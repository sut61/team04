package lab3.demo.Entity;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode

public class Emergency {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Cause cause;
    @ManyToOne
    private Driver driver;
    @ManyToOne
    private PriceType priceType;
    @ManyToOne
    private Member member;

    String position;
    String phone;



}
