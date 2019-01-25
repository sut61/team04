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
public class ComplainController {
    @Autowired private DriverTaxiRepository driverTaxiRepository;
    @Autowired private DriverRepository driverRepository;
    @Autowired private ComplainRepository complainRepository;
    @Autowired private MemberRepository memberRepository;

    public ComplainController(
            DriverTaxiRepository driverTaxiRepository,
            DriverRepository driverRepository,
            ComplainRepository complainRepository,
            MemberRepository memberRepository){
        this.driverTaxiRepository = driverTaxiRepository;
        this.driverRepository = driverRepository;
        this.complainRepository = complainRepository;
        this.memberRepository = memberRepository;
    }

    @GetMapping("DriverTaxi")
    public Collection<DriverTaxi> driverTaxi(){
        return driverTaxiRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("Complain")
    public Collection<Complain> complain(){
        return complainRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/Complain1/{message}/{id_driver}/{id_member}")
    public Complain complain(
            @PathVariable String message,
            @PathVariable Long id_driver,
            @PathVariable Long id_member){

        Optional<Driver> driver = driverRepository.findById(id_driver);
        Optional<Member> member = memberRepository.findById(id_member);

        Complain complain = new Complain();
        complain.setMessage(message);
        complain.setDriver(driver.get());
        complain.setMember(member.get());


        return complainRepository.save(complain);
    }

    @PostMapping("/Complain2/{message}/{id_drivertaxi}/{id_member}")
    public Complain complain2(
            @PathVariable String message,
            @PathVariable Long id_drivertaxi,
            @PathVariable Long id_member){

        Optional<DriverTaxi> driverTaxi = driverTaxiRepository.findById(id_drivertaxi);
        Optional<Member> member = memberRepository.findById(id_member);

        Complain complain = new Complain();
        complain.setMessage(message);
        complain.setDriverTaxi(driverTaxi.get());
        complain.setMember(member.get());


        return complainRepository.save(complain);
    }

}
