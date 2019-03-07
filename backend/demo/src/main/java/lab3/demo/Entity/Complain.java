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

public class Complain {

    @Id
    @SequenceGenerator(name="complain_seq",sequenceName="complain_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="complain_seq")
    @Column(name="complainId",unique = true, nullable = false)
    @NotNull
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Member.class)
    private Member member;
    @ManyToOne (fetch = FetchType.EAGER, targetEntity = Driver.class)
    private Driver driver;
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = DriverTaxi.class)
    private DriverTaxi driverTaxi;

    @Size(min =5,max=20 )
    @Pattern(regexp ="[\\w\\s]+")
    private @NotNull String message;
    

}
