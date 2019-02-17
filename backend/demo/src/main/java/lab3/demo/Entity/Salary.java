package lab3.demo.Entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.util.Date;
@Data
@Entity
@Getter @Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Table(name="Salary")
public class Salary {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Admin admin;
    @ManyToOne
    private Driver driver;
    @ManyToOne
    private Position position ;
 
     
    @Size(min = 3,max = 20) @NotNull 
    @Pattern(regexp ="[\\w\\s]+")
    private String nameAdmin;

    @Size(min = 5,max = 20) @NotNull 
    @Pattern(regexp ="[\\w\\s]+")
    private String nameDriver;

    @Size(min = 3,max = 20) @NotNull 
    @Pattern(regexp ="\\w+")
    private String namePosition;

    @Size(min = 10,max = 10) @NotNull 
    @Pattern(regexp ="0[89]\\d+")
    private String phoneDriver;
    
    @Size(min = 3,max = 20) @NotNull 
    @Pattern(regexp ="\\w+")
    private String payment;
      
    @Temporal(TemporalType.DATE)
    private  Date date;
    
    private  int price;


}
