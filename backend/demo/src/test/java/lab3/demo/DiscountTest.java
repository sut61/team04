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
public class DiscountTest {
	
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private DiscountRepository discountRepository;

    @Autowired
    private CarTypeRepository carTypeRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private TimeRangeRepository timeRangeRepository;


	private Validator validator;
	private Admin admin;
	private CarType carType;
	private TimeRange timeRange;
	

	@Before
	public void setup() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
    }


    @Test
    public void testDiscountTrue() {
        Admin admin =  adminRepository.getOne(1L);
        CarType carType = carTypeRepository.getOne(1L);
        TimeRange timeRange =  timeRangeRepository.getOne(1L);
       
        Discount d = new Discount();
        d.setAdmin(admin);
        d.setCarType(carType);
        d.setTimeRange(timeRange);
        d.setPromotion("sadas");
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
        CarType carType = carTypeRepository.getOne(1L);
        TimeRange timeRange =  timeRangeRepository.getOne(1L);
       
        Discount d = new Discount();
        d.setAdmin(admin);
        d.setCarType(carType);
        d.setTimeRange(timeRange);
        d.setPromotion("sasdads");
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
        CarType carType = carTypeRepository.getOne(1L);
        TimeRange timeRange =  timeRangeRepository.getOne(1L);
    
        Discount d = new Discount();
        d.setAdmin(admin);
        d.setCarType(carType);
        d.setTimeRange(timeRange);
        d.setPromotion("*34/454/*/*");
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
        CarType carType = carTypeRepository.getOne(1L);
        TimeRange timeRange =  timeRangeRepository.getOne(1L);
       
        Discount d = new Discount();
        d.setAdmin(admin);
        d.setCarType(carType);
        d.setTimeRange(timeRange);
        d.setPromotion(null);
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
        CarType carType = carTypeRepository.getOne(1L);
        TimeRange timeRange =  timeRangeRepository.getOne(1L);
       
        Discount d = new Discount();
        d.setAdmin(admin);
        d.setCarType(carType);
        d.setTimeRange(timeRange);
        d.setPromotion("a");
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
        CarType carType = carTypeRepository.getOne(1L);
        TimeRange timeRange =  timeRangeRepository.getOne(1L);
       
        Discount d = new Discount();
        d.setAdmin(admin);
        d.setCarType(carType);
        d.setTimeRange(timeRange);
        d.setPromotion("aaa");
        d.setDate(new Date());
        d.setPrice(1200);

        Discount d1 = new Discount();
        d.setAdmin(admin);
        d.setCarType(carType);
        d.setTimeRange(timeRange);
        d.setPromotion("aaa");
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