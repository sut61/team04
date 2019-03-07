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
public class CashPayTest {
	
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private CashPayRepository cashpayRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private GiftRepository giftRepository;

	private Validator validator;
	private Member member;
	private Driver driver;
	
	

	@Before
	public void setup() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
    }
    @Test
			public void testCashPayCorrect() {
                Driver d =  driverRepository.getOne(1L);
                Member member =  memberRepository.getOne(1L);
                Gift gift = giftRepository.getOne(1L);
                CashPay c = new CashPay();
                c.setDrivername("iampapon");
				c.setDistance(20);
				c.setMoneypay(30);
                c.setChange(10);
                c.setMember(member);
                c.setDriver(d);
                c.setGift(gift);

				
            }
            
			

			@Test
			public void testCashDriverNameNotNull() {
                Driver d =  driverRepository.getOne(1L);
                Member member =  memberRepository.getOne(1L);
                Gift gift = giftRepository.getOne(1L);
				CashPay c = new CashPay();
                c.setDrivername(null);
				c.setDistance(80);
				c.setMoneypay(55);
                c.setChange(3);
                c.setMember(member);
                c.setDriver(d);
                c.setGift(gift);


				try {
					entityManager.persist(c);
					entityManager.flush();

					fail("Should not pass to this line");
				} catch(javax.validation.ConstraintViolationException e) {
					Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
					assertEquals(violations.isEmpty(), false);
					assertEquals(violations.size(), 1);
					System.out.println();
					System.out.println("******++++++++******++++++++******++++++++testCashDriverNameNotNull******++++++++******++++++++******++++++++");
					System.out.println();
					System.out.println(e.getMessage());
					System.out.println();
					System.out.println("******++++++++******++++++++******++++++++testCashDriverNameNotNull******++++++++******++++++++******++++++++");
					System.out.println();
				}
			}


			@Test
			public void testCashDriverNameNotOverSize() {
                Driver d =  driverRepository.getOne(1L);
                Member member =  memberRepository.getOne(1L);
                Gift gift = giftRepository.getOne(1L);
                CashPay c = new CashPay();
                c.setDrivername("iampaponkkongwattanasakkiampapon");
				c.setDistance(55);
				c.setMoneypay(20);
                c.setChange(10);
                c.setMember(member);
                c.setDriver(d);
                c.setGift(gift);


				try {
					entityManager.persist(c);
					entityManager.flush();

					fail("Should not pass to this line");
				} catch(javax.validation.ConstraintViolationException e) {
					Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
					assertEquals(violations.isEmpty(), false);
					assertEquals(violations.size(), 1);
					System.out.println();
					System.out.println("******++++++++******++++++++******++++++++testCashDriverNameNotOverSize******++++++++******++++++++******++++++++");
					System.out.println();
					System.out.println(e.getMessage());
					System.out.println();
					System.out.println("******++++++++******++++++++******++++++++testCashDriverNameNotOverSize******++++++++******++++++++******++++++++");
					System.out.println();
				}
			}

			@Test
			public void testCashDrivernameNotSmallerSize() {
                Driver d =  driverRepository.getOne(1L);
                Member member =  memberRepository.getOne(1L);
                Gift gift = giftRepository.getOne(1L);
                CashPay c = new CashPay();
                c.setDrivername("i");
				c.setDistance(55);
				c.setMoneypay(20555);
                c.setChange(10);
                c.setMember(member);
                c.setDriver(d);
                c.setGift(gift);


				try {
					entityManager.persist(c);
					entityManager.flush();

					fail("Should not pass to this line");
				} catch(javax.validation.ConstraintViolationException e) {
					Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
					assertEquals(violations.isEmpty(), false);
					assertEquals(violations.size(), 2);
					System.out.println();
					System.out.println("******++++++++******++++++++******++++++++testCashDrivernameNotSmallerSize******++++++++******++++++++******++++++++");
					System.out.println();
					System.out.println(e.getMessage());
					System.out.println();
					System.out.println("******++++++++******++++++++******++++++++testCashDrivernameNotSmallerSize******++++++++******++++++++******++++++++");
					System.out.println();
				}
			}
            @Test
			public void testCashDrivernamePattern() {
                Driver d =  driverRepository.getOne(1L);
                Member member =  memberRepository.getOne(1L);
                Gift gift = giftRepository.getOne(1L);
                CashPay c = new CashPay();
                c.setDrivername("papon+*-/*+");
				c.setDistance(55);
				c.setMoneypay(20);
                c.setChange(65);
                c.setMember(member);
                c.setDriver(d);
                c.setGift(gift);


				try {
					entityManager.persist(c);
					entityManager.flush();

					fail("Should not pass to this line");
				} catch(javax.validation.ConstraintViolationException e) {
					Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
					assertEquals(violations.isEmpty(), false);
					assertEquals(violations.size(), 1);
					System.out.println();
					System.out.println("******++++++++******++++++++******++++++++testCashDrivernamePattern******++++++++******++++++++******++++++++");
					System.out.println();
					System.out.println(e.getMessage());
					System.out.println();
					System.out.println("******++++++++******++++++++******++++++++testCashDrivernamePattern******++++++++******++++++++******++++++++");
					System.out.println();
				}
            }

            public void testCashDistanceNotOverSize() {
                Driver d =  driverRepository.getOne(1L);
                Member member =  memberRepository.getOne(1L);
                Gift gift = giftRepository.getOne(1L);
                CashPay c = new CashPay();
                c.setDrivername("paponpapon");
				c.setDistance(1500);
				c.setMoneypay(20);
                c.setChange(65);
                c.setMember(member);
                c.setDriver(d);
                c.setGift(gift);


				try {
					entityManager.persist(c);
					entityManager.flush();

					fail("Should not pass to this line");
				} catch(javax.validation.ConstraintViolationException e) {
					Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
					assertEquals(violations.isEmpty(), false);
					assertEquals(violations.size(), 1);
					System.out.println();
					System.out.println("******++++++++******++++++++******++++++++testCashDistanceNotOverSize******++++++++******++++++++******++++++++");
					System.out.println();
					System.out.println(e.getMessage());
					System.out.println();
					System.out.println("******++++++++******++++++++******++++++++testCashDistanceNotOverSize******++++++++******++++++++******++++++++");
					System.out.println();
				}
            }

            @Test
			public void testCashDistanceNotLessthanMin() {
                Driver d =  driverRepository.getOne(1L);
                Member member =  memberRepository.getOne(1L);
                Gift gift = giftRepository.getOne(1L);
                CashPay c = new CashPay();
                c.setDrivername("paponpapon");
				c.setDistance(0);
				c.setMoneypay(20);
                c.setChange(65);
                c.setMember(member);
                c.setDriver(d);
                c.setGift(gift);


				try {
					entityManager.persist(c);
					entityManager.flush();

					fail("Should not pass to this line");
				} catch(javax.validation.ConstraintViolationException e) {
					Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
					assertEquals(violations.isEmpty(), false);
					assertEquals(violations.size(), 1);
					System.out.println();
					System.out.println("******++++++++******++++++++******++++++++testCashDistanceNotLessthanMin******++++++++******++++++++******++++++++");
					System.out.println();
					System.out.println(e.getMessage());
					System.out.println();
					System.out.println("******++++++++******++++++++******++++++++testCashDistanceNotLessthanMin******++++++++******++++++++******++++++++");
					System.out.println();
				}
            }
            @Test
            public void testCashDistanceNotOverMax() {
                Driver d =  driverRepository.getOne(1L);
                Member member =  memberRepository.getOne(1L);
                Gift gift = giftRepository.getOne(1L);
                CashPay c = new CashPay();
                c.setDrivername("paponpapon");
				c.setDistance(1500);
				c.setMoneypay(20);
                c.setChange(65);
                c.setMember(member);
                c.setDriver(d);
                c.setGift(gift);


				try {
					entityManager.persist(c);
					entityManager.flush();

					fail("Should not pass to this line");
				} catch(javax.validation.ConstraintViolationException e) {
					Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
					assertEquals(violations.isEmpty(), false);
					assertEquals(violations.size(), 1);
					System.out.println();
					System.out.println("******++++++++******++++++++******++++++++testCashDistanceNotOverMax******++++++++******++++++++******++++++++");
					System.out.println();
					System.out.println(e.getMessage());
					System.out.println();
					System.out.println("******++++++++******++++++++******++++++++testCashDistanceNotOverMax******++++++++******++++++++******++++++++");
					System.out.println();
				}
            }

            @Test
			public void testCashMoneyNotOverMax() {
                Driver d =  driverRepository.getOne(1L);
                Member member =  memberRepository.getOne(1L);
                Gift gift = giftRepository.getOne(1L);
                CashPay c = new CashPay();
                c.setDrivername("paponpapon");
				c.setDistance(82);
				c.setMoneypay(5000);
                c.setChange(65);
                c.setMember(member);
                c.setDriver(d);
                c.setGift(gift);


				try {
					entityManager.persist(c);
					entityManager.flush();

					fail("Should not pass to this line");
				} catch(javax.validation.ConstraintViolationException e) {
					Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
					assertEquals(violations.isEmpty(), false);
					assertEquals(violations.size(), 1);
					System.out.println();
					System.out.println("******++++++++******++++++++******++++++++testCashMoneyNotOverMax******++++++++******++++++++******++++++++");
					System.out.println();
					System.out.println(e.getMessage());
					System.out.println();
					System.out.println("******++++++++******++++++++******++++++++testCashMoneyNotOverMax******++++++++******++++++++******++++++++");
					System.out.println();
				}
            }

            @Test
			public void testCashMoneyNotLessthanMin() {
                Driver d =  driverRepository.getOne(1L);
                Member member =  memberRepository.getOne(1L);
                Gift gift = giftRepository.getOne(1L);
                CashPay c = new CashPay();
                c.setDrivername("paponpapon");
				c.setDistance(82);
				c.setMoneypay(1);
                c.setChange(65);
                c.setMember(member);
                c.setDriver(d);
                c.setGift(gift);


				try {
					entityManager.persist(c);
					entityManager.flush();

					fail("Should not pass to this line");
				} catch(javax.validation.ConstraintViolationException e) {
					Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
					assertEquals(violations.isEmpty(), false);
					assertEquals(violations.size(), 1);
					System.out.println();
					System.out.println("******++++++++******++++++++******++++++++testCashMoneyNotLessthanMin******++++++++******++++++++******++++++++");
					System.out.println();
					System.out.println(e.getMessage());
					System.out.println();
					System.out.println("******++++++++******++++++++******++++++++testCashMoneyNotLessthanMin******++++++++******++++++++******++++++++");
					System.out.println();
				}
            }

            @Test
			public void testCashDistanceNotNecative() {
                Driver d =  driverRepository.getOne(1L);
                Member member =  memberRepository.getOne(1L);
                Gift gift = giftRepository.getOne(1L);
                CashPay c = new CashPay();
                c.setDrivername("paponpapon");
				c.setDistance(-82);
				c.setMoneypay(1);
                c.setChange(65);
                c.setMember(member);
                c.setDriver(d);
                c.setGift(gift);


				try {
					entityManager.persist(c);
					entityManager.flush();

					fail("Should not pass to this line");
				} catch(javax.validation.ConstraintViolationException e) {
					Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
					assertEquals(violations.isEmpty(), false);
					assertEquals(violations.size(), 2);
					System.out.println();
					System.out.println("******++++++++******++++++++******++++++++testCashDistanceNotNecative******++++++++******++++++++******++++++++");
					System.out.println();
					System.out.println(e.getMessage());
					System.out.println();
					System.out.println("******++++++++******++++++++******++++++++testCashDistanceNotNecative******++++++++******++++++++******++++++++");
					System.out.println();
				}
            }

            @Test
			public void testCashMoneyNotNecative() {
                Driver d =  driverRepository.getOne(1L);
                Member member =  memberRepository.getOne(1L);
                Gift gift = giftRepository.getOne(1L);
                CashPay c = new CashPay();
                c.setDrivername("paponpapon");
				c.setDistance(82);
				c.setMoneypay(-1);
                c.setChange(65);
                c.setMember(member);
                c.setDriver(d);
                c.setGift(gift);


				try {
					entityManager.persist(c);
					entityManager.flush();

					fail("Should not pass to this line");
				} catch(javax.validation.ConstraintViolationException e) {
					Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
					assertEquals(violations.isEmpty(), false);
					assertEquals(violations.size(), 1);
					System.out.println();
					System.out.println("******++++++++******++++++++******++++++++testCashMoneyNotNecative******++++++++******++++++++******++++++++");
					System.out.println();
					System.out.println(e.getMessage());
					System.out.println();
					System.out.println("******++++++++******++++++++******++++++++testCashMoneyNotNecative******++++++++******++++++++******++++++++");
					System.out.println();
				}
            }

            @Test
			public void testCashpayChangeNotOversize() {
                Driver d =  driverRepository.getOne(1L);
                Member member =  memberRepository.getOne(1L);
                Gift gift = giftRepository.getOne(1L);
                CashPay c = new CashPay();
                c.setDrivername("paponpapon");
				c.setDistance(82);
				c.setMoneypay(91);
                c.setChange(5000);
                c.setMember(member);
                c.setDriver(d);
                c.setGift(gift);


				try {
					entityManager.persist(c);
					entityManager.flush();

					fail("Should not pass to this line");
				} catch(javax.validation.ConstraintViolationException e) {
					Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
					assertEquals(violations.isEmpty(), false);
					assertEquals(violations.size(), 1);
					System.out.println();
					System.out.println("******++++++++******++++++++******++++++++testCashpayChangeNotOversize******++++++++******++++++++******++++++++");
					System.out.println();
					System.out.println(e.getMessage());
					System.out.println();
					System.out.println("******++++++++******++++++++******++++++++testCashpayChangeNotOversize******++++++++******++++++++******++++++++");
					System.out.println();
				}
            }

            @Test
        public void testCashPayCannotUnique() {
            Driver d =  driverRepository.getOne(1L);
            Member member =  memberRepository.getOne(1L);
            Gift gift = giftRepository.getOne(1L);
            CashPay c = new CashPay();
            c.setDrivername("paponn");
            c.setDistance(85);
            c.setMoneypay(550);
            c.setChange(70);
            c.setId(12345678910L);
            c.setMember(member);
            c.setDriver(d);
            c.setGift(gift);

            

            CashPay c1 = new CashPay();
            c1.setDrivername("papapon");
            c1.setDistance(82);
            c1.setMoneypay(500);
            c1.setChange(65);
            c1.setId(12345678910L);
            c1.setMember(member);
            c1.setDriver(d);
            c1.setGift(gift);
            


            try {
                entityManager.persist(c1);
                entityManager.flush();

                fail("Should not pass to this line");
            } catch(javax.validation.ConstraintViolationException e) {
                Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
                assertEquals(violations.isEmpty(), false);
                assertEquals(violations.size(), 2);
                System.out.println();
                System.out.println("******++++++++******++++++++******++++++++testCashPayCannotUnique******++++++++******++++++++******++++++++");
                System.out.println();
                System.out.println(e.getMessage());
                System.out.println();
                System.out.println("******++++++++******++++++++******++++++++testCashPayCannotUnique******++++++++******++++++++******++++++++");
                System.out.println();

            }catch (javax.persistence.PersistenceException e) {
                e.printStackTrace();
            }
        }
    
        }