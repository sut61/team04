package com.okta.developer.demo.Entity;
import lombok.*;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Comment {
    @Id @GeneratedValue
    private Long id;

    private @NonNull String comment;
    private @NonNull int point;

    @ManyToOne
    private CarType carType;

    @ManyToOne
    private Driver driver;
    @ManyToOne
    private DriverTaxi driverTaxi;

    @ManyToOne
    private Member member;

    /*public Comment(){}

    public Comment(CarType carType,Driver driver,DriverTaxi driverTaxi,Member member){
        this.carType = carType;
        this.driver = driver;
        this.driverTaxi = driverTaxi;
        this.member = member;
    }*/
}
