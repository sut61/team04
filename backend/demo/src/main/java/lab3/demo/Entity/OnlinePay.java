package lab3.demo.Entity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class OnlinePay {
    @Id 
    @SequenceGenerator(name="onlinepay_seq",sequenceName="onlinepay_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="onlinepay_seq")
    @Column(name="onlinepayId",unique = true, nullable = false)
    @NotNull
    private Long id;
    
    @Min(1)
    @Max(1000)
    int distance;

    @Min(3)
    @Max(3000)
    int moneypay;

@ManyToOne(fetch = FetchType.EAGER, targetEntity = Driver.class)
private @NotNull Driver driver;

@ManyToOne(fetch = FetchType.EAGER, targetEntity = Member.class)
private @NotNull Member member;

@ManyToOne(fetch = FetchType.EAGER, targetEntity = Bank.class)
private @NotNull Bank bank;


}