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
@Table(name="Position")
public class Position { 
    @Id @GeneratedValue
    private Long id;

    String name;
    


}