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
public class CallcarController {
    @Autowired private CarTypeRepository carTypeRepository;
    @Autowired private DriverRepository driverRepository;
    @Autowired private CallcarRepository callcarRepository;
    @Autowired private MemberRepository memberRepository;

    public CallcarController(
            CarTypeRepository carTypeRepository,
            DriverRepository driverRepository,
            CallcarRepository callcarRepository,
            MemberRepository memberRepository){
        this.carTypeRepository = carTypeRepository;
        this.driverRepository = driverRepository;
        this.callcarRepository = callcarRepository;
        this.memberRepository = memberRepository;
    }

    /*@GetMapping("carType")
    public Collection<CarType> cartype(){
        return carTypeRepository.findAll().stream().collect(Collectors.toList());
    }*/

    /*@GetMapping("callcar")
    public Collection<Callcar> callcar(){
        return callcarRepository.findAll().stream().collect(Collectors.toList());
    }*/

    @PostMapping("/Callcar/{dest}/{cur}/{id_cartype}/{id_driver}/{id_member}")
    public Callcar Callcar(
            @PathVariable String dest,
            @PathVariable String cur,
            @PathVariable Long id_cartype,
            @PathVariable Long id_driver,
            @PathVariable Long id_member){



        Optional<CarType> cartype = carTypeRepository.findById(id_cartype);
        Optional<Driver> driver = driverRepository.findById(id_driver);
        Optional<Member> member = memberRepository.findById(id_member);

        Callcar callcar = new Callcar();
        callcar.setDest(dest);
        callcar.setCur(cur);
        callcar.setCarType(cartype.get());
        callcar.setDriver(driver.get());
        callcar.setMember(member.get());


        return callcarRepository.save(callcar);
    }

}
