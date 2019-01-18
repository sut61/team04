package lab3.demo.Controller;
import lab3.demo.Entity.*;
import lab3.demo.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public class MemberController {
    @Autowired private CarTypeRepository cartyperepository;
    @Autowired private GenderRepository genderrepository;
    @Autowired private ProvinceRepository provincerepository;
    @Autowired private MemberRepository memberrepository;

    public MemberController (CarTypeRepository cartyperepository, 
                             GenderRepository genderrepository,
                             ProvinceRepository provincerepository,
                             MemberRepository memberrepository){
        this.cartyperepository = cartyperepository;
        this.genderrepository = genderrepository;
        this.provincerepository = provincerepository;
        this.memberrepository = memberrepository;

    }

    @GetMapping("/CarType")
    public Collection<CarType> cartype(){
        return cartyperepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/Gender")
    public Collection<Gender> gender(){
        return genderrepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/Province")
    public Collection<Province> province(){
        return provincerepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping(path = "Member/{username}/{password}/{name}/{address}/{phone}/{id_gender}/{id_province}/{id_cartype}")
    public Member Member(@PathVariable String username,
                         @PathVariable String password,
                         @PathVariable String name,
                         @PathVariable String address,
                         @PathVariable String phone,
                         @PathVariable Long id_gender,
                         @PathVariable Long id_province,
                         @PathVariable Long id_cartype){
        Optional<Gender> gender = genderrepository.findById(id_gender);
        Optional<Province> province = provincerepository.findById(id_province);
        Optional<CarType> cartype = cartyperepository.findById(id_cartype);

        Member member = new Member();
        member.setUsername(username);
        member.setPassword(password);
        member.setName(name);
        member.setAddress(address);
        member.setPhone(phone);
        member.setGender(gender.get());
        member.setProvince(province.get());
        member.setCarType(cartype.get());

        return memberrepository.save(member);

    }
}