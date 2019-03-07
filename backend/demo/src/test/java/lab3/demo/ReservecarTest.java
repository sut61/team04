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
public class ReservecarTest {
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
    
// --------------------------------Test Reservecar--------------------------------------------------------

	@Test
    public void testCorrectReservecar() {
        Reservecar s = new Reservecar();
        s.setDest("abcdefghijk");
		s.setCur("abcdefghijkl");
		s.setDate(new Date());
        //s.setTime("23.59");
        s.setTime(new Date());
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
    public void testCannotBeNullReservecar() {
        Reservecar s = new Reservecar();
        s.setDest(null);
		s.setCur(null);
		s.setDate(null);
        s.setTime(null);
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
            assertEquals(violations.size(), 7);
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testCannotBeNullReservecar++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testCannotBeNullReservecar++++++++++++++++++++++++++++++");
			System.out.println();
		}
    }

	@Test
    public void testTooShortReservecar() {
        Reservecar s = new Reservecar();
        s.setDest("abc");
		s.setCur("abc");
		s.setDate(new Date());
        //s.setTime("23.59");
        s.setTime(new Date());
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
			System.out.println("++++++++++++++++++++++++++++++testTooShortReservecar++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testTooShortReservecar++++++++++++++++++++++++++++++");
			System.out.println();
        }
    }

	@Test
    public void testTooLongReservecar() {
        Reservecar s = new Reservecar();
        s.setDest("abcdefghijklmnop");
		s.setCur("abcdefghijklmnop");
		s.setDate(new Date());
        //s.setTime("23.59");
        s.setTime(new Date());
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
			System.out.println("++++++++++++++++++++++++++++++testTooLongReservecar++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testTooLongReservecar++++++++++++++++++++++++++++++");
			System.out.println();
        }
    }

	@Test
    public void testPatternReservecar() {
        Reservecar s = new Reservecar();
        s.setDest("/*-467-/");
		s.setCur("/*-784-/");
		s.setDate(new Date());
        //s.setTime("23.59");
        s.setTime(new Date());
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
			System.out.println("++++++++++++++++++++++++++++++testPatternReservecar++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testPatternReservecar++++++++++++++++++++++++++++++");
			System.out.println();
		}
    }

    @Test(expected=javax.persistence.PersistenceException.class)
    public void testUniqueReservecar() {
        Reservecar s1 = new Reservecar();
        s1.setDest("abcdefghijk");
		s1.setCur("abcdefghijk");
        s1.setDate(new Date());
        //s.setTime("23.59");
        s1.setTime(new Date());
        s1.setMember(member);
        s1.setDriver(driver);
        s1.setCarType(carType);
        s1.setId(12345678910L);
        entityManager.persist(s1);
        entityManager.flush();

        Reservecar s2 = new Reservecar();
        s2.setDest("abcdefghijk");
		s2.setCur("abcdefghijk");
        s2.setDate(new Date());
        //s.setTime("23.59");
        s2.setTime(new Date());
        s2.setMember(member);
        s2.setDriver(driver);
        s2.setCarType(carType);
        s2.setId(12345678910L);
        entityManager.persist(s2);
        entityManager.flush();

        fail("Should not pass to this line");
    }

	// --------------------------------Test Reservecar--------------------------------------------------------
}