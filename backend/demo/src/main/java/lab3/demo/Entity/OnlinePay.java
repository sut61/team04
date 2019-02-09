package lab3.demo.Entity;
import lombok.*;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class OnlinePay {
    @Id @GeneratedValue
    private Long id;
    
    @Min(1)
    @Max(1000)
    int distance;

    @Min(3)
    @Max(3000)
    int moneypay;

@ManyToOne
private Driver driver;
@ManyToOne
private Member member;
@ManyToOne
private Bank bank;


}