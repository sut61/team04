package lab3.demo.Entity;
import lombok.*;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class PriceType {
  @Id @GeneratedValue
    private Long id;

  @Size(min = 5 , max = 50)
  @NotNull private String priceType;
 

}