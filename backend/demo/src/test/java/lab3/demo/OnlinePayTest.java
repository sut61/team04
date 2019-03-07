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
public class OnlinePayTest {
	
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private CashPayRepository onlinepayRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private BankRepository bankRepository;


	private Validator validator;
	private Member member;
	private Driver driver;
	
	

	@Before
	public void setup() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
    }

    @Test
    public void testOnlineCorrect() {
        Driver d =  driverRepository.getOne(1L);
        Member member =  memberRepository.getOne(1L);
        Bank k =  bankRepository.getOne(1L);
        OnlinePay c = new OnlinePay();
    
        c.setDistance(80);
        c.setMoneypay(240);
        c.setMember(member);
        c.setDriver(d);
        c.setBank(k);
    
        
          
    }

    @Test
public void testOnlineNotNull() {
    Driver d =  driverRepository.getOne(1L);
    Member member =  memberRepository.getOne(1L);
    Bank k =  bankRepository.getOne(1L);
    OnlinePay c = new OnlinePay();

    c.setDistance(82);
    c.setMoneypay(1);
    c.setMember(null);
    c.setDriver(null);
    c.setBank(null);
    

    try {
        entityManager.persist(c);
        entityManager.flush();

        fail("Should not pass to this line");
    } catch(javax.validation.ConstraintViolationException e) {
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        assertEquals(violations.isEmpty(), false);
        assertEquals(violations.size(), 4);
        System.out.println();
        System.out.println("******++++++++******++++++++******++++++++testOnlineNotNull******++++++++******++++++++******++++++++");
        System.out.println();
        System.out.println(e.getMessage());
        System.out.println();
        System.out.println("******++++++++******++++++++******++++++++testOnlineNotNull******++++++++******++++++++******++++++++");
        System.out.println();
    }
}

@Test
public void testOnlineMoneyNotOverMax() {
    Driver d =  driverRepository.getOne(1L);
    Member member =  memberRepository.getOne(1L);
    Bank k =  bankRepository.getOne(1L);
    OnlinePay c = new OnlinePay();

    c.setDistance(82);
    c.setMoneypay(6000);
    c.setMember(member);
    c.setDriver(d);
    c.setBank(k);

    try {
        entityManager.persist(c);
        entityManager.flush();

        fail("Should not pass to this line");
    } catch(javax.validation.ConstraintViolationException e) {
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        assertEquals(violations.isEmpty(), false);
        assertEquals(violations.size(), 1);
        System.out.println();
        System.out.println("******++++++++******++++++++******++++++++testOnlineMoneyNotOverMax******++++++++******++++++++******++++++++");
        System.out.println();
        System.out.println(e.getMessage());
        System.out.println();
        System.out.println("******++++++++******++++++++******++++++++testOnlineMoneyNotOverMax******++++++++******++++++++******++++++++");
        System.out.println();
    }
}

@Test
public void testOnlineBankNamePattern() {
    Driver d =  driverRepository.getOne(1L);
    Member member =  memberRepository.getOne(1L);

    Bank k1 = new Bank();
    k1.setName("/*-+-*/-*+-*/-*+");
    entityManager.persist(k1);

    OnlinePay c = new OnlinePay();
    

    c.setDistance(82);
    c.setMoneypay(60);
    c.setMember(member);
    c.setDriver(d);
    c.setBank(k1);

    try {
        entityManager.persistAndFlush(c);
        //entityManager.flush();

        fail("Should not pass to this line");
    } catch(javax.validation.ConstraintViolationException e) {
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        assertEquals(violations.isEmpty(), false);
        assertEquals(violations.size(), 1);
        System.out.println();
        System.out.println("******++++++++******++++++++******++++++++testOnlineBankNamePattern******++++++++******++++++++******++++++++");
        System.out.println();
        System.out.println(e.getMessage());
        System.out.println();
        System.out.println("******++++++++******++++++++******++++++++testOnlineBankNamePattern******++++++++******++++++++******++++++++");
        System.out.println();
    }
}

@Test
public void testOnlineBankNameSize() {
    Driver d =  driverRepository.getOne(1L);
    Member member =  memberRepository.getOne(1L);
    Bank k =  bankRepository.getOne(1L);
    OnlinePay c = new OnlinePay();
    Bank k1 = new Bank();

    c.setDistance(82);
    c.setMoneypay(60);
    c.setMember(member);
    c.setDriver(d);
    k1.setName("asdghasjdgasjhdghsjdggzxjchgahsjde");

    try {
        entityManager.persist(c);
        entityManager.flush();

        fail("Should not pass to this line");
    } catch(javax.validation.ConstraintViolationException e) {
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        assertEquals(violations.isEmpty(), false);
        assertEquals(violations.size(), 1);
        System.out.println();
        System.out.println("******++++++++******++++++++******++++++++testOnlineBankNameSize******++++++++******++++++++******++++++++");
        System.out.println();
        System.out.println(e.getMessage());
        System.out.println();
        System.out.println("******++++++++******++++++++******++++++++testOnlineBankNameSize******++++++++******++++++++******++++++++");
        System.out.println();
    }
}

@Test
public void testOnlineMoneyNotLessthanMin() {
    Driver d =  driverRepository.getOne(1L);
    Member member =  memberRepository.getOne(1L);
    Bank k =  bankRepository.getOne(1L);
    OnlinePay c = new OnlinePay();

    c.setDistance(82);
    c.setMoneypay(1);
    c.setMember(member);
    c.setDriver(d);
    c.setBank(k);

    try {
        entityManager.persist(c);
        entityManager.flush();

        fail("Should not pass to this line");
    } catch(javax.validation.ConstraintViolationException e) {
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        assertEquals(violations.isEmpty(), false);
        assertEquals(violations.size(), 1);
        System.out.println();
        System.out.println("******++++++++******++++++++******++++++++testOnlineMoneyNotLessthanMin******++++++++******++++++++******++++++++");
        System.out.println();
        System.out.println(e.getMessage());
        System.out.println();
        System.out.println("******++++++++******++++++++******++++++++testOnlineMoneyNotLessthanMin******++++++++******++++++++******++++++++");
        System.out.println();
    }
}

@Test
public void testOnlineDistanceNotLessthanMin() {
    Driver d =  driverRepository.getOne(1L);
    Member member =  memberRepository.getOne(1L);
    Bank k =  bankRepository.getOne(1L);
    OnlinePay c = new OnlinePay();

    c.setDistance(0);
    c.setMoneypay(150);
    c.setMember(member);
    c.setDriver(d);
    c.setBank(k);

    try {
        entityManager.persist(c);
        entityManager.flush();

        fail("Should not pass to this line");
    } catch(javax.validation.ConstraintViolationException e) {
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        assertEquals(violations.isEmpty(), false);
        assertEquals(violations.size(), 1);
        System.out.println();
        System.out.println("******++++++++******++++++++******++++++++testOnlineMoneyNotLessthanMin******++++++++******++++++++******++++++++");
        System.out.println();
        System.out.println(e.getMessage());
        System.out.println();
        System.out.println("******++++++++******++++++++******++++++++testOnlineMoneyNotLessthanMin******++++++++******++++++++******++++++++");
        System.out.println();
    }
}

@Test
public void testOnlineDistanceNotOverMaX() {
    Driver d =  driverRepository.getOne(1L);
    Member member =  memberRepository.getOne(1L);
    Bank k =  bankRepository.getOne(1L);
    OnlinePay c = new OnlinePay();

    c.setDistance(1200);
    c.setMoneypay(150);
    c.setMember(member);
    c.setDriver(d);
    c.setBank(k);

    try {
        entityManager.persist(c);
        entityManager.flush();

        fail("Should not pass to this line");
    } catch(javax.validation.ConstraintViolationException e) {
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        assertEquals(violations.isEmpty(), false);
        assertEquals(violations.size(), 1);
        System.out.println();
        System.out.println("******++++++++******++++++++******++++++++testOnlineDistanceNotOverMaX******++++++++******++++++++******++++++++");
        System.out.println();
        System.out.println(e.getMessage());
        System.out.println();
        System.out.println("******++++++++******++++++++******++++++++testOnlineDistanceNotOverMaX******++++++++******++++++++******++++++++");
        System.out.println();
    }
}

@Test
public void testOnlineMoneyNotNecative() {
    Driver d =  driverRepository.getOne(1L);
    Member member =  memberRepository.getOne(1L);
    Bank k =  bankRepository.getOne(1L);
    OnlinePay c = new OnlinePay();

    c.setDistance(82);
    c.setMoneypay(-600);
    c.setMember(member);
    c.setDriver(d);
    c.setBank(k);

    try {
        entityManager.persist(c);
        entityManager.flush();

        fail("Should not pass to this line");
    } catch(javax.validation.ConstraintViolationException e) {
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        assertEquals(violations.isEmpty(), false);
        assertEquals(violations.size(), 1);
        System.out.println();
        System.out.println("******++++++++******++++++++******++++++++testOnlineMoneyNotNecative******++++++++******++++++++******++++++++");
        System.out.println();
        System.out.println(e.getMessage());
        System.out.println();
        System.out.println("******++++++++******++++++++******++++++++testOnlineMoneyNotNecative******++++++++******++++++++******++++++++");
        System.out.println();
    }
}

@Test
public void testOnlineDistanceNotNecative() {
    Driver d =  driverRepository.getOne(1L);
    Member member =  memberRepository.getOne(1L);
    Bank k =  bankRepository.getOne(1L);
    OnlinePay c = new OnlinePay();

    c.setDistance(-82);
    c.setMoneypay(600);
    c.setMember(member);
    c.setDriver(d);
    c.setBank(k);

    try {
        entityManager.persist(c);
        entityManager.flush();

        fail("Should not pass to this line");
    } catch(javax.validation.ConstraintViolationException e) {
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        assertEquals(violations.isEmpty(), false);
        assertEquals(violations.size(), 1);
        System.out.println();
        System.out.println("******++++++++******++++++++******++++++++testOnlineDistanceNotNecative******++++++++******++++++++******++++++++");
        System.out.println();
        System.out.println(e.getMessage());
        System.out.println();
        System.out.println("+******++++++++******++++++++******++++++++testOnlineDistanceNotNecative******++++++++******++++++++******++++++++");
        System.out.println();
    }
}


@Test
public void testOnlinePayCannotUnique() {
    Driver d =  driverRepository.getOne(1L);
    Member member =  memberRepository.getOne(1L);
    Bank k =  bankRepository.getOne(1L);
    OnlinePay c = new OnlinePay();
    c.setDistance(82);
    c.setMoneypay(600); 
    c.setId(12345678910L);
    c.setMember(member);
    c.setDriver(d);
    c.setBank(k);
    

    OnlinePay c1 = new OnlinePay();
    c1.setDistance(82);
    c1.setMoneypay(600);
    c1.setId(12345678910L);
    c1.setMember(member);
    c1.setDriver(d);
    c.setBank(k);
    


    try {
        entityManager.persist(c1);
        entityManager.flush();

        fail("Should not pass to this line");
    } catch(javax.validation.ConstraintViolationException e) {
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        assertEquals(violations.isEmpty(), false);
        assertEquals(violations.size(), 2);
        System.out.println();
        System.out.println("******++++++++******++++++++******++++++++ testOnlinePayCannotUnique ******++++++++******++++++++******++++++++");
        System.out.println();
        System.out.println(e.getMessage());
        System.out.println();
        System.out.println("******++++++++******++++++++******++++++++ testOnlinePayCannotUnique ******++++++++******++++++++******++++++++");
        System.out.println();

    }catch (javax.persistence.PersistenceException e) {
        e.printStackTrace();
    }
}

}