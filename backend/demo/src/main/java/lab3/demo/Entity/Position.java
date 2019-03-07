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
@Table(name="Position")
public class Position { 
    
    @Id 
    @SequenceGenerator(name="position_seq",sequenceName="position_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="position_seq")
    @Column(name="positionId",unique = true, nullable = false)
    @NotNull
    private Long id;
    
    @Size(min = 3,max = 20) 
    @Pattern(regexp ="\\w+")
    private @NotNull String name;
    


}