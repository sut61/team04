package lab3.demo.Controller;

import lab3.demo.Entity.*;

import lab3.demo.Repository.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import java.util.Optional;
import java.util.stream.Collectors;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DriverController {
    @Autowired private CarTypeRepository carTypeRepository;
    @Autowired private DriverRepository driverRepository;
    @Autowired private ProvinceRepository provinceRepository;
    @Autowired private GenderRepository genderRepository;

    public DriverController(
            CarTypeRepository carTypeRepository,
            DriverRepository driverRepository,
            ProvinceRepository provinceRepository,
            GenderRepository genderRepository){
        this.carTypeRepository = carTypeRepository;
        this.driverRepository = driverRepository;
        this.provinceRepository = provinceRepository;
        this.genderRepository = genderRepository;
    }

    @GetMapping("carType")
    public Collection<CarType> cartype(){
        return carTypeRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("driver")
    public Collection<Driver> driver(){
        return driverRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("province")
    public Collection<Province> province(){ return provinceRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("gender")
    public Collection<Gender> genders(){
        return genderRepository.findAll().stream().collect(Collectors.toList());
    }
    @PostMapping("/Driver/{id_gender}/{id_province}/{id_cartype}/{name}/{tel}/{address}/{email}")
    public Driver Driver(
            @PathVariable Long id_gender,
            @PathVariable Long id_province,
            @PathVariable Long id_cartype,
            @PathVariable String name,
            @PathVariable Long tel,
            @PathVariable String address,
            @PathVariable String email){



        Optional<Gender> gender = genderRepository.findById(id_gender);
        Optional<Province> province = provinceRepository.findById(id_province);
        Optional<CarType> carType = carTypeRepository.findById(id_cartype);

        Driver driver = new Driver();
        driver.setGender(gender.get());
        driver.setProVince(province.get());
        driver.setCarType(carType.get());
        driver.setName(name);
        driver.setTel(tel);
        driver.setAddress(address);
        driver.setEmail(email);


        return driverRepository.save(driver);
    }

}
