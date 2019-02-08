package lab3.demo;

import lab3.demo.Entity.*;
import lab3.demo.Repository.CommentRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import lab3.demo.Repository.CashPayRepository;

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

	private Validator validator;

	@Before
	public void setup() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void testCommentTrue() {
		Comment s = new Comment();
		s.setComment("eieieieieieieieiei");


		try {
			entityManager.persist(s);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}



	@Test
	public void testCommentCannotBeNull() {
		Comment s = new Comment();
		s.setComment(null);


		try {
			entityManager.persist(s);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}


	@Test
	public void testCommentCannotBeSize() {
		Comment s = new Comment();
		s.setComment("asd");


		try {
			entityManager.persist(s);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 2);
		}
	}


	@Test
	public void testCommentCannotBePattern() {
		Comment s = new Comment();
		s.setComment("-*/-*/-*/-*/-*/-/");


		try {
			entityManager.persist(s);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
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
					

					fail("Should not pass to this line");
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
					assertEquals(violations.size(), 3);
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
					assertEquals(violations.size(), 2);
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

					fail("Should not pass to this line");
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

			


// --------------------------------Test CashPay--------------------------------------------------------

}

