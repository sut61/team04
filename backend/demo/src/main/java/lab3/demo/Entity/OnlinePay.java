package lab3.demo.Entity;
import lombok.*;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class OnlinePay {
    @Id @GeneratedValue
    private Long id;

    int distance;
    int moneypay;

@ManyToOne
private Driver driver;
@ManyToOne
private Member member;
@ManyToOne
private Bank bank;


}