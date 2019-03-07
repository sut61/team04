package lab3.demo.Entity;
import lombok.*;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class Gift {
    @Id 
    @SequenceGenerator(name="gift_seq",sequenceName="gift_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="gift_seq")
    @Column(name="giftId",unique = true, nullable = false)
    @NotNull
    private Long id;

    @Size(min =1,max=20) 
    private @NotNull String name;

}