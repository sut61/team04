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
import java.util.Date;
@RunWith(SpringRunner.class)

@DataJpaTest
public class SalaryTest {
	
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private SalaryRepository salaryRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PositionRepository positionRepository;


	private Validator validator;
	private Admin admin;
	private Driver driver;
	private Position position;
	

	@Before
	public void setup() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
    }


    @Test
    public void testDiscountTrue() {
        Admin admin =  adminRepository.getOne(1L);
        Driver driver = driverRepository.getOne(1L);
        Position position =  positionRepository.getOne(1L);
       
        Salary d = new Salary();
        d.setAdmin(admin);
        d.setDriver(driver);
        d.setPosition(position);
        d.setPayment("sadas");
        d.setDate(new Date());
        d.setPrice(1200);
        
        try {
            entityManager.persist(d);
            entityManager.flush();

            //fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println("++++++++++++++++++++++++++++++testDiscountTrue++++++++++++++++++++++++++++++");
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println("++++++++++++++++++++++++++++++testDiscountTrue++++++++++++++++++++++++++++++");
            System.out.println();
        }
    }

    @Test
    public void testDiscountSizePrice() {
        Admin admin =  adminRepository.getOne(1L);
        Driver driver = driverRepository.getOne(1L);
        Position position =  positionRepository.getOne(1L);
        Salary d = new Salary();
        d.setAdmin(admin);
        d.setDriver(driver);
        d.setPosition(position);
        d.setPayment("sasdads");
        d.setDate(new Date());
        d.setPrice(12000000);
        
        try {
            entityManager.persist(d);
            entityManager.flush();

            //fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println("++++++++++++++++++++++++++++++testDiscountSizePrice++++++++++++++++++++++++++++++");
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println("++++++++++++++++++++++++++++++testDiscountSizePrice++++++++++++++++++++++++++++++");
            System.out.println();
        }
    }

    @Test
    public void testDiscountPatternPromotion() {
        Admin admin =  adminRepository.getOne(1L);
        Driver driver = driverRepository.getOne(1L);
        Position position =  positionRepository.getOne(1L);
       
        Salary d = new Salary();
        d.setAdmin(admin);
        d.setDriver(driver);
        d.setPosition(position);
        d.setPayment("*34/454/*/*");
        d.setDate(new Date());
        d.setPrice(1200);
        
        try {
            entityManager.persist(d);
            entityManager.flush();

            //fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println("++++++++++++++++++++++++++++++testDiscountPatternPromotion++++++++++++++++++++++++++++++");
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println("++++++++++++++++++++++++++++++testDiscountPatternPromotion++++++++++++++++++++++++++++++");
            System.out.println();
        }
    }

    @Test
    public void testDiscountNotNullPromotion() {
        Admin admin =  adminRepository.getOne(1L);
        Driver driver = driverRepository.getOne(1L);
        Position position =  positionRepository.getOne(1L);
        Salary d = new Salary();
        d.setAdmin(admin);
        d.setDriver(driver);
        d.setPosition(position);
        d.setPayment(null);
        d.setDate(new Date());
        d.setPrice(1200);
        
        try {
            entityManager.persist(d);
            entityManager.flush();

            //fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println("++++++++++++++++++++++++++++++testDiscountNotNullPromotion++++++++++++++++++++++++++++++");
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println("++++++++++++++++++++++++++++++testDiscountNotNullPromotion++++++++++++++++++++++++++++++");
            System.out.println();
        }
    }

    @Test
    public void testDiscountSizePromotion() {
        Admin admin =  adminRepository.getOne(1L);
        Driver driver = driverRepository.getOne(1L);
        Position position =  positionRepository.getOne(1L);
        Salary d = new Salary();
        d.setAdmin(admin);
        d.setDriver(driver);
        d.setPosition(position);
        d.setPayment("a");
        d.setDate(new Date());
        d.setPrice(1200);
        
        try {
            entityManager.persist(d);
            entityManager.flush();

            //fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println("++++++++++++++++++++++++++++++testDiscountSizePromotion++++++++++++++++++++++++++++++");
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println("++++++++++++++++++++++++++++++testDiscountSizePromotion++++++++++++++++++++++++++++++");
            System.out.println();
        }
    }

    @Test
    public void testDiscountCannotUnique() {
        Admin admin =  adminRepository.getOne(1L);
        Driver driver = driverRepository.getOne(1L);
        Position position =  positionRepository.getOne(1L);
       
        Salary d = new Salary();
        d.setAdmin(admin);
        d.setDriver(driver);
        d.setPosition(position);
        d.setPayment("aaa");
        d.setDate(new Date());
        d.setPrice(1200);

        Discount d1 = new Discount();
        d.setAdmin(admin);
        d.setDriver(driver);
        d.setPosition(position);
        d.setPayment("aaa");
        d.setDate(new Date());
        d.setPrice(1200);
        
        try {
            entityManager.persist(d1);
            entityManager.flush();

            //fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            System.out.println();
            System.out.println("++++++++++++++++++++++++++++++testDiscountCannotUnique++++++++++++++++++++++++++++++");
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println("++++++++++++++++++++++++++++++testDiscountCannotUnique++++++++++++++++++++++++++++++");
            System.out.println();
        }catch (javax.persistence.PersistenceException e) {
            e.printStackTrace();
        }
    }
    

}