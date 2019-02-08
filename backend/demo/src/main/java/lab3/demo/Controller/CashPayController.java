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
public class CashPayController {
    @Autowired private GiftRepository giftrepository;
    @Autowired private DriverRepository driverrepository;
    @Autowired private CashPayRepository cashpayrepository;
    @Autowired private MemberRepository memberrepository;

    public CashPayController (GiftRepository giftrepository, 
                                DriverRepository driverpository,
                                CashPayRepository cashpayrepository,
                                MemberRepository memberrepository){
        this.giftrepository = giftrepository;
        this.driverrepository = driverpository;
        this.cashpayrepository = cashpayrepository;
        this.memberrepository = memberrepository;

    }

    // @GetMapping("/Driver")
    // public Collection<Driver> driver(){
    //     return driverrepository.findAll().stream().collect(Collectors.toList());
    // }
    @GetMapping("/Gift")
    public Collection<Gift> gift(){
        return giftrepository.findAll().stream().collect(Collectors.toList());
    }

    // @GetMapping("/Member")
    // public Collection<Member> member(){
    //     return memberrepository.findAll().stream().collect(Collectors.toList());
    // }

    @GetMapping("/cashpay")
    public Collection<CashPay> cashpay(){
        return cashpayrepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping(path = "CashPay/{id_driver}/{distance}/{moneypay}/{change}/{id_member}/{id_gift}")
    public CashPay CashPay(@PathVariable Long id_driver,
                           @PathVariable String distance,
                           @PathVariable String moneypay,
                           @PathVariable String change,
                           @PathVariable Long id_member,
                           @PathVariable Long id_gift){
        Optional<Member> member = memberrepository.findById(id_member);
        Optional<Driver> driver = driverrepository.findById(id_driver);
        Optional<Gift> gift = giftrepository.findById(id_gift);

        CashPay cashpay = new CashPay();
        cashpay.setDriver(driver.get());
        cashpay.setDistance(distance);
        cashpay.setMoneypay(moneypay);
        cashpay.setChange(change);
        cashpay.setMember(member.get());
        cashpay.setGift(gift.get());

        return cashpayrepository.save(cashpay);

    }

    @PostMapping(path = "CashPay2/{id_driver}/{distance}/{moneypay}/{change}")
    public CashPay CashPay(@PathVariable Long id_driver,
                           @PathVariable String distance,
                           @PathVariable String moneypay,
                           @PathVariable String change){
       
        Optional<Driver> driver = driverrepository.findById(id_driver);
        

        CashPay cashpay = new CashPay();
        cashpay.setDriver(driver.get());
        cashpay.setDistance(distance);
        cashpay.setMoneypay(moneypay);
        cashpay.setChange(change);
       
        return cashpayrepository.save(cashpay);

    }
}