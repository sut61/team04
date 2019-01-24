package lab3.demo.Entity;

import lombok.*;
import javax.persistence.*;
import java.util.Date;
@Data
@Entity
@Getter @Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Table(name="Discount")
public class Discount {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private TimeRange TimeRange;
    @ManyToOne
    private Admin admin;
    @ManyToOne
    private CarType carType;

    private  String promotion;
    @Temporal(TemporalType.DATE)
    private  Date date;
    private  Integer price;
    


}
