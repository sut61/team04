/*package com.project.project;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class Menu {
    @Id @GeneratedValue
    private Long id;
    private @NonNull String menname;
}*/

package com.project.project;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name="Stock")
public class Stock {
    @Id
    @GeneratedValue
    private Long id;



    String Sname;

    public Menu(){}
    public Menu(String Sname){
        this.Sname = Sname;

    }
}
