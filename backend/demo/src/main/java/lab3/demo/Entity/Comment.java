package lab3.demo.Entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class Comment {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Member member;
    @ManyToOne
    private Score score;
    @ManyToOne
    private Driver driver;
    @ManyToOne
    private DriverTaxi driverTaxi;

    @Size(min =5,max=20 ) @NotNull
   @Pattern(regexp ="\\w+")
    private String Comment;

    @Size(min =1,max=20 ) @NotNull
    @Pattern(regexp ="\\w+")
    private String nameDriver;

    @Size(min =1,max=20 ) @NotNull
    @Pattern(regexp ="\\w+")
    private String nameMamber;

    @Size(min =10,max=10 ) @NotNull
    @Pattern(regexp ="08\\d+")
    private String phoneDriver;

    @Size(min =10,max=10 ) @NotNull
    @Pattern(regexp ="08\\d+")
    private String phoneMamber;

}
