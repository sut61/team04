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
public class CommmentTest {
   @Autowired
   private TestEntityManager entityManager;

   @Autowired
   private CommentRepository  commentRepository;

   private Validator validator;
   private Member member;
   private Driver driver;
   private DriverTaxi driverTaxi;
   private Score score;

   @Before
   public void setup() {
       ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
       validator = factory.getValidator();
   }



   //+++++++++++++++++++++++++++++++++++Comment+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

   @Test
   public void testCommentTrue() {
       Comment s = new Comment();
       s.setComment("Very Good");
       s.setNameDriver("Hassad");
       s.setNameMamber("moss thirawuth");
       s.setPhoneDriver("0812345678");
       s.setPhoneMamber("0912345678");
       s.setMember(member);
       s.setDriver(driver);
       s.setDriverTaxi(driverTaxi);
       s.setScore(score);


//        try {
//            entityManager.persist(s);
//            entityManager.flush();
//			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Comment is True %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
//            //fail("Should not pass to this line");
//        } catch(javax.validation.ConstraintViolationException e) {
//            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//            assertEquals(violations.isEmpty(), false);
//            assertEquals(violations.size(), 2);
//
//		}
   }


   @Test
   public void testCommentCannotSize() {
       Comment s = new Comment();
       s.setComment("Very");
       s.setNameDriver("asdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasd");
       s.setNameMamber("asdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasd");
       s.setPhoneDriver("08123456780");
       s.setPhoneMamber("09123456780");
       s.setMember(member);
       s.setDriver(driver);
       s.setDriverTaxi(driverTaxi);
       s.setScore(score);


       try {
           entityManager.persist(s);
           entityManager.flush();

           fail("Should not pass to this line");
       } catch(javax.validation.ConstraintViolationException e) {
           Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
           assertEquals(violations.isEmpty(), false);
           assertEquals(violations.size(), 7);
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
       s.setMember(member);
       s.setDriver(driver);
       s.setDriverTaxi(driverTaxi);
       s.setScore(score);


       try {
           entityManager.persist(s);
           entityManager.flush();

           fail("Should not pass to this line");
       } catch(javax.validation.ConstraintViolationException e) {
           Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
           assertEquals(violations.isEmpty(), false);
           assertEquals(violations.size(), 7);
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
       s.setMember(null);
       s.setDriver(driver);
       s.setDriverTaxi(driverTaxi);
       s.setScore(null);


       try {
           entityManager.persist(s);
           entityManager.flush();

           fail("Should not pass to this line");
       } catch(javax.validation.ConstraintViolationException e) {
           Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
           assertEquals(violations.isEmpty(), false);
           assertEquals(violations.size(), 7);
           System.out.println();
           System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% testCommentNotNull %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
           System.out.println();
           System.out.println(e.getMessage());
           System.out.println();
           System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% testCommentNotNull %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
           System.out.println();

       }
   }

   @Test
   public void testCommentCannotUnique() {
       Comment s = new Comment();
       s.setComment("Very Good");
       s.setNameDriver("Hassad");
       s.setNameMamber("moss thirawuth");
       s.setPhoneDriver("0812345678");
       s.setPhoneMamber("0912345678");
       s.setId(12345678910L);
       s.setMember(member);
       s.setScore(score);

       Comment s1 = new Comment();
       s1.setComment("Very Good");
       s1.setNameDriver("Hassad");
       s1.setNameMamber("moss thirawuth");
       s1.setPhoneDriver("0812345678");
       s1.setPhoneMamber("0912345678");
       s1.setId(12345678910L);
       s1.setMember(member);
       s1.setScore(score);


       try {
           entityManager.persist(s1);
           entityManager.flush();

           fail("Should not pass to this line");
       } catch(javax.validation.ConstraintViolationException e) {
           Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
           assertEquals(violations.isEmpty(), false);
           assertEquals(violations.size(), 2);
           System.out.println();
           System.out.println("************************************************* testComplainCannotSize *************************************************");
           System.out.println();
           System.out.println(e.getMessage());
           System.out.println();
           System.out.println("************************************************* testComplainCannotSize *************************************************");
           System.out.println();

       }catch (javax.persistence.PersistenceException e) {
           e.printStackTrace();
       }
   }

   //+++++++++++++++++++++++++++++++++++Comment+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


}
