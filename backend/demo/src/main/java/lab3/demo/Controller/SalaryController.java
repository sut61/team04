package lab3.demo.Controller;
import lab3.demo.Entity.*;
import lab3.demo.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SalaryController {
    @Autowired private SalaryRepository salaryRepository;
    @Autowired private DriverRepository driverRepository;
    @Autowired private PositionRepository positionRepository;
    @Autowired private AdminRepository adminRepository;

    public SalaryController(
            SalaryRepository salaryRepository,
            DriverRepository driverRepository,
            PositionRepository positionRepository,
            AdminRepository adminRepository){
        this.salaryRepository = salaryRepository;
        this.driverRepository = driverRepository;
        this.positionRepository = positionRepository;
        this.adminRepository = adminRepository;
    }

    @GetMapping("salary")
    public Collection<Salary> salary(){
        return salaryRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("position")
    public Collection<Position> position(){ 
        return positionRepository.findAll().stream().collect(Collectors.toList());
    }

    
    @PostMapping("/Salary/{nameAdmin}/{nameDriver}/{namePosition}/{phoneDriver}/{date}/{price}/{payment}/{id_admin}/{id_driver}/{id_position}")
    public Salary Salary(
            
            @PathVariable String nameAdmin,
            @PathVariable String nameDriver,
            @PathVariable String namePosition,
            @PathVariable String phoneDriver,
            @PathVariable Date date,
            @PathVariable int price,
            @PathVariable String payment,
            @PathVariable Long id_admin,
            @PathVariable Long id_driver,
            @PathVariable Long id_position   ){



        Optional<Admin> admin = adminRepository.findById(id_admin);
        Optional<Driver> driver = driverRepository.findById(id_driver);
        Optional<Position> position = positionRepository.findById(id_position);

        Salary salary = new Salary();
        
        salary.setNameAdmin(nameAdmin);
        salary.setNameDriver(nameDriver);
        salary.setNamePosition(namePosition);
        salary.setPhoneDriver(phoneDriver);
        salary.setDate(date);
        salary.setPrice(price);
        salary.setPayment(payment);
        salary.setAdmin(admin.get());
        salary.setDriver(driver.get());
        salary.setPosition(position.get());
       


        return salaryRepository.save(salary);
    }

}
