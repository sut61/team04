package lab3.demo.Entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



import javax.validation.constraints.Pattern;


@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class CashPay {
    @Id @GeneratedValue
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
    @Min(1)
    @Max(2997)
    private int change;
    
    
    @Size(min=3,max=20)
    @Pattern(regexp ="[\\w\\s]+")
    private @NotNull String drivername;
     
    
@ManyToOne
private Driver driver;

@ManyToOne
private Member member;

@ManyToOne
private Gift gift;


}