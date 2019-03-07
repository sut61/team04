package lab3.demo.Entity;
import lombok.*;

import javax.persistence.Id;
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

public class Member {
    @Id @GeneratedValue
    private Long id;

    @Size(min=5, max=15)
    @NotNull
    String username;

    @Size(min=6, max=10)
    @NotNull
    String password;

    @Size(min =5,max=20 )
    @NotNull
    @Pattern(regexp ="[\\w\\s]+")
    String name;

    @Size(min=10 , max=50)
    @NotNull
    String address;

    @Size(min=10 , max=10)
    @NotNull
    @Pattern(regexp = "0[89]\\d+")
    String phone;

    @NotNull
    @ManyToOne
    private Gender gender;

    @NotNull
    @ManyToOne
    private Province province;

    @NotNull
    @ManyToOne
    private CarType carType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }
}