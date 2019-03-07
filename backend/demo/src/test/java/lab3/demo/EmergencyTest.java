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
public class EmergencyTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CauseRepository  causeRepository;

    @Autowired
    private DriverRepository  driverRepository;

    @Autowired
    private PriceTypeRepository  priceTypeRepository;

    @Autowired
    private MemberRepository  memberRepository;

    private Validator validator;
    private Cause cause;
    private PriceType priceType;
    private Driver driver;
    private Member member;


    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    // --------------------------------Test Emergency--------------------------------------------------------

    @Test
    public void testTrueEmergency() {
        Emergency em = new Emergency();
        em.setPosition("3/440");
        em.setPhone("0949366256");
        em.setCause(cause);
        em.setPriceType(priceType);
        em.setDriver(driver);
        em.setMember(member);


        try {
            entityManager.persist(em);
            entityManager.flush();

            //fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println("++++++++++++++++++++++++++++++testTrueEmergency++++++++++++++++++++++++++++++");
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println("++++++++++++++++++++++++++++++testTrueEmergency++++++++++++++++++++++++++++++");
            System.out.println();
        }
    }

    @Test
    public void testSizePosition() {
        Emergency em = new Emergency();
        em.setPosition("a");
        em.setPhone("0949366256");
        em.setCause(cause);
        em.setPriceType(priceType);
        em.setDriver(driver);
        em.setMember(member);


        try {
            entityManager.persist(em);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println("++++++++++++++++++++++++++++++testSizePosition++++++++++++++++++++++++++++++");
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println("++++++++++++++++++++++++++++++testSizePosition++++++++++++++++++++++++++++++");
            System.out.println();
        }
    }

    @Test
    public void testPatternPhone() {
        Emergency em = new Emergency();
        em.setPosition("3/440");
        em.setPhone("0749366256");
        em.setCause(cause);
        em.setPriceType(priceType);
        em.setDriver(driver);
        em.setMember(member);


        try {
            entityManager.persist(em);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            System.out.println();
            System.out.println("++++++++++++++++++++++++++++++testPatternPhone++++++++++++++++++++++++++++++");
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println("++++++++++++++++++++++++++++++testPatternPhone++++++++++++++++++++++++++++++");
            System.out.println();
        }
    }

    @Test
    public void testSizePhone() {
        Emergency em = new Emergency();
        em.setPosition("3/440");
        em.setPhone("09");
        em.setCause(cause);
        em.setPriceType(priceType);
        em.setDriver(driver);
        em.setMember(member);

        try {
            entityManager.persist(em);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 3);
            System.out.println();
            System.out.println("++++++++++++++++++++++++++++++testSizePhone++++++++++++++++++++++++++++++");
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println("++++++++++++++++++++++++++++++testSizePhone++++++++++++++++++++++++++++++");
            System.out.println();
        }
    }

    @Test
    public void testNullPhone() {
        Emergency em = new Emergency();
        em.setPosition("3/440");
        em.setPhone(null);
        em.setCause(cause);
        em.setPriceType(priceType);
        em.setDriver(driver);
        em.setMember(member);

        try {
            entityManager.persist(em);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            System.out.println();
            System.out.println("++++++++++++++++++++++++++++++testNullPhone++++++++++++++++++++++++++++++");
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println("++++++++++++++++++++++++++++++testNullPhone++++++++++++++++++++++++++++++");
            System.out.println();
        }
    }

    @Test
    public void testEmergencyCannotUnique() {
        Emergency em = new Emergency();
        em.setPosition("3/440");
        em.setPhone("0949366256");
        em.setCause(cause);
        em.setPriceType(priceType);
        em.setDriver(driver);
        em.setMember(member);
        em.setId(12345678910L);

        Emergency em1 = new Emergency();
        em1.setPosition("3/440");
        em1.setPhone("0949366256");
        em1.setCause(cause);
        em1.setPriceType(priceType);
        em1.setDriver(driver);
        em1.setMember(member);
        em1.setId(12345678910L);



        try {
            entityManager.persist(em1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            System.out.println();
            System.out.println("************************************************* testEmergencyCannotUnique *************************************************");
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println("************************************************* testEmergencyCannotUnique *************************************************");
            System.out.println();

        }catch (javax.persistence.PersistenceException e) {
            e.printStackTrace();
        }
    }


}
