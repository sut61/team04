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
public class ReservecarController {
    @Autowired private CarTypeRepository carTypeRepository;
    @Autowired private DriverRepository driverRepository;
    @Autowired private ReservecarRepository reservecarRepository;
    @Autowired private MemberRepository memberRepository;
    @Autowired private UnavailableRepository unavailableRepository;

    public ReservecarController(
            CarTypeRepository carTypeRepository,
            DriverRepository driverRepository,
            ReservecarRepository reservecarRepository,
            MemberRepository memberRepository,
            UnavailableRepository unavailableRepository){
        this.carTypeRepository = carTypeRepository;
        this.driverRepository = driverRepository;
        this.reservecarRepository = reservecarRepository;
        this.memberRepository = memberRepository;
        this.unavailableRepository = unavailableRepository;
    }

    /*@GetMapping("carType")
    public Collection<CarType> cartype(){
        return carTypeRepository.findAll().stream().collect(Collectors.toList());
    }*/

    @GetMapping("unavailable")
    public Collection<Unavailable> unavailable(){
        return unavailableRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/Reservecar/{dest}/{cur}/{date}/{time}/{id_cartype}/{id_driver}/{id_member}")
    public Reservecar Reservecar(
            @PathVariable String dest,
            @PathVariable String cur,
            @PathVariable String date,
            @PathVariable String time,
            @PathVariable Long id_cartype,
            @PathVariable Long id_driver,
            @PathVariable Long id_member){



        Optional<CarType> cartype = carTypeRepository.findById(id_cartype);
        Optional<Driver> driver = driverRepository.findById(id_driver);
        Optional<Member> member = memberRepository.findById(id_member);

        Reservecar reservecar = new Reservecar();
        reservecar.setDest(dest);
        reservecar.setCur(cur);
        reservecar.setDate(date);
        reservecar.setTime(time);
        reservecar.setCarType(cartype.get());
        reservecar.setDriver(driver.get());
        reservecar.setMember(member.get());


        return reservecarRepository.save(reservecar);
    }

    @PostMapping("/Unavailable/{id_driver}")
    public Unavailable Unavailable(
            @PathVariable Long id_driver){

        Optional<Driver> driver = driverRepository.findById(id_driver);

        Unavailable unavailable = new Unavailable();
        unavailable.setDriver(driver.get());


        return unavailableRepository.save(unavailable);
    }

}
