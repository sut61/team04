package lab3.demo.Entity;

import lombok.*;
import javax.persistence.*;


@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "Timerange")

public class TimeRange {
    @Id @GeneratedValue
    private Long id;
    
    private String timeRange;
    private String start;
    private String finish;
}