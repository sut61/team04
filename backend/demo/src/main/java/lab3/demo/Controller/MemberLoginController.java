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
public class MemberLoginController {
    @Autowired private MemberLoginRepository memberLoginRepository;
    @Autowired private MemberRepository memberRepository;

    public MemberLoginController (  MemberLoginRepository memberLoginRepository,
                                    MemberRepository memberRepository ,
                                    DriverRepository driverrepository
                                 ){

        this.memberLoginRepository = memberLoginRepository;
        this.memberRepository = memberRepository;
    }

    @GetMapping("/loginmember")
    public Collection<MemberLogin> memberLogin(){
        return memberLoginRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping(path = "LoginMember1/{id_member}")
    public MemberLogin MemberLogin(@PathVariable Long id_member){
        Optional<Member> member = memberRepository.findById(id_member);
        
        MemberLogin memberLogin = new MemberLogin();
            memberLogin.setMember(member.get());

        return memberLoginRepository.save(memberLogin);

    }

    @DeleteMapping(path = "LoginMember/{id_member}")
    public String Customer(@PathVariable Long id_Member){
        memberLoginRepository.deleteById(id_Member);
        return "complete";
    }
    


    

    
}