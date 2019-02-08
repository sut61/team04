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
public class DriverPCTController {
    @Autowired private CareerRepository careerrepository;
    @Autowired private GenderRepository genderrepository;
    @Autowired private ProvinceRepository provincerepository;
    @Autowired private DriverPCTRepository driverpctrepository;

    public DriverPCTController (CareerRepository careerrepository, 
                             GenderRepository genderrepository,
                             ProvinceRepository provincerepository,
                             MemberRepository memberrepository){
        this.careerrepository = careerrepository;
        this.genderrepository = genderrepository;
        this.provincerepository = provincerepository;
        this.driverpctrepository = driverpctrepository;

    }

    @GetMapping("/Career")
    public Collection<Career> career(){
        return careerrepository.findAll().stream().collect(Collectors.toList());
    }
    

    @PostMapping(path = "DriverPCT/{username}/{password}/{name}/{address}/{vehicletype}/{phone}/{id_gender}/{id_province}/{id_career}")
    public DriverPCT driverpct(@PathVariable String username,
                         @PathVariable String password,
                         @PathVariable String name,
                         @PathVariable String address,
                         @PathVariable String vehicletype,
                         @PathVariable String phone,
                         @PathVariable Long id_gender,
                         @PathVariable Long id_province,
                         @PathVariable Long id_career){
        Optional<Gender> gender = genderrepository.findById(id_gender);
        Optional<Province> province = provincerepository.findById(id_province);
        Optional<Career> career = careerrepository.findById(id_career);

        DriverPCT driverpct = new DriverPCT();
        driverpct.setUsername(username);
        driverpct.setPassword(password);
        driverpct.setName(name);
        driverpct.setAddress(address);
        driverpct.setVehicleType(vehicletype);
        driverpct.setPhone(phone);
        driverpct.setGender(gender.get());
        driverpct.setProvince(province.get());
        driverpct.setCareer(career.get());

        return driverpctrepository.save(driverpct);

    }
}