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
import java.util.Date;

import static org.assertj.core.api.Fail.fail;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)

@DataJpaTest
public class CallcarTest {
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
    private CallcarRepository callcarRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private CarTypeRepository carTypeRepository;

	private Validator validator;
	private Member member;
	private Driver driver;
    private CarType carType;

	@Before
	public void setup() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

    //+++++++++++++++++++++++++++++++++++TestCallcar+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	@Test
    public void testCorrectCallcar() {
        Callcar s = new Callcar();
        s.setDest("abcdefghijk");
		s.setCur("abcdefghijkl");
        s.setMember(member);
        s.setDriver(driver);
        s.setCarType(carType);


        try {
            entityManager.persist(s);
            entityManager.flush();

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 3);
		}
    }

	@Test
    public void testCannotBeNullCallcar() {
        Callcar s = new Callcar();
        s.setDest(null);
		s.setCur(null);
        s.setMember(null);
        s.setDriver(null);
        s.setCarType(null);


        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 5);
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testCannotBeNullCallcar++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testCannotBeNullCallcar++++++++++++++++++++++++++++++");
			System.out.println();
		}
    }

	@Test
    public void testTooShortCallcar() {
        Callcar s = new Callcar();
        s.setDest("abc");
		s.setCur("abc");
        s.setMember(member);
        s.setDriver(driver);
        s.setCarType(carType);

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 5);
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testTooShortCallcar++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testTooShortCallcar++++++++++++++++++++++++++++++");
			System.out.println();
        }
    }

	@Test
    public void testTooLongCallcar() {
        Callcar s = new Callcar();
        s.setDest("abcdefghijklmnop");
		s.setCur("abcdefghijklmnop");
        s.setMember(member);
        s.setDriver(driver);
        s.setCarType(carType);

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 5);
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testTooLongCallcar++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testTooLongCallcar++++++++++++++++++++++++++++++");
			System.out.println();
        }
    }

    @Test
    public void testPatternCallcar() {
        Callcar s = new Callcar();
        s.setDest("/*-789-/");
		s.setCur("/*-789-/");
        s.setMember(member);
        s.setDriver(driver);
        s.setCarType(carType);


        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 7);
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testPatternCallcarcar++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testPatternCallcarcar++++++++++++++++++++++++++++++");
			System.out.println();
		}
    }

    /* @Test
    public void testUniqueCallcar() {
        Callcar s = new Callcar();
        s.setDest("abcdefghijklmnop");
		s.setCur("abcdefghijklmnop");
        s.setMember(member);
        s.setDriver(driver);
        s.setCarType(carType);
        s.setId(12345678910L);

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 5);
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testTooLongCallcar++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testTooLongCallcar++++++++++++++++++++++++++++++");
			System.out.println();
        }
    } */

    @Test(expected=javax.persistence.PersistenceException.class)
    public void testUniqueCallcar() {
        Callcar s1 = new Callcar();
        s1.setDest("abcdefghijklmnop");
		s1.setCur("abcdefghijklmnop");
        s1.setMember(member);
        s1.setDriver(driver);
        s1.setCarType(carType);
        s1.setId(12345678910L);
        entityManager.persist(s1);
        entityManager.flush();

        Callcar s2 = new Callcar();
        s2.setDest("abcdefghijklmnop");
		s2.setCur("abcdefghijklmnop");
        s2.setMember(member);
        s2.setDriver(driver);
        s2.setCarType(carType);
        s2.setId(12345678910L);
        entityManager.persist(s2);
        entityManager.flush();

        fail("Should not pass to this line");
    }
	//+++++++++++++++++++++++++++++++++++TestCallcar+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
}