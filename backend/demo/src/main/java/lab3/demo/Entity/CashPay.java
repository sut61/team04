package lab3.demo.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



import javax.validation.constraints.Pattern;


@Data
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode

public class CashPay {
    @Id 
    @SequenceGenerator(name="cashpay_seq",sequenceName="cashpay_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cashpay_seq")
    @Column(name="cashpayId",unique = true, nullable = false)
    @NotNull
    private Long id;

    
    // @Size(min=1,max=1000)
    @Min(1)
    @Max(1000)   
    private int distance;
     
    // @Size(min=3,max=3000) 
    @Min(3)
    @Max(3000)
    private int moneypay;

    // @Size(min=1,max=2997)
    
    @Max(2997)
    private int change;
    
    
    @Size(min=3,max=20)
    @Pattern(regexp ="[\\w\\s]+")
    private @NotNull String drivername;
     
    
@ManyToOne(fetch = FetchType.EAGER, targetEntity = Driver.class)
private @NotNull Driver driver;

@ManyToOne(fetch = FetchType.EAGER, targetEntity = Member.class)
private  Member member;

@ManyToOne(fetch = FetchType.EAGER, targetEntity = Gift.class)
private Gift gift;


}