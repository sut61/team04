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

public class Bank {
    @Id 
    @SequenceGenerator(name="bank_seq",sequenceName="bank_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="bank_seq")
    @Column(name="bankId",unique = true, nullable = false)
    @NotNull
    private Long id;

    @Size(min =1,max=20) 
    @Pattern(regexp ="[\\w\\s]+")
    @NotNull
    private String name;

}