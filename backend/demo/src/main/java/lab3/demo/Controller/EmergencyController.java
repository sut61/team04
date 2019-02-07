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
public class EmergencyController {
    @Autowired private CauseRepository causeRepository;
    @Autowired private DriverRepository driverRepository;
    @Autowired private PriceTypeRepository priceTypeRepository;
    @Autowired private MemberRepository memberRepository;
    @Autowired private EmergencyRepository emergencyRepository;

    public EmergencyController(
        CauseRepository causeRepository,
        DriverRepository driverRepository,
        PriceTypeRepository priceTypeRepository,
        MemberRepository memberRepository,
        EmergencyRepository emergencyRepository){

    this.causeRepository = causeRepository;
    this.driverRepository = driverRepository;
    this. priceTypeRepository =  priceTypeRepository;
    this.memberRepository = memberRepository;
    this.emergencyRepository = emergencyRepository;
}

@GetMapping("cause")
public Collection<Cause> cause(){
    return causeRepository.findAll().stream().collect(Collectors.toList());
}

@GetMapping("priceType")
public Collection<PriceType> priceType(){
    return priceTypeRepository.findAll().stream().collect(Collectors.toList());
}

@GetMapping("emergency")
public Collection<Emergency> emergency(){
    return emergencyRepository.findAll().stream().collect(Collectors.toList());
}

@PostMapping(path = "Emergency/{position}/{phone}/{id_cause}/{id_member}/{id-driver}/{id_priceType}")
public Emergency Emergency(
                     @PathVariable String position,
                     @PathVariable String phone,
                     @PathVariable Long id_cause,
                     @PathVariable Long id_member,
                     @PathVariable Long id_driver,
                     @PathVariable Long id_priceType) {

    Optional<Cause> cause = causeRepository.findById(id_cause);
    Optional<PriceType> priceType = priceTypeRepository.findById(id_priceType);
    Optional<Driver> driver = driverRepository.findById(id_driver);
    Optional<Member> member = memberRepository.findById(id_member);

    Emergency emergency = new Emergency();
    emergency.setPosition(position);
    emergency.setPhone(phone);
    emergency.setCause(cause.get());
    emergency.setPriceType(priceType.get());
    emergency.setDriver(driver.get());
    emergency.setMember(member.get());

    return emergencyRepository.save(emergency);


    }
}
