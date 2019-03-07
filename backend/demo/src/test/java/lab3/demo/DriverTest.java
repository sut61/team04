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
public class DriverTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private GenderRepository  genderRepository;

    @Autowired
    private ProvinceRepository  provinceRepository;

    @Autowired
    private CarTypeRepository  carTypeRepository;

    private Validator validator;
    private CarType carType;
    private Province province;
    private Gender gender;


    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testTrueDriver() {
        Driver d = new Driver();
        d.setName("Anuttapon");
        d.setTel("0949366256");
        d.setAddress("3440000000000000");
        d.setEmail("Anuttapon@dsdsds.com");
        d.setUsername("sssss");
        d.setPassword("sssss");
        d.setCarType(carType);
        d.setProvince(province);
        d.setGender(gender);


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
        d.setUsername("sssss");
        d.setPassword("sssss");
        d.setCarType(carType);
        d.setProvince(province);
        d.setGender(gender);


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
        d.setUsername("sssss");
        d.setPassword("sssss");
        d.setCarType(carType);
        d.setProvince(province);
        d.setGender(gender);


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
        d.setUsername("sssss");
        d.setPassword("sssss");
        d.setCarType(carType);
        d.setProvince(province);
        d.setGender(gender);


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
        d.setUsername("sssss");
        d.setPassword("sssss");
        d.setCarType(carType);
        d.setProvince(province);
        d.setGender(gender);


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
        d.setUsername("sssss");
        d.setPassword("sssss");
        d.setCarType(carType);
        d.setProvince(province);
        d.setGender(gender);


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

    @Test
    public void testSizeUsername() {
        Driver d = new Driver();
        d.setName("Anuttapon");
        d.setTel("0949366256");
        d.setAddress("3440000000000000");
        d.setEmail("Anuttapon@dsdsds.com");
        d.setUsername("ssssssssssssssssssss");
        d.setPassword("sssss");
        d.setCarType(carType);
        d.setProvince(province);
        d.setGender(gender);


        try {
            entityManager.persist(d);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println("++++++++++++++++++++++++++++++testSizeUsername++++++++++++++++++++++++++++++");
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println("++++++++++++++++++++++++++++++testSizeUsername++++++++++++++++++++++++++++++");
            System.out.println();
        }
    }

    @Test
    public void testPatternPassword() {
        Driver d = new Driver();
        d.setName("Anuttapon");
        d.setTel("0949366256");
        d.setAddress("3440000000000000");
        d.setEmail("Anuttapon@dsdsds.com");
        d.setUsername("sssss");
        d.setPassword("******");
        d.setCarType(carType);
        d.setProvince(province);
        d.setGender(gender);


        try {
            entityManager.persist(d);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println("++++++++++++++++++++++++++++++testPatternPassword++++++++++++++++++++++++++++++");
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println("++++++++++++++++++++++++++++++testPatternPassword++++++++++++++++++++++++++++++");
            System.out.println();
        }
    }
    @Test
    public void testDriverCannotUnique() {
        Driver d = new Driver();
        d.setName("Anuttapon");
        d.setTel("0949366256");
        d.setAddress("3440000000000000");
        d.setEmail("Anuttapon@dsdsds.com");
        d.setUsername("sssss");
        d.setPassword("sssss");
        d.setId(12345678910L);
        d.setCarType(carType);
        d.setProvince(province);
        d.setGender(gender);

        Driver d1 = new Driver();
        d1.setName("Anuttapon");
        d1.setTel("0949366256");
        d1.setAddress("3440000000000000");
        d1.setEmail("Anuttapon@dsdsds.com");
        d1.setUsername("sssss");
        d1.setPassword("sssss");
        d1.setId(12345678910L);
        d1.setCarType(carType);
        d1.setProvince(province);
        d1.setGender(gender);


        try {
            entityManager.persist(d1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            System.out.println();
            System.out.println("************************************************* testDriverCannotUnique *************************************************");
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println("************************************************* testDriverCannotUnique *************************************************");
            System.out.println();

        }catch (javax.persistence.PersistenceException e) {
            e.printStackTrace();
        }
    }
}
