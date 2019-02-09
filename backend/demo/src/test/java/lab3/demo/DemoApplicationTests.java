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
public class DemoApplicationTests {
	@Autowired
	private CommentRepository  commentRepository;

	@Autowired
	private ComplainRepository  complainRepository;

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private CashPayRepository cashpayRepository;

	@Autowired
	private EmergencyRepository emergencyRepository;

	@Autowired
    private ReservecarRepository reservecarRepository;

	@Autowired
    private CallcarRepository carcarRepository;


	private Validator validator;

	@Before
	public void setup() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

/* // --------------------------------Test CashPay--------------------------------------------------------

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
			} */
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

	// =================================moss Thirawuth=========================================================

	//+++++++++++++++++++++++++++++++++++Comment+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	@Test
    public void testCommentTrue() {
        Comment s = new Comment();
        s.setComment("Very Good");
		s.setNameDriver("Hassad");
		s.setNameMamber("moss thirawuth");
        s.setPhoneDriver("0812345678");
        s.setPhoneMamber("0912345678");

        try {
            entityManager.persist(s);
            entityManager.flush();
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Comment is True %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            //fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
			
		}
	}
	

	@Test
    public void testCommentCannotSize() {
        Comment s = new Comment();
        s.setComment("Very");
		s.setNameDriver("asdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasd");
		s.setNameMamber("asdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasd");
        s.setPhoneDriver("08123456780");
        s.setPhoneMamber("09123456780");

        try {
            entityManager.persist(s);
            entityManager.flush();
			
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 5);
			System.out.println();
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% testCommentNotSize %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% testCommentNotSize %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			System.out.println();
			
		}
	}

	@Test
    public void testCommentCannotPattern() {
        Comment s = new Comment();
        s.setComment("/*-789-/");
		s.setNameDriver("/*-89");
		s.setNameMamber("/*896");
        s.setPhoneDriver("0512345678");
        s.setPhoneMamber("0512345678");

        try {
            entityManager.persist(s);
            entityManager.flush();
			
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 5);
			System.out.println();
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% testCommentNotPattern %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% testCommentNotPattern %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			System.out.println();
			
		}
	}

	@Test
    public void testCommentCannotNull() {
        Comment s = new Comment();
        s.setComment(null);
		s.setNameDriver(null);
		s.setNameMamber(null);
        s.setPhoneDriver(null);
        s.setPhoneMamber(null);

        try {
            entityManager.persist(s);
            entityManager.flush();
			
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 5);
			System.out.println();
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% testCommentNotNull %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% testCommentNotNull %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			System.out.println();
			
		}
	}
	
		//+++++++++++++++++++++++++++++++++++Comment+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		//+++++++++++++++++++++++++++++++++++Complain+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		@Test
		public void testComplainTrue() {
			Complain s = new Complain();
			s.setMessage("Very Good");
			
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
		public void testComplainCannotSize() {
			Complain s = new Complain();
			s.setMessage("Very");
			
			try {
				entityManager.persist(s);
				entityManager.flush();
				
				fail("Should not pass to this line");
			} catch(javax.validation.ConstraintViolationException e) {
				Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
				assertEquals(violations.isEmpty(), false);
				assertEquals(violations.size(), 1);
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
		public void testComplainCannotPattern() {
			Complain s = new Complain();
			s.setMessage("/*/-+++-*");
			
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
		public void testComplainCannotNull() {
			Complain s = new Complain();
			s.setMessage(null);
			
			try {
				entityManager.persist(s);
				entityManager.flush();
				
				fail("Should not pass to this line");
			} catch(javax.validation.ConstraintViolationException e) {
				Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
				assertEquals(violations.isEmpty(), false);
				assertEquals(violations.size(), 1);
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

			// =================================moss Thirawuth=========================================================
	
	//+++++++++++++++++++++++++++++++++++TestCallcar+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	@Test
    public void testCorrectCallcar() {
        Callcar s = new Callcar();
        s.setDest("abcdefghijk");
		s.setCur("abcdefghijkl");
        

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
    public void testCannotBeNullCallcar() {
        Callcar s = new Callcar();
        s.setDest(null);
		s.setCur(null);
        

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
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
        

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
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
        

        try {
            entityManager.persist(s);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testTooLongCallcar++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testTooLongCallcar++++++++++++++++++++++++++++++");
			System.out.println();
        }
    }

	//+++++++++++++++++++++++++++++++++++TestCallcar+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// --------------------------------Test Driver--------------------------------------------------------
    @Test
    public void testTrueDriver() {
        Driver d = new Driver();
        d.setName("Anuttapon");
        d.setTel("0949366256");
        d.setAddress("3440000000000000");
        d.setEmail("Anuttapon@dsdsds.com");


        try {
            entityManager.persist(d);
            entityManager.flush();

            //fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println("++++++++++++++++++++++++++++++testTrueDriver++++++++++++++++++++++++++++++");
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println("++++++++++++++++++++++++++++++testTrueDriver++++++++++++++++++++++++++++++");
            System.out.println();
        }
    }

    @Test
    public void testPatternName() {
        Driver d = new Driver();
        d.setName("********");
        d.setTel("0949366256");
        d.setAddress("3440000000000000");
        d.setEmail("Anuttapon@dsdsds.com");


        try {
            entityManager.persist(d);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            System.out.println();
            System.out.println("++++++++++++++++++++++++++++++testPatternName++++++++++++++++++++++++++++++");
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println("++++++++++++++++++++++++++++++testPatternName++++++++++++++++++++++++++++++");
            System.out.println();
        }
    }

    @Test
    public void testSizeTel() {
        Driver d = new Driver();
        d.setName("Anuttapon");
        d.setTel("094936625666");
        d.setAddress("3440000000000000");
        d.setEmail("Anuttapon@dsdsds.com");


        try {
            entityManager.persist(d);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            System.out.println();
            System.out.println("++++++++++++++++++++++++++++++testSizeTel++++++++++++++++++++++++++++++");
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println("++++++++++++++++++++++++++++++testSizeTel++++++++++++++++++++++++++++++");
            System.out.println();
        }
    }

    @Test
    public void testSizeAddress() {
        Driver d = new Driver();
        d.setName("Anuttapon");
        d.setTel("0949366256");
        d.setAddress("a");
        d.setEmail("Anuttapon@dsdsds.com");


        try {
            entityManager.persist(d);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            System.out.println();
            System.out.println("++++++++++++++++++++++++++++++testSizeAddress++++++++++++++++++++++++++++++");
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println("++++++++++++++++++++++++++++++testSizeAddress++++++++++++++++++++++++++++++");
            System.out.println();
        }
    }


    @Test
    public void testPatternEmail() {
        Driver d = new Driver();
        d.setName("Anuttapon");
        d.setTel("0949366256");
        d.setAddress("3440000000000000");
        d.setEmail("Anuttapondsdsds");


        try {
            entityManager.persist(d);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            System.out.println();
            System.out.println("++++++++++++++++++++++++++++++testPatternEmail++++++++++++++++++++++++++++++");
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println("++++++++++++++++++++++++++++++testPatternEmail++++++++++++++++++++++++++++++");
            System.out.println();
        }
    }

    @Test
    public void testNullName() {
        Driver d = new Driver();
        d.setName(null);
        d.setTel("0949366256");
        d.setAddress("3440000000000000");
        d.setEmail("Anuttapon@dsdsds.com");


        try {
            entityManager.persist(d);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            System.out.println();
            System.out.println("++++++++++++++++++++++++++++++testNullName++++++++++++++++++++++++++++++");
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println("++++++++++++++++++++++++++++++testNullName++++++++++++++++++++++++++++++");
            System.out.println();
        }
    }
    // --------------------------------Test Driver--------------------------------------------------------
}

