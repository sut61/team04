package lab3.demo;

import lab3.demo.Entity.*;
import lab3.demo.Repository.CommentRepository;
import lab3.demo.Repository.EmergencyRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import lab3.demo.Repository.CashPayRepository;
import lab3.demo.Repository.ReservecarRepository;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;

import static org.assertj.core.api.Fail.fail;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)

@DataJpaTest
public class DemoApplicationTests {
	@Autowired
	private CommentRepository  commentRepository;

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private CashPayRepository cashpayRepository;

	@Autowired
	private EmergencyRepository emergencyRepository;

	@Autowired
    private ReservecarRepository reservecarRepository;


	private Validator validator;

	@Before
	public void setup() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

// --------------------------------Test CashPay--------------------------------------------------------

		@Test
			public void testCorrect() {
				CashPay c = new CashPay();
				c.setDistance("20");
				c.setMoneypay("30");
				c.setChange("10");

				try {
					entityManager.persist(c);
					entityManager.flush();

					//fail("Should not pass to this line");
				} catch(javax.validation.ConstraintViolationException e) {
					Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
					assertEquals(violations.isEmpty(), false);
					assertEquals(violations.size(), 2);
				}
			}


			@Test
			public void testDistanceCannotBeNull() {
				CashPay c = new CashPay();

				c.setDistance(null);
				c.setMoneypay("55");
				c.setChange("3");

				try {
					entityManager.persist(c);
					entityManager.flush();

					fail("Should not pass to this line");
				} catch(javax.validation.ConstraintViolationException e) {
					Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
					assertEquals(violations.isEmpty(), false);
					assertEquals(violations.size(), 1);
					System.out.println();
					System.out.println("++++++++++++++++++++++++++++++testDistanceCannotBeNull++++++++++++++++++++++++++++++");
					System.out.println();
					System.out.println(e.getMessage());
					System.out.println();
					System.out.println("++++++++++++++++++++++++++++++testDistanceCannotBeNull++++++++++++++++++++++++++++++");
					System.out.println();
				}
			}


			@Test
			public void testCointnotnecative() {

				CashPay c = new CashPay();
				c.setDistance("55");
				c.setMoneypay("20");
				c.setChange("-10");

				try {
					entityManager.persist(c);
					entityManager.flush();

					fail("Should not pass to this line");
				} catch(javax.validation.ConstraintViolationException e) {
					Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
					assertEquals(violations.isEmpty(), false);
					assertEquals(violations.size(), 1);
					System.out.println();
					System.out.println("++++++++++++++++++++++++++++++testCointnotnecative++++++++++++++++++++++++++++++");
					System.out.println();
					System.out.println(e.getMessage());
					System.out.println();
					System.out.println("++++++++++++++++++++++++++++++testCointnotnecative++++++++++++++++++++++++++++++");
					System.out.println();
				}
			}

			@Test
			public void testMoneyNotOverSize() {
				CashPay c = new CashPay();
				c.setDistance("55");
				c.setMoneypay("20555");
				c.setChange("10");

				try {
					entityManager.persist(c);
					entityManager.flush();

					//fail("Should not pass to this line");
				} catch(javax.validation.ConstraintViolationException e) {
					Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
					assertEquals(violations.isEmpty(), false);
					assertEquals(violations.size(), 3);
					System.out.println();
					System.out.println("++++++++++++++++++++++++++++++testMoneyNotOverSize++++++++++++++++++++++++++++++");
					System.out.println();
					System.out.println(e.getMessage());
					System.out.println();
					System.out.println("++++++++++++++++++++++++++++++testMoneyNotOverSize++++++++++++++++++++++++++++++");
					System.out.println();
				}
			}

			public void testChangePattern() {
				CashPay c = new CashPay();
				c.setDistance("55");
				c.setMoneypay("20");
				c.setChange("0254165");

				try {
					entityManager.persist(c);
					entityManager.flush();

					fail("Should not pass to this line");
				} catch(javax.validation.ConstraintViolationException e) {
					Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
					assertEquals(violations.isEmpty(), false);
					assertEquals(violations.size(), 1);
					System.out.println();
					System.out.println("++++++++++++++++++++++++++++++testChangePattern++++++++++++++++++++++++++++++");
					System.out.println();
					System.out.println(e.getMessage());
					System.out.println();
					System.out.println("++++++++++++++++++++++++++++++testChangePattern++++++++++++++++++++++++++++++");
					System.out.println();
				}
			}
    // --------------------------------Test Emergency--------------------------------------------------------

	@Test
	public void testTrueEmergency() {
		Emergency em = new Emergency();
		em.setPosition("3/440");
		em.setPhone("0949366256");


		try {
			entityManager.persist(em);
			entityManager.flush();

			//fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 2);
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


        try {
            entityManager.persist(em);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
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

	// --------------------------------Test Reservecar--------------------------------------------------------

	@Test
    public void testCorrectReservecar() {
        Reservecar s = new Reservecar();
        s.setDest("abcdefghijk");
		s.setCur("abcdefghijkl");
		s.setDate("31-12-19");
        s.setTime("23:59");
        

        try {
            entityManager.persist(s);
            entityManager.flush();

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
		}
    }

	@Test
    public void testCannotBeNullReservecar() {
        Reservecar s = new Reservecar();
        s.setDest(null);
		s.setCur(null);
		s.setDate(null);
        s.setTime(null);
        

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 4);
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
		s.setDate("31-12-19");
        s.setTime("23:59");
        

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
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
		s.setDate("31-12-19");
        s.setTime("23:59");
        

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
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
        s.setDest("abcdefghijk");
		s.setCur("abcdefghijk");
		s.setDate("31/12/19");
        s.setTime("23.59");
        

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testPatternReservecar++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testPatternReservecar++++++++++++++++++++++++++++++");
			System.out.println();
		}
    }

	// --------------------------------Test Reservecar--------------------------------------------------------
}

