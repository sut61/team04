package lab3.demo.Entity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class Admin {
    @Id 
    @SequenceGenerator(name="admin_seq",sequenceName="admin_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="admin_seq")
    @Column(name="adminId",unique = true, nullable = false)
    @NotNull
    private Long id;

    private String username;
    private String password;
    
    @Size(min = 3,max = 20) @NotNull
    @Pattern(regexp ="\\w+")
    private String name;
    


}