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
public class OnlinePayController {
    @Autowired private BankRepository bankrepository;
    @Autowired private MemberRepository memberrepository;
    @Autowired private DriverRepository driverrepository;
    @Autowired private OnlinePayRepository onlinepayrepository;

    public OnlinePayController (BankRepository bankrepository, 
                                DriverRepository driverpository,
                                OnlinePayRepository onlinepayrepository,
                                MemberRepository memberrepository){
        this.bankrepository = bankrepository;
        this.driverrepository = driverpository;
        this.onlinepayrepository = onlinepayrepository;
        this.memberrepository = memberrepository;

    }

    @GetMapping("/Driver")
    public Collection<Driver> driver(){
        return driverrepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/Bank")
    public Collection<Bank> bank(){
        return bankrepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/Member")
    public Collection<Member> member(){
        return memberrepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping(path = "OnlinePay/{distance}/{moneypay}/{id_member}/{id_driver}/{id_bank}")
    public OnlinePay OnlinePay(@PathVariable int distance,
                          @PathVariable int moneypay,
                         @PathVariable Long id_member,
                         @PathVariable Long id_driver,
                         @PathVariable Long id_bank){
        Optional<Member> member = memberrepository.findById(id_member);
        Optional<Driver> driver = driverrepository.findById(id_driver);
        Optional<Bank> bank = bankrepository.findById(id_bank);

        OnlinePay onlinepay = new OnlinePay();
        onlinepay.setDistance(distance);
        onlinepay.setMoneypay(moneypay);
        onlinepay.setMember(member.get());
        onlinepay.setDriver(driver.get());
        onlinepay.setBank(bank.get());

        return onlinepayrepository.save(onlinepay);

    }
}