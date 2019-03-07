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
@Table(name="Salary")
public class Salary {

    @Id 
    @SequenceGenerator(name="salary_seq",sequenceName="salary_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="salary_seq")
    @Column(name="SalaryId",unique = true, nullable = false)
    @NotNull
    private Long id;
    
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Admin.class)
    private Admin admin;
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Driver.class)
    private Driver driver;
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Position.class)
    private Position position ;
 
    
    @Size(min = 3,max = 20) @NotNull 
    @Pattern(regexp ="\\w+")
    private String payment;
      
    @Temporal(TemporalType.DATE)
    private @NotNull Date date;
    
    @Min(1)
    @Max(9999999)
    private Integer price;


}
