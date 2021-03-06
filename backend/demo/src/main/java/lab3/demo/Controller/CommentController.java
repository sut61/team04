package lab3.demo.Controller;

import lab3.demo.Repository.*;
import lab3.demo.Entity.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CommentController {

    @Autowired private DriverTaxiRepository driverTaxiRepository;
    @Autowired private DriverRepository driverRepository;
    @Autowired private CommentRepository commentRepository;
    @Autowired private MemberRepository memberRepository;
    @Autowired private ScoreRepository scoreRepository;


    public CommentController(
            DriverTaxiRepository driverTaxiRepository,
            DriverRepository driverRepository,
            CommentRepository commentRepository,
            MemberRepository memberRepository,
            ScoreRepository scoreRepository
            ){
        this.driverTaxiRepository = driverTaxiRepository;
        this.driverRepository = driverRepository;
        this.commentRepository = commentRepository;
        this.memberRepository = memberRepository;
        this.scoreRepository = scoreRepository;

    }

    @GetMapping("Comment")
    public Collection<Comment> comment(){
        return commentRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("Score")
    public Collection<Score> score(){
        return scoreRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping(path = "Comment1/{comment}/{nameDriver}/{nameMamber}/{phoneDriver}/{phoneMamber}/{id_score}/{id_driver}/{id_member}")
    public Comment commnet( @PathVariable String comment,
                            @PathVariable String nameDriver,
                            @PathVariable String nameMamber,
                            @PathVariable String phoneDriver,
                            @PathVariable String phoneMamber,
                            @PathVariable Long id_score,
                            @PathVariable Long id_driver,
                            @PathVariable Long id_member){
        Optional<Driver> driver = driverRepository.findById(id_driver);
        Optional<Score> score = scoreRepository.findById(id_score);
        Optional<Member> member = memberRepository.findById(id_member);


        Comment commnet2 = new Comment();
        commnet2.setComment(comment);
        commnet2.setNameDriver(nameDriver);
        commnet2.setNameMamber(nameMamber);
        commnet2.setPhoneDriver(phoneDriver);
        commnet2.setPhoneMamber(phoneMamber);
        commnet2.setDriver(driver.get());
        commnet2.setScore(score.get());
        commnet2.setMember(member.get());

        return commentRepository.save(commnet2);

    }

    @PostMapping(path = "Comment2/{comment}/{nameDriver}/{nameMamber}/{phoneDriver}/{phoneMamber}/{id_score}/{id_driver}/{id_member}")
    public Comment commnet2(@PathVariable String comment,
                            @PathVariable String nameDriver,
                            @PathVariable String nameMamber,
                            @PathVariable String phoneDriver,
                            @PathVariable String phoneMamber,
                            @PathVariable Long id_score,
                            @PathVariable Long id_driver,
                            @PathVariable Long id_member){
        Optional<DriverTaxi> driverTaxi = driverTaxiRepository.findById(id_driver);
        Optional<Score> score = scoreRepository.findById(id_score);
        Optional<Member> member = memberRepository.findById(id_member);

        Comment commnet2 = new Comment();
        commnet2.setComment(comment);
        commnet2.setNameDriver(nameDriver);
        commnet2.setNameMamber(nameMamber);
        commnet2.setPhoneDriver(phoneDriver);
        commnet2.setPhoneMamber(phoneMamber);
        commnet2.setDriverTaxi(driverTaxi.get());
        commnet2.setScore(score.get());
        commnet2.setMember(member.get());

        return commentRepository.save(commnet2);

    }
}
