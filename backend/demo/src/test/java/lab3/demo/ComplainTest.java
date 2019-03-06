package lab3.demo;

import lab3.demo.Entity.*;
import lab3.demo.Repository.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;


import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;

import static org.assertj.core.api.Fail.fail;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)

@DataJpaTest
public class ComplainTest {


    
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ComplainRepository  complainRepository;
    @Autowired
    private DriverRepository  driverRepository;

    @Autowired
    private MemberRepository  memberRepository;

    private Validator validator;
    private Member member;
    private Driver driver;
    private DriverTaxi driverTaxi;
    private Score score;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }


    //+++++++++++++++++++++++++++++++++++Complain+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    @Test
    public void testComplainTrue() {
        Complain s = new Complain();
        s.setMessage("Very Good");
        s.setMember(member);
        s.setDriver(driver);
        s.setDriverTaxi(driverTaxi);
        try {
            entityManager.persist(s);
            entityManager.flush();
            System.out.println("************************************************* Complain is True *************************************************");
            //fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    @Test
    public void testComplainCannotSize1() {
        Driver d =  driverRepository.getOne(1L);
        Member member =  memberRepository.getOne(1L);


        DriverTaxi dt = new DriverTaxi();
        dt.setName("-*/-*/-*/-*/-*/-*");
        dt.setTel("082753035");
        dt.setAddress("asdasdasdasdasd");
        dt.setEmail("asdasdasdasdasdasd");
        entityManager.persist(dt);


        Complain s = new Complain();
        s.setMessage("Very");
        s.setMember(member);
        s.setDriver(d);
        s.setDriverTaxi(dt);

        try {
            entityManager.persistAndFlush(s);
           // entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 3);
            System.out.println();
            System.out.println("************************************************* testComplainCannotSize *************************************************");
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println("************************************************* testComplainCannotSize *************************************************");
            System.out.println();

        }
    }





    

    @Test
    public void testComplainCannotSize() {
        Member member =  memberRepository.getOne(1L);

        Driver d = new Driver();
        d.setName("3123213213");
        d.setTel("082753035");
        d.setAddress("asdasdasdasdasd");
        d.setEmail("asdasdasdasdasdasd");
        d.setUsername("asdasdasdasdasdasdasdaswwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwdasdwwwwwwwwwww");
        d.setPassword("w");
        entityManager.persist(d);

        DriverTaxi dt = new DriverTaxi();
        dt.setName("-*/-*/-*/-*/-*/-*");
        dt.setTel("082753035");
        dt.setAddress("asdasdasdasdasd");
        dt.setEmail("asdasdasdasdasdasd");
        entityManager.persist(dt);


        Complain s = new Complain();
        s.setMessage("Very");
        s.setMember(member);
        s.setDriver(d);
        s.setDriverTaxi(dt);

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 4);
            System.out.println();
            System.out.println("************************************************* testComplainCannotSize *************************************************");
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println("************************************************* testComplainCannotSize *************************************************");
            System.out.println();

        }
    }


    @Test
    public void testComplainCannotUnique() {
        Complain s = new Complain();
        s.setId(12345678910L);
        s.setMessage("VeryGood");
        s.setMember(member);

        Complain s1 = new Complain();
        s1.setId(12345678910L);
        s1.setMessage("VeryGood");
        s1.setMember(member);


        try {
            entityManager.persist(s1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            System.out.println();
            System.out.println("************************************************* testComplainCannotSize *************************************************");
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println("************************************************* testComplainCannotSize *************************************************");
            System.out.println();

        }catch (javax.persistence.PersistenceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testComplainCannotPattern() {
        Member member =  memberRepository.getOne(1L);

        Complain s = new Complain();
        s.setMessage("/*/-+++-*");
        s.setMember(member);
        



        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println("************************************************* testComplainCannotPattern *************************************************");
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println("************************************************* testComplainCannotPattern *************************************************");
            System.out.println();

        }
    }


    @Test
    public void testComplainCannotPattern1() {
        Driver d = new Driver();
        d.setName("3123213213");
        d.setTel("0512345678");
        d.setAddress("asdasdasdasdasd");
        d.setEmail("asdasdasdasdasdasd");
        d.setUsername("-*/-*/-*/-*");
        d.setPassword("-*/-*/-/-*-*");
        entityManager.persist(d);

        DriverTaxi dt = new DriverTaxi();
        dt.setName("-*/-*/-*/-*/-*/-*");
        dt.setTel("/*-+/*-+/*");
        dt.setAddress("asdasdasdasdasd");
        dt.setEmail("asdasdasdasdasdasd");
        entityManager.persist(dt);



        Complain s = new Complain();
        s.setMessage("/*/-+++-*");
        s.setMember(member);
        s.setDriver(d);
        s.setDriverTaxi(dt);

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 4);
            System.out.println();
            System.out.println("************************************************* testComplainCannotPattern1 *************************************************");
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println("************************************************* testComplainCannotPattern1 *************************************************");
            System.out.println();

        }
    }

    @Test
    public void testComplainCannotPattern2() {
       

        DriverTaxi dt = new DriverTaxi();
        dt.setName("-*/-*/-*/-*/-*/-*");
        dt.setTel("0512345678");
        dt.setAddress("asdasdasdasdasd");
        dt.setEmail("asdasdasdasdasdasd");
        entityManager.persist(dt);

        Complain s = new Complain();
        s.setMessage("/*/-+++-*");
        s.setMember(member);
        s.setDriver(driver);
        s.setDriverTaxi(dt);

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 3);
            System.out.println();
            System.out.println("************************************************* testComplainCannotPattern2 *************************************************");
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println("************************************************* testComplainCannotPattern2 *************************************************");
            System.out.println();

        }
    }





    @Test
    public void testComplainCannotNull() {
        Complain s = new Complain();
        s.setMessage(null);
        s.setMember(null);
        s.setDriver(null);
        s.setDriverTaxi(null);

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            System.out.println();
            System.out.println("************************************************* testComplainCannotNull *************************************************");
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println("************************************************* testComplainCannotNull *************************************************");
            System.out.println();

        }
    }

    //+++++++++++++++++++++++++++++++++++Complain+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
}
