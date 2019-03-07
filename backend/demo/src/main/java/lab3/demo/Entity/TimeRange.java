package lab3.demo.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "Timerange")

public class TimeRange {
    @Id 
    @SequenceGenerator(name="timeRange_seq",sequenceName="timeRange_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="timeRange_seq")
    @Column(name="timeRangeId",unique = true, nullable = false)
    @NotNull
    private Long id;

    @Size(min = 3,max = 20) @NotNull
    @Pattern(regexp ="\\w+")
    private String timeRange;
    private String start;
    private String finish;
}