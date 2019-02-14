package lab3.demo.Entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
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

    @Size(min = 3,max = 20) @NotNull
    @Pattern(regexp ="\\w+")
    private  String promotion;

    @Temporal(TemporalType.DATE)
    private  Date date;

    private  Integer price;
    


}
