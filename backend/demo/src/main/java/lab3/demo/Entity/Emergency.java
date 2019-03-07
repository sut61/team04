package lab3.demo.Entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
@Getter @Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode

public class Emergency {

    @Id
    @GeneratedValue
    @Column(name="emergencyId",unique = true, nullable = false)
    private Long id;

    @ManyToOne
    private Cause cause;
    @ManyToOne
    private Driver driver;
    @ManyToOne
    private PriceType priceType;
    @ManyToOne
    private Member member;

    @Size(min=10 , max=50)
    @NotNull String position;

    @Size (min=10 , max=10)
    @Pattern(regexp = "0[89]\\d+")
    @NotNull String phone;



}
