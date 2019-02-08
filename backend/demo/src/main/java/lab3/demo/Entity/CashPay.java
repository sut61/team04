package lab3.demo.Entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
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

    
    @NotNull
    @Size(min=1,max=5)   
     String distance;
     
    
   
    @NotNull
    @Size(min=1,max=5)
    @Pattern(regexp="\\d+")   
     String moneypay;


    
    @Size(min=1,max=5)
    @Pattern(regexp="\\d+")
     String change;
    
@ManyToOne
private Driver driver;

@ManyToOne
private Member member;

@ManyToOne
private Gift gift;


}