package lab3.demo.Entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
    @SequenceGenerator(name="discount_seq",sequenceName="discount_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="discount_seq")
    @Column(name="discountId",unique = true, nullable = false)
    @NotNull
    private Long id;


    
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Admin.class)
    private  @NotNull Admin admin;
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = CarType.class)
    private  @NotNull CarType carType;
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = TimeRange.class)
    private  @NotNull TimeRange timeRange;

    @Size(min = 3,max = 20) @NotNull
    @Pattern(regexp ="\\w+")
    private  String promotion;

    @Temporal(TemporalType.DATE)
    private @NotNull Date date;

    @Min(1)
    @Max(999999)
    private  Integer price;
    


}
