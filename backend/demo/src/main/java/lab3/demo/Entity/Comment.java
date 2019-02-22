package lab3.demo.Entity;


import lombok.*;

import javax.persistence.*;
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
    @SequenceGenerator(name="comment_seq",sequenceName="comment_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="comment_seq")
    @Column(name="commentId",unique = true, nullable = false)
    @NotNull
    private Long id;


    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Member.class)
    private Member member;
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Score.class)
    private Score score;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Driver.class)
    private Driver driver;
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = DriverTaxi.class)
    private DriverTaxi driverTaxi;

    @Size(min =5,max=20 ) 
    @Pattern(regexp ="[\\w\\s]+")
    private @NotNull String Comment;

    @Size(min =1,max=20 ) 
    @Pattern(regexp ="[\\w\\s]+")
    private @NotNull String nameDriver;

    @Size(min =1,max=20 ) 
    @Pattern(regexp ="[\\w\\s]+")
    private @NotNull String nameMamber;

    @Size(min =10,max=10 ) 
    @Pattern(regexp ="0[98]\\d+")
    private @NotNull String phoneDriver;

    @Size(min =10,max=10 ) 
    @Pattern(regexp ="0[98]\\d+")
    private @NotNull String phoneMamber;

}
