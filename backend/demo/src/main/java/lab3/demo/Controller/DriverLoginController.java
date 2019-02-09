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
public class DriverLoginController {
    @Autowired private DriverLoginRepository driverLoginRepository;
    @Autowired private DriverRepository driverRepository;

    public DriverLoginController (  DriverLoginRepository memberLoginRepository,
                                    MemberRepository memberRepository ,
                                    DriverRepository driverrepository
    ){

        this.driverLoginRepository = driverLoginRepository;
        this.driverRepository = driverRepository;
    }

    @GetMapping("/logindriver")
    public Collection<DriverLogin> driverLogin(){
        return driverLoginRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping(path = "LoginDriver/{id_driver}")
    public DriverLogin DriverLogin(@PathVariable Long id_driver){
        Optional<Driver> driver = driverRepository.findById(id_driver);

        DriverLogin driverLogin = new DriverLogin();
        driverLogin.setDriver(driver.get());

        return driverLoginRepository.save(driverLogin);

    }

    @DeleteMapping(path = "DriverMember/{id_driver}")
    public String Driver(@PathVariable Long id_Driver){
        driverLoginRepository.deleteById(id_Driver);
        return "complete";
    }






}