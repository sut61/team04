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
@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public class DiscountController {
    @Autowired private CarTypeRepository carTypeRepository;
    @Autowired private TimeRangeRepository timeRangeRepository;
    @Autowired private DiscountRepository discountrepository;
    @Autowired private AdminRepository adminrepository;

    public DiscountController (CarTypeRepository carTypeRepository,
                               TimeRangeRepository timeRangeRepository,
                               DiscountRepository discountrepository,
                               AdminRepository adminrepository){
        this.carTypeRepository = carTypeRepository;
        this.timeRangeRepository = timeRangeRepository;
        this.discountrepository = discountrepository;
        this.adminrepository = adminrepository;

    }
    
    @GetMapping("timeRange")
    public Collection<TimeRange> timeRange(){
        return timeRangeRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("discount")
    public Collection<Discount> discount(){ return discountrepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("admin")
    public Collection<Admin> admin(){
        return adminrepository.findAll().stream().collect(Collectors.toList());
    }
    @PostMapping("/Discount/{id_admin}/{id_cartype}/{promotion}/{date}/{id_timeRange}/{price}")
    public Discount Discount(
            @PathVariable Long id_admin,
            @PathVariable Long id_cartype,
            @PathVariable String promotion,
            @PathVariable Date date,
            @PathVariable Long id_timeRange,
            @PathVariable Integer price){



             
        Optional<Admin> admin = adminrepository.findById(id_admin);
        Optional<CarType> carType = carTypeRepository.findById(id_cartype);
        Optional<TimeRange> timeRange = timeRangeRepository.findById(id_timeRange);
        

        Discount discount = new Discount();
        discount.setAdmin(admin.get());
        discount.setCarType(carType.get());
        discount.setPromotion(promotion);
        discount.setDate(date);
        discount.setTimeRange(timeRange.get());
        discount.setPrice(price);
        

        return discountrepository.save(discount);
    }

}
