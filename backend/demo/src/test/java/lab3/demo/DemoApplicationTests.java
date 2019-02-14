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

    @Autowired
    private SalaryRepository salaryRepository;

    @Autowired
    private DiscountRepository discountRepository;

	private Validator validator;

	@Before
	public void setup() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

 // --------------------------------Test CashPay--------------------------------------------------------

		@Test
			public void testCashPayCorrect() {
                CashPay c = new CashPay();
                c.setDrivername("iampapon");
				c.setDistance(20);
				c.setMoneypay(30);
				c.setChange(10);

				try {
					entityManager.persist(c);
					entityManager.flush();

					//fail("Should not pass to this line");
				} catch(javax.validation.ConstraintViolationException e) {
					Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
					assertEquals(violations.isEmpty(), false);
					assertEquals(violations.size(), 1);
				}
			}


			@Test
			public void testCashDriverNameNotNull() {
				CashPay c = new CashPay();
                c.setDrivername(null);
				c.setDistance(80);
				c.setMoneypay(55);
				c.setChange(3);

				try {
					entityManager.persist(c);
					entityManager.flush();

					fail("Should not pass to this line");
				} catch(javax.validation.ConstraintViolationException e) {
					Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
					assertEquals(violations.isEmpty(), false);
					assertEquals(violations.size(), 1);
					System.out.println();
					System.out.println("++++++++++++++++++++++++++++++testCashDriverNameNotNull++++++++++++++++++++++++++++++");
					System.out.println();
					System.out.println(e.getMessage());
					System.out.println();
					System.out.println("++++++++++++++++++++++++++++++testCashDriverNameNotNull++++++++++++++++++++++++++++++");
					System.out.println();
				}
			}


			@Test
			public void testCashDriverNameNotOverSize() {

                CashPay c = new CashPay();
                c.setDrivername("iampaponkkongwattanasakkiampapon");
				c.setDistance(55);
				c.setMoneypay(20);
				c.setChange(10);

				try {
					entityManager.persist(c);
					entityManager.flush();

					fail("Should not pass to this line");
				} catch(javax.validation.ConstraintViolationException e) {
					Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
					assertEquals(violations.isEmpty(), false);
					assertEquals(violations.size(), 1);
					System.out.println();
					System.out.println("++++++++++++++++++++++++++++++testCashDriverNameNotOverSize++++++++++++++++++++++++++++++");
					System.out.println();
					System.out.println(e.getMessage());
					System.out.println();
					System.out.println("++++++++++++++++++++++++++++++testCashDriverNameNotOverSize++++++++++++++++++++++++++++++");
					System.out.println();
				}
			}

			@Test
			public void testCashDrivernameNotSmallerSize() {
                CashPay c = new CashPay();
                c.setDrivername("i");
				c.setDistance(55);
				c.setMoneypay(20555);
				c.setChange(10);

				try {
					entityManager.persist(c);
					entityManager.flush();

					fail("Should not pass to this line");
				} catch(javax.validation.ConstraintViolationException e) {
					Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
					assertEquals(violations.isEmpty(), false);
					assertEquals(violations.size(), 2);
					System.out.println();
					System.out.println("++++++++++++++++++++++++++++++testCashDrivernameNotSmallerSize++++++++++++++++++++++++++++++");
					System.out.println();
					System.out.println(e.getMessage());
					System.out.println();
					System.out.println("++++++++++++++++++++++++++++++testCashDrivernameNotSmallerSize++++++++++++++++++++++++++++++");
					System.out.println();
				}
			}
            @Test
			public void testCashDrivernamePattern() {
                CashPay c = new CashPay();
                c.setDrivername("papon+papon");
				c.setDistance(55);
				c.setMoneypay(20);
				c.setChange(65);

				try {
					entityManager.persist(c);
					entityManager.flush();

					fail("Should not pass to this line");
				} catch(javax.validation.ConstraintViolationException e) {
					Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
					assertEquals(violations.isEmpty(), false);
					assertEquals(violations.size(), 1);
					System.out.println();
					System.out.println("++++++++++++++++++++++++++++++testCashDrivernamePattern++++++++++++++++++++++++++++++");
					System.out.println();
					System.out.println(e.getMessage());
					System.out.println();
					System.out.println("++++++++++++++++++++++++++++++testCashDrivernamePattern++++++++++++++++++++++++++++++");
					System.out.println();
				}
            } 
            
            public void testCashDistanceNotOverSize() {
                CashPay c = new CashPay();
                c.setDrivername("paponpapon");
				c.setDistance(1500);
				c.setMoneypay(20);
				c.setChange(65);

				try {
					entityManager.persist(c);
					entityManager.flush();

					fail("Should not pass to this line");
				} catch(javax.validation.ConstraintViolationException e) {
					Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
					assertEquals(violations.isEmpty(), false);
					assertEquals(violations.size(), 1);
					System.out.println();
					System.out.println("++++++++++++++++++++++++++++++testCashDistanceNotLessthanMin++++++++++++++++++++++++++++++");
					System.out.println();
					System.out.println(e.getMessage());
					System.out.println();
					System.out.println("++++++++++++++++++++++++++++++testCashDistanceNotLessthanMin++++++++++++++++++++++++++++++");
					System.out.println();
				}
            } 
            
            @Test
			public void testCashDistanceNotLessthanMin() {
                CashPay c = new CashPay();
                c.setDrivername("paponpapon");
				c.setDistance(0);
				c.setMoneypay(20);
				c.setChange(65);

				try {
					entityManager.persist(c);
					entityManager.flush();

					fail("Should not pass to this line");
				} catch(javax.validation.ConstraintViolationException e) {
					Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
					assertEquals(violations.isEmpty(), false);
					assertEquals(violations.size(), 1);
					System.out.println();
					System.out.println("++++++++++++++++++++++++++++++testCashDistanceNotLessthanMin++++++++++++++++++++++++++++++");
					System.out.println();
					System.out.println(e.getMessage());
					System.out.println();
					System.out.println("++++++++++++++++++++++++++++++testCashDistanceNotLessthanMin++++++++++++++++++++++++++++++");
					System.out.println();
				}
            } 
            @Test
            public void testCashDistanceNotOverMax() {
                CashPay c = new CashPay();
                c.setDrivername("paponpapon");
				c.setDistance(1500);
				c.setMoneypay(20);
				c.setChange(65);

				try {
					entityManager.persist(c);
					entityManager.flush();

					fail("Should not pass to this line");
				} catch(javax.validation.ConstraintViolationException e) {
					Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
					assertEquals(violations.isEmpty(), false);
					assertEquals(violations.size(), 1);
					System.out.println();
					System.out.println("++++++++++++++++++++++++++++++testCashDistanceNotOverMax++++++++++++++++++++++++++++++");
					System.out.println();
					System.out.println(e.getMessage());
					System.out.println();
					System.out.println("++++++++++++++++++++++++++++++testCashDistanceNotOverMax++++++++++++++++++++++++++++++");
					System.out.println();
				}
            } 

            @Test
			public void testCashMoneyNotOverMax() {
                CashPay c = new CashPay();
                c.setDrivername("paponpapon");
				c.setDistance(82);
				c.setMoneypay(5000);
				c.setChange(65);

				try {
					entityManager.persist(c);
					entityManager.flush();

					fail("Should not pass to this line");
				} catch(javax.validation.ConstraintViolationException e) {
					Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
					assertEquals(violations.isEmpty(), false);
					assertEquals(violations.size(), 1);
					System.out.println();
					System.out.println("++++++++++++++++++++++++++++++testCashMoneyNotOverMax++++++++++++++++++++++++++++++");
					System.out.println();
					System.out.println(e.getMessage());
					System.out.println();
					System.out.println("++++++++++++++++++++++++++++++testCashMoneyNotOverMax++++++++++++++++++++++++++++++");
					System.out.println();
				}
            } 

            @Test
			public void testCashMoneyNotLessthanMin() {
                CashPay c = new CashPay();
                c.setDrivername("paponpapon");
				c.setDistance(82);
				c.setMoneypay(1);
				c.setChange(65);

				try {
					entityManager.persist(c);
					entityManager.flush();

					fail("Should not pass to this line");
				} catch(javax.validation.ConstraintViolationException e) {
					Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
					assertEquals(violations.isEmpty(), false);
					assertEquals(violations.size(), 1);
					System.out.println();
					System.out.println("++++++++++++++++++++++++++++++testCashMoneyNotLessthanMin++++++++++++++++++++++++++++++");
					System.out.println();
					System.out.println(e.getMessage());
					System.out.println();
					System.out.println("++++++++++++++++++++++++++++++testCashMoneyNotLessthanMin++++++++++++++++++++++++++++++");
					System.out.println();
				}
            } 

            @Test
			public void testCashDistanceNotNecative() {
                CashPay c = new CashPay();
                c.setDrivername("paponpapon");
				c.setDistance(-82);
				c.setMoneypay(1);
				c.setChange(65);

				try {
					entityManager.persist(c);
					entityManager.flush();

					fail("Should not pass to this line");
				} catch(javax.validation.ConstraintViolationException e) {
					Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
					assertEquals(violations.isEmpty(), false);
					assertEquals(violations.size(), 2);
					System.out.println();
					System.out.println("++++++++++++++++++++++++++++++testCashDistanceNotNecative++++++++++++++++++++++++++++++");
					System.out.println();
					System.out.println(e.getMessage());
					System.out.println();
					System.out.println("++++++++++++++++++++++++++++++testCashDistanceNotNecative++++++++++++++++++++++++++++++");
					System.out.println();
				}
            } 

            @Test
			public void testCashMoneyNotNecative() {
                CashPay c = new CashPay();
                c.setDrivername("paponpapon");
				c.setDistance(82);
				c.setMoneypay(-1);
				c.setChange(65);

				try {
					entityManager.persist(c);
					entityManager.flush();

					fail("Should not pass to this line");
				} catch(javax.validation.ConstraintViolationException e) {
					Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
					assertEquals(violations.isEmpty(), false);
					assertEquals(violations.size(), 1);
					System.out.println();
					System.out.println("++++++++++++++++++++++++++++++testCashMoneyNotNecative++++++++++++++++++++++++++++++");
					System.out.println();
					System.out.println(e.getMessage());
					System.out.println();
					System.out.println("++++++++++++++++++++++++++++++testCashMoneyNotNecative++++++++++++++++++++++++++++++");
					System.out.println();
				}
            } 
    // --------------------------------Test CashPay--------------------------------------------------------
    // --------------------------------Test OnlinePay--------------------------------------------------------

    @Test
    public void testOnlineMoneyNotOverMax() {
        OnlinePay c = new OnlinePay();
        
        c.setDistance(82);
        c.setMoneypay(6000);

        try {
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println("++++++++++++++++++++++++++++++testOnlineMoneyNotOverMax++++++++++++++++++++++++++++++");
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println("++++++++++++++++++++++++++++++testOnlineMoneyNotOverMax++++++++++++++++++++++++++++++");
            System.out.println();
        }
    } 

    @Test
    public void testOnlineMoneyNotLessthanMin() {
        OnlinePay c = new OnlinePay();
        
        c.setDistance(82);
        c.setMoneypay(1);

        try {
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println("++++++++++++++++++++++++++++++testOnlineMoneyNotLessthanMin++++++++++++++++++++++++++++++");
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println("++++++++++++++++++++++++++++++testOnlineMoneyNotLessthanMin++++++++++++++++++++++++++++++");
            System.out.println();
        }
    } 

    @Test
    public void testOnlineDistanceNotLessthanMin() {
        OnlinePay c = new OnlinePay();
        
        c.setDistance(0);
        c.setMoneypay(150);

        try {
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println("++++++++++++++++++++++++++++++testOnlineMoneyNotLessthanMin++++++++++++++++++++++++++++++");
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println("++++++++++++++++++++++++++++++testOnlineMoneyNotLessthanMin++++++++++++++++++++++++++++++");
            System.out.println();
        }
    } 

    @Test
    public void testOnlineDistanceNotOverMaX() {
        OnlinePay c = new OnlinePay();
        
        c.setDistance(1200);
        c.setMoneypay(150);

        try {
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println("++++++++++++++++++++++++++++++testOnlineDistanceNotOverMaX++++++++++++++++++++++++++++++");
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println("++++++++++++++++++++++++++++++testOnlineDistanceNotOverMaX++++++++++++++++++++++++++++++");
            System.out.println();
        }
    } 

    @Test
    public void testOnlineMoneyNotNecative() {
        OnlinePay c = new OnlinePay();
        
        c.setDistance(82);
        c.setMoneypay(-600);

        try {
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println("++++++++++++++++++++++++++++++testOnlineMoneyNotNecative++++++++++++++++++++++++++++++");
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println("++++++++++++++++++++++++++++++testOnlineMoneyNotNecative++++++++++++++++++++++++++++++");
            System.out.println();
        }
    } 

    @Test
    public void testOnlineDistanceNotNecative() {
        OnlinePay c = new OnlinePay();
        
        c.setDistance(-82);
        c.setMoneypay(600);

        try {
            entityManager.persist(c);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println("++++++++++++++++++++++++++++++testOnlineDistanceNotNecative++++++++++++++++++++++++++++++");
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println("++++++++++++++++++++++++++++++testOnlineDistanceNotNecative++++++++++++++++++++++++++++++");
            System.out.println();
        }
    } 
    // --------------------------------Test OnlinePay--------------------------------------------------------
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
            assertEquals(violations.size(), 1);
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
            assertEquals(violations.size(), 1);
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
            assertEquals(violations.size(), 1);
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
            assertEquals(violations.size(), 1);
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
            assertEquals(violations.size(), 1);
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
  // --------------------------------Test Salary--------------------------------------------------------
  @Test
    public void testSalaryTrue() {
        Salary s = new Salary();
        s.setNameAdmin("pop");
		s.setNameDriver("Hassad");
		s.setNamePosition("thirawuth");
        s.setPhoneDriver("0814445678");
        s.setPayment("pass");

        try {
            entityManager.persist(s);
            entityManager.flush();
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Salary is True %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            //fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
			
		}
	}
	

	@Test
    public void testSalaryCannotSize() {
        Salary s = new Salary();
        s.setNameAdmin("Ve");
		s.setNameDriver("asdasdaasdsaddfhfghgdfghfhsfghgfgfhgfasdasdasdasdasdasdasdasdasdasd");
		s.setNamePosition("asdasdasdasdasdasdasdasdjhgjhgjdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasd");
        s.setPhoneDriver("0812344456780");
        s.setPayment("0912345644780");

        try {
            entityManager.persist(s);
            entityManager.flush();
			
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 4);
			System.out.println();
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% testSalaryNotSize %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% testSalaryNotSize %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			System.out.println();
			
		}
	}

	@Test
    public void testSalaryCannotPattern() {
        Salary s = new Salary();
        s.setNameAdmin("/*-789-/");
		s.setNameDriver("/*-89");
		s.setNamePosition("/*896");
        s.setPhoneDriver("0512345678");
        s.setPayment("/*-789-/");

        try {
            entityManager.persist(s);
            entityManager.flush();
			
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 5);
			System.out.println();
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% testSalaryNotPattern %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% testSalaryNotPattern %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			System.out.println();
            
            
		}
	}

	@Test
    public void testSalaryCannotNull() {
        Salary s = new Salary();
        s.setNameAdmin(null);
		s.setNameDriver(null);
		s.setNamePosition(null);
        s.setPhoneDriver(null);
        s.setPayment(null);

        try {
            entityManager.persist(s);
            entityManager.flush();
			
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 5);
			System.out.println();
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% testSalaryNotNull %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% testSalaryNotNull %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			System.out.println();
			
		}
	}
	
        //+++++++++++++++++++++++++++++++++++Salary+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
         // --------------------------------Test Discount--------------------------------------------------------
  @Test
  public void testDiscountTrue() {
    Discount s = new Discount();
      s.setPromotion("pop");
      

      try {
          entityManager.persist(s);
          entityManager.flush();
          System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Discount is True %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
          //fail("Should not pass to this line");
      } catch(javax.validation.ConstraintViolationException e) {
          Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
          assertEquals(violations.isEmpty(), false);
          assertEquals(violations.size(), 1);
          
      }
  }
  

  @Test
  public void testDiscountCannotSize() {
    Discount s = new Discount();
      s.setPromotion("Ve");
      

      try {
          entityManager.persist(s);
          entityManager.flush();
          
          fail("Should not pass to this line");
      } catch(javax.validation.ConstraintViolationException e) {
          Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
          assertEquals(violations.isEmpty(), false);
          assertEquals(violations.size(), 1);
          System.out.println();
          System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% testDiscountNotSize %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
          System.out.println();
          System.out.println(e.getMessage());
          System.out.println();
          System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% testDiscountNotSize %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
          System.out.println();
          
      }
  }

  @Test
  public void testDiscountCannotPattern() {
    Discount s = new Discount();
      s.setPromotion("/*-789-/");
      

      try {
          entityManager.persist(s);
          entityManager.flush();
          
          fail("Should not pass to this line");
      } catch(javax.validation.ConstraintViolationException e) {
          Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
          assertEquals(violations.isEmpty(), false);
          assertEquals(violations.size(), 1);
          System.out.println();
          System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% testDiscountNotPattern %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
          System.out.println();
          System.out.println(e.getMessage());
          System.out.println();
          System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% testDiscountNotPattern %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
          System.out.println();
          
          
      }
  }

  @Test
  public void testDiscountCannotNull() {
    Discount s = new Discount();
      s.setPromotion(null);
     

      try {
          entityManager.persist(s);
          entityManager.flush();
          
          fail("Should not pass to this line");
      } catch(javax.validation.ConstraintViolationException e) {
          Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
          assertEquals(violations.isEmpty(), false);
          assertEquals(violations.size(), 1);
          System.out.println();
          System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% testDiscountNotNull %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
          System.out.println();
          System.out.println(e.getMessage());
          System.out.println();
          System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% testDiscountNotNull %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
          System.out.println();
          
      }
  }
  
      //+++++++++++++++++++++++++++++++++++Discount+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

}

