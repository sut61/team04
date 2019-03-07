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

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private DriverPCTRepository driverpctRepository;

    //++++++++++++++++++++++++++++Nice++++++++++++++++++++++++++++++++++++++++++++
    @Autowired
	private GenderRepository genderRepository;

	@Autowired
	private ProvinceRepository provinceRepository;

	@Autowired
	private CarTypeRepository carTypeRepository;

	@Autowired
	private CareerRepository careerRepository;

	//++++++++++++++++++++++++++++Nice+++++++++++++++++++++++++++++++++++++++++++++


	private Validator validator;
	private Member member;
	private Driver driver;
	private DriverTaxi driverTaxi;
	private Score score;

	//++++++++++++++++++++++++++++Nice++++++++++++++++++++++++++++++++++++++++++++++++
	private Gender gender;
	private Province province;
	private CarType carType;
	private Career career;
	//++++++++++++++++++++++++++++Nice++++++++++++++++++++++++++++++++++++++++++++++++

	@Before
	public void setup() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();

		gender = genderRepository.findBysex("Men");
		province = provinceRepository.findByname("จังหวัดเชียงใหม่");
		carType = carTypeRepository.findByname("Ferrari");
		career = careerRepository.findByname("รับจ้าง");
	}

 

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
// --------------------------------Test Member--------------------------------------------------------
	  @Test
	  public void testTrueMember() {
		  Member d = new Member();
		  d.setUsername("nicecpe");
		  d.setPassword("pandora");
		  d.setName("Channarong");
		  d.setAddress("3440000000000000");
		  d.setPhone("0938939801");
		  d.setGender(gender);
		  d.setProvince(province);
		  d.setCarType(carType);

		  try {
			  entityManager.persist(d);
			  entityManager.flush();

			  //fail("Should not pass to this line");
		  } catch(javax.validation.ConstraintViolationException e) {
			  Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			  assertEquals(violations.isEmpty(), false);
			  assertEquals(violations.size(), 0);
			  System.out.println();
			  System.out.println("++++++++++++++++++++++++++++++testTrueMember++++++++++++++++++++++++++++++");
			  System.out.println();
			  System.out.println(e.getMessage());
			  System.out.println();
			  System.out.println("++++++++++++++++++++++++++++++testTrueMember++++++++++++++++++++++++++++++");
			  System.out.println();
		  }
	  }

	@Test
	public void testPatternNameandPhoneMember() {
		Member d = new Member();
		d.setUsername("nicecpe");
		d.setPassword("pandora");
		d.setName("*/*78534*/");
		d.setAddress("3440000000000000");
		d.setPhone("09389398011");
		d.setGender(gender);
		d.setProvince(province);
		d.setCarType(carType);

		try {
			entityManager.persist(d);
			entityManager.flush();

			//fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 2);
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testPatternNameandPhoneMember++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testPatternNameandPhoneMember++++++++++++++++++++++++++++++");
			System.out.println();
		}
	}

	@Test
	public void testSizeAddressMember() {
		Member d = new Member();
		d.setUsername("nicecpe");
		d.setPassword("pandora");
		d.setName("Channarong");
		d.setAddress("34");
		d.setPhone("0938939801");
		d.setGender(gender);
		d.setProvince(province);
		d.setCarType(carType);

		try {
			entityManager.persist(d);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testSizeAddressMember++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testSizeAddressMember++++++++++++++++++++++++++++++");
			System.out.println();
		}
	}

	@Test
	public void testMaxMember() {
		Member d = new Member();
		d.setUsername("nicecpeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
		d.setPassword("pandoraaaaaaaaaaaaa");
		d.setName("Channaronggggggggggggggggggggggggggggggggggggggg");
		d.setAddress("344000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
		d.setPhone("09389398011");
		d.setGender(gender);
		d.setProvince(province);
		d.setCarType(carType);

		try {
			entityManager.persist(d);
			entityManager.flush();

			//fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 5);
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testSizeMember++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testSizeMember++++++++++++++++++++++++++++++");
			System.out.println();
		}
	}

	@Test
	public void testMaxUsernameMember() {
		Member d = new Member();
		d.setUsername("nicecpeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
		d.setPassword("pandora");
		d.setName("Channarong");
		d.setAddress("344000000000000");
		d.setPhone("0938939801");
		d.setGender(gender);
		d.setProvince(province);
		d.setCarType(carType);

		try {
			entityManager.persist(d);
			entityManager.flush();

			//fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testMaxUsernameMember++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testMaxUsernameMember++++++++++++++++++++++++++++++");
			System.out.println();
		}
	}

	@Test
	public void testMaxPasswordMember() {
		Member d = new Member();
		d.setUsername("nicecpe");
		d.setPassword("pandoraaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		d.setName("Channarong");
		d.setAddress("344000000000000");
		d.setPhone("0938939801");
		d.setGender(gender);
		d.setProvince(province);
		d.setCarType(carType);

		try {
			entityManager.persist(d);
			entityManager.flush();

			//fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testMaxPasswordMember++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testMaxPasswordMember++++++++++++++++++++++++++++++");
			System.out.println();
		}
	}

	@Test
	public void testMaxNameMember() {
		Member d = new Member();
		d.setUsername("nicecpe");
		d.setPassword("pandora");
		d.setName("Channarongggggggggggggggggggggggggggggggggggggggggggggggggggggg");
		d.setAddress("344000000000000");
		d.setPhone("0938939801");
		d.setGender(gender);
		d.setProvince(province);
		d.setCarType(carType);

		try {
			entityManager.persist(d);
			entityManager.flush();

			//fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testMaxNameMember++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testMaxNameMember++++++++++++++++++++++++++++++");
			System.out.println();
		}
	}

	@Test
	public void testMaxPhoneMember() {
		Member d = new Member();
		d.setUsername("nicecpe");
		d.setPassword("pandora");
		d.setName("Channarong");
		d.setAddress("344000000000000");
		d.setPhone("093893980111111");
		d.setGender(gender);
		d.setProvince(province);
		d.setCarType(carType);

		try {
			entityManager.persist(d);
			entityManager.flush();

			//fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testMaxPhoneMember++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testMaxPhoneMember++++++++++++++++++++++++++++++");
			System.out.println();
		}
	}

	@Test
	public void testMinMember() {
		Member d = new Member();
		d.setUsername("nic");
		d.setPassword("pan");
		d.setName("Cha");
		d.setAddress("34400");
		d.setPhone("09389398");
		d.setGender(gender);
		d.setProvince(province);
		d.setCarType(carType);

		try {
			entityManager.persist(d);
			entityManager.flush();

			//fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 5);
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testSizeMember++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testSizeMember++++++++++++++++++++++++++++++");
			System.out.println();
		}
	}

	@Test
	public void testMinUsernameMember() {
		Member d = new Member();
		d.setUsername("nic");
		d.setPassword("pandora");
		d.setName("Channarong");
		d.setAddress("344000000000000000000000");
		d.setPhone("0938939801");
		d.setGender(gender);
		d.setProvince(province);
		d.setCarType(carType);

		try {
			entityManager.persist(d);
			entityManager.flush();

			//fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testMinUsernameMember++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testMinUsernameMember++++++++++++++++++++++++++++++");
			System.out.println();
		}
	}

	@Test
	public void testMinPasswordMember() {
		Member d = new Member();
		d.setUsername("nicecpe");
		d.setPassword("pa");
		d.setName("Channarong");
		d.setAddress("344000000000000000000000");
		d.setPhone("0938939801");
		d.setGender(gender);
		d.setProvince(province);
		d.setCarType(carType);

		try {
			entityManager.persist(d);
			entityManager.flush();

			//fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testMinPasswordMember++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testMinPasswordMember++++++++++++++++++++++++++++++");
			System.out.println();
		}
	}

	@Test
	public void testMinNameMember() {
		Member d = new Member();
		d.setUsername("nicecpe");
		d.setPassword("pandora");
		d.setName("Ch");
		d.setAddress("344000000000000000000000");
		d.setPhone("0938939801");
		d.setGender(gender);
		d.setProvince(province);
		d.setCarType(carType);

		try {
			entityManager.persist(d);
			entityManager.flush();

			//fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testMinNameMember++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testMinNameMember++++++++++++++++++++++++++++++");
			System.out.println();
		}
	}

	@Test
	public void testMinPhoneMember() {
		Member d = new Member();
		d.setUsername("nicecpe");
		d.setPassword("pandora");
		d.setName("Channarong");
		d.setAddress("344000000000000000000000");
		d.setPhone("09389398");
		d.setGender(gender);
		d.setProvince(province);
		d.setCarType(carType);

		try {
			entityManager.persist(d);
			entityManager.flush();

			//fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testMinPhoneMember++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testMinPhoneMember++++++++++++++++++++++++++++++");
			System.out.println();
		}
	}

	@Test
	public void testNullMember() {
		Member d = new Member();
		d.setUsername(null);
		d.setPassword(null);
		d.setName(null);
		d.setAddress(null);
		d.setPhone(null);
		d.setGender(null);
		d.setProvince(null);
		d.setCarType(null);

		try {
			entityManager.persist(d);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 8);
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testNullMember++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testNullMember++++++++++++++++++++++++++++++");
			System.out.println();
		}
	}

	@Test
	public void testNullUsernameMember() {
		Member d = new Member();
		d.setUsername(null);
		d.setPassword("pandora");
		d.setName("Channarong");
		d.setAddress("3440000000000000");
		d.setPhone("0938939801");
		d.setGender(gender);
		d.setProvince(province);
		d.setCarType(carType);

		try {
			entityManager.persist(d);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testNullUsernameMember++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testNullUsernameMember++++++++++++++++++++++++++++++");
			System.out.println();
		}
	}

	@Test
	public void testNullPasswordMember() {
		Member d = new Member();
		d.setUsername("nicecpe");
		d.setPassword(null);
		d.setName("Channarong");
		d.setAddress("3440000000000000");
		d.setPhone("0938939801");
		d.setGender(gender);
		d.setProvince(province);
		d.setCarType(carType);

		try {
			entityManager.persist(d);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testNullPasswordMember++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testNullPasswordMember++++++++++++++++++++++++++++++");
			System.out.println();
		}
	}

	@Test
	public void testNullNameMember() {
		Member d = new Member();
		d.setUsername("nicecpe");
		d.setPassword("pandora");
		d.setName(null);
		d.setAddress("3440000000000000");
		d.setPhone("0938939801");
		d.setGender(gender);
		d.setProvince(province);
		d.setCarType(carType);

		try {
			entityManager.persist(d);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testNullNameMember++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testNullNameMember++++++++++++++++++++++++++++++");
			System.out.println();
		}
	}

	@Test
	public void testNullAddressMember() {
		Member d = new Member();
		d.setUsername("nicecpe");
		d.setPassword("pandora");
		d.setName("Channarong");
		d.setAddress(null);
		d.setPhone("0938939801");
		d.setGender(gender);
		d.setProvince(province);
		d.setCarType(carType);

		try {
			entityManager.persist(d);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testNullAddressMember++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testNullAddressMember++++++++++++++++++++++++++++++");
			System.out.println();
		}
	}

	@Test
	public void testNullPhoneMember() {
		Member d = new Member();
		d.setUsername("nicecpe");
		d.setPassword("pandora");
		d.setName("Channarong");
		d.setAddress("3440000000000000");
		d.setPhone(null);
		d.setGender(gender);
		d.setProvince(province);
		d.setCarType(carType);

		try {
			entityManager.persist(d);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testNullPhoneMember++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testNullPhoneMember++++++++++++++++++++++++++++++");
			System.out.println();
		}
	}

	@Test
	public void testNullGenderMember() {
		Member d = new Member();
		d.setUsername("nicecpe");
		d.setPassword("pandora");
		d.setName("Channarong");
		d.setAddress("3440000000000000");
		d.setPhone("0938939801");
		d.setGender(null);
		d.setProvince(province);
		d.setCarType(carType);

		try {
			entityManager.persist(d);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testNullGenderMember++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testNullGenderMember++++++++++++++++++++++++++++++");
			System.out.println();
		}
	}

	@Test
	public void testNullProvinceMember() {
		Member d = new Member();
		d.setUsername("nicecpe");
		d.setPassword("pandora");
		d.setName("Channarong");
		d.setAddress("3440000000000000");
		d.setPhone("0938939801");
		d.setGender(gender);
		d.setProvince(null);
		d.setCarType(carType);

		try {
			entityManager.persist(d);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testNullProvinceMember++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testNullProvinceMember++++++++++++++++++++++++++++++");
			System.out.println();
		}
	}

	@Test
	public void testNullCarTypeMember() {
		Member d = new Member();
		d.setUsername("nicecpe");
		d.setPassword("pandora");
		d.setName("Channarong");
		d.setAddress("3440000000000000");
		d.setPhone("0938939801");
		d.setGender(gender);
		d.setProvince(province);
		d.setCarType(null);

		try {
			entityManager.persist(d);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testNullCarTypeMember++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testNullCarTypeMember++++++++++++++++++++++++++++++");
			System.out.println();
		}
	}
// --------------------------------Test Member--------------------------------------------------------

// --------------------------------Test DriverPCT--------------------------------------------------------
@Test
public void testTrueDriverPCT() {
	DriverPCT d = new DriverPCT();
	d.setUsername("nicecpe");
	d.setPassword("pandora");
	d.setName("Channarong");
	d.setAddress("3440000000000000");
	d.setVehicleType("car");
	d.setPhone("0938939801");
	d.setGender(gender);
	d.setProvince(province);
	d.setCareer(career);

	try {
		entityManager.persist(d);
		entityManager.flush();

		//fail("Should not pass to this line");
	} catch(javax.validation.ConstraintViolationException e) {
		Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
		assertEquals(violations.isEmpty(), false);
		assertEquals(violations.size(), 0);
		System.out.println();
		System.out.println("++++++++++++++++++++++++++++++testTrueDriverPCT++++++++++++++++++++++++++++++");
		System.out.println();
		System.out.println(e.getMessage());
		System.out.println();
		System.out.println("++++++++++++++++++++++++++++++testTrueDriverPCT++++++++++++++++++++++++++++++");
		System.out.println();
	}
}

	@Test
	public void testPatternNameDriverPCT() {
		DriverPCT d = new DriverPCT();
		d.setUsername("nicecpe");
		d.setPassword("pandora");
		d.setName("*/*78534*/");
		d.setAddress("3440000000000000");
		d.setVehicleType("car");
		d.setPhone("0938939801");
		d.setGender(gender);
		d.setProvince(province);
		d.setCareer(career);

		try {
			entityManager.persist(d);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testPatternNameDriverPCT++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testPatternNameDriverPCT++++++++++++++++++++++++++++++");
			System.out.println();
		}
	}

	@Test
	public void testPatternPhoneDriverPCT() {
		DriverPCT d = new DriverPCT();
		d.setUsername("nicecpe");
		d.setPassword("pandora");
		d.setName("channarong");
		d.setAddress("3440000000000000");
		d.setVehicleType("car");
		d.setPhone("0938939801111");
		d.setGender(gender);
		d.setProvince(province);
		d.setCareer(career);

		try {
			entityManager.persist(d);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testPatternPhoneDriverPCT++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testPatternPhoneDriverPCT++++++++++++++++++++++++++++++");
			System.out.println();
		}
	}

	@Test
	public void testPatternVehicleTypeDriverPCT() {
		DriverPCT d = new DriverPCT();
		d.setUsername("nicecpe");
		d.setPassword("pandora");
		d.setName("channarong");
		d.setAddress("3440000000000000");
		d.setVehicleType("ca");
		d.setPhone("0938939801");
		d.setGender(gender);
		d.setProvince(province);
		d.setCareer(career);

		try {
			entityManager.persist(d);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testPatternVehicleTypeDriverPCT++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testPatternVehicleTypeDriverPCT++++++++++++++++++++++++++++++");
			System.out.println();
		}
	}

	@Test
	public void testSizeAddressDriverPCT() {
		DriverPCT d = new DriverPCT();
		d.setUsername("nicecpe");
		d.setPassword("pandora");
		d.setName("Channarong");
		d.setAddress("34");
		d.setVehicleType("car");
		d.setPhone("0938939801");
		d.setGender(gender);
		d.setProvince(province);
		d.setCareer(career);

		try {
			entityManager.persist(d);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testSizeAddressDriverPCT++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testSizeAddressDriverPCT++++++++++++++++++++++++++++++");
			System.out.println();
		}
	}

	@Test
	public void testMaxDriverPCT() {
		DriverPCT d = new DriverPCT();
		d.setUsername("nicecperrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
		d.setPassword("pandoraaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		d.setName("Channarongggggggggggggggggggggggggggggggggggggggggggggg");
		d.setAddress("3440000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
		d.setVehicleType("carrrrrrrrrrrrtrhtrhtyhtrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrhtgrhtyrtr");
		d.setPhone("09333338939801111111");
		d.setGender(gender);
		d.setProvince(province);
		d.setCareer(career);
		try {
			entityManager.persist(d);
			entityManager.flush();

			//fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 6);
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testSizeDriverPCT++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testSizeDriverPCT++++++++++++++++++++++++++++++");
			System.out.println();
		}
	}

	@Test
	public void testMaxUsernameDriverPCT() {
		DriverPCT d = new DriverPCT();
		d.setUsername("nicecperrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
		d.setPassword("pandora");
		d.setName("Channarong");
		d.setAddress("34400000000000");
		d.setVehicleType("car");
		d.setPhone("0938939801");
		d.setGender(gender);
		d.setProvince(province);
		d.setCareer(career);
		try {
			entityManager.persist(d);
			entityManager.flush();

			//fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testMaxUsernameDriverPCT++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testMaxUsernameDriverPCT++++++++++++++++++++++++++++++");
			System.out.println();
		}
	}

	@Test
	public void testMaxPasswordDriverPCT() {
		DriverPCT d = new DriverPCT();
		d.setUsername("nicecpe");
		d.setPassword("pandoraaaaaaaaaaaaaaaaaaa");
		d.setName("Channarong");
		d.setAddress("34400000000000");
		d.setVehicleType("car");
		d.setPhone("0938939801");
		d.setGender(gender);
		d.setProvince(province);
		d.setCareer(career);
		try {
			entityManager.persist(d);
			entityManager.flush();

			//fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testMaxPasswordDriverPCT++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testMaxPasswordDriverPCT++++++++++++++++++++++++++++++");
			System.out.println();
		}
	}

	@Test
	public void testMaxVehicleTypeDriverPCT() {
		DriverPCT d = new DriverPCT();
		d.setUsername("nicecpe");
		d.setPassword("pandora");
		d.setName("Channarong");
		d.setAddress("34400000000000");
		d.setVehicleType("carrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
		d.setPhone("0938939801");
		d.setGender(gender);
		d.setProvince(province);
		d.setCareer(career);
		try {
			entityManager.persist(d);
			entityManager.flush();

			//fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testMaxVehicleTypeDriverPCT++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testMaxVehicleTypeDriverPCT++++++++++++++++++++++++++++++");
			System.out.println();
		}
	}

	@Test
	public void testMaxPhoneDriverPCT() {
		DriverPCT d = new DriverPCT();
		d.setUsername("nicecpe");
		d.setPassword("pandora");
		d.setName("Channarong");
		d.setAddress("34400000000000");
		d.setVehicleType("car");
		d.setPhone("09389398011111111111111111111111");
		d.setGender(gender);
		d.setProvince(province);
		d.setCareer(career);
		try {
			entityManager.persist(d);
			entityManager.flush();

			//fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testMaxPhoneDriverPCT++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testMaxPhoneDriverPCT++++++++++++++++++++++++++++++");
			System.out.println();
		}
	}

	@Test
	public void testMinDriverPCT() {
		DriverPCT d = new DriverPCT();
		d.setUsername("nice");
		d.setPassword("pan");
		d.setName("Ch");
		d.setAddress("3400");
		d.setVehicleType("ca");
		d.setPhone("093");
		d.setGender(gender);
		d.setProvince(province);
		d.setCareer(career);
		try {
			entityManager.persist(d);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 6);
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testSizeDriverPCT++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testSizeDriverPCT++++++++++++++++++++++++++++++");
			System.out.println();
		}
	}

	@Test
	public void testMinUsernameDriverPCT() {
		DriverPCT d = new DriverPCT();
		d.setUsername("nic");
		d.setPassword("pandora");
		d.setName("Channarong");
		d.setAddress("34400000000000");
		d.setVehicleType("car");
		d.setPhone("0938939801");
		d.setGender(gender);
		d.setProvince(province);
		d.setCareer(career);
		try {
			entityManager.persist(d);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testMinUsernameDriverPCT++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testMinUsernameDriverPCT++++++++++++++++++++++++++++++");
			System.out.println();
		}
	}

	@Test
	public void testMinPasswordDriverPCT() {
		DriverPCT d = new DriverPCT();
		d.setUsername("nicecpe");
		d.setPassword("pan");
		d.setName("Channarong");
		d.setAddress("34400000000000");
		d.setVehicleType("car");
		d.setPhone("0938939801");
		d.setGender(gender);
		d.setProvince(province);
		d.setCareer(career);
		try {
			entityManager.persist(d);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testMinPasswordDriverPCT++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testMinPasswordDriverPCT++++++++++++++++++++++++++++++");
			System.out.println();
		}
	}

	@Test
	public void testMinNameDriverPCT() {
		DriverPCT d = new DriverPCT();
		d.setUsername("nicecpe");
		d.setPassword("pandora");
		d.setName("Ch");
		d.setAddress("34400000000000");
		d.setVehicleType("car");
		d.setPhone("0938939801");
		d.setGender(gender);
		d.setProvince(province);
		d.setCareer(career);
		try {
			entityManager.persist(d);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testMinNameDriverPCT++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testMinNameDriverPCT++++++++++++++++++++++++++++++");
			System.out.println();
		}
	}

	@Test
	public void testMinVehicleTypeDriverPCT() {
		DriverPCT d = new DriverPCT();
		d.setUsername("nicecpe");
		d.setPassword("pandora");
		d.setName("Channarong");
		d.setAddress("34400000000000");
		d.setVehicleType("ca");
		d.setPhone("0938939801");
		d.setGender(gender);
		d.setProvince(province);
		d.setCareer(career);
		try {
			entityManager.persist(d);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testMinVehicleTypeDriverPCT++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testMinVehicleTypeDriverPCT++++++++++++++++++++++++++++++");
			System.out.println();
		}
	}

	@Test
	public void testMinPhoneDriverPCT() {
		DriverPCT d = new DriverPCT();
		d.setUsername("nicecpe");
		d.setPassword("pandora");
		d.setName("Channarong");
		d.setAddress("34400000000000");
		d.setVehicleType("car");
		d.setPhone("0938939");
		d.setGender(gender);
		d.setProvince(province);
		d.setCareer(career);
		try {
			entityManager.persist(d);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testMinPhoneDriverPCT++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testMinPhoneDriverPCT++++++++++++++++++++++++++++++");
			System.out.println();
		}
	}

	@Test
	public void testNullDriverPCT() {
		DriverPCT d = new DriverPCT();
		d.setUsername(null);
		d.setPassword(null);
		d.setName(null);
		d.setAddress(null);
		d.setVehicleType(null);
		d.setPhone(null);
		d.setGender(null);
		d.setProvince(null);
		d.setCareer(null);

		try {
			entityManager.persist(d);
			entityManager.flush();

			//fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 9);
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testNullDriverPCT++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testNullDriverPCT++++++++++++++++++++++++++++++");
			System.out.println();
		}
	}

	@Test
	public void testUsernameDriverPCT() {
		DriverPCT d = new DriverPCT();
		d.setUsername(null);
		d.setPassword("pandora");
		d.setName("Channarong");
		d.setAddress("3440000000000000");
		d.setVehicleType("car");
		d.setPhone("0938939801");
		d.setGender(gender);
		d.setProvince(province);
		d.setCareer(career);

		try {
			entityManager.persist(d);
			entityManager.flush();

			//fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testUsernameDriverPCT++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testUsernameDriverPCT++++++++++++++++++++++++++++++");
			System.out.println();
		}
	}

	@Test
	public void testPasswordDriverPCT() {
		DriverPCT d = new DriverPCT();
		d.setUsername("nicecpe");
		d.setPassword(null);
		d.setName("Channarong");
		d.setAddress("3440000000000000");
		d.setVehicleType("car");
		d.setPhone("0938939801");
		d.setGender(gender);
		d.setProvince(province);
		d.setCareer(career);

		try {
			entityManager.persist(d);
			entityManager.flush();

			//fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testPasswordDriverPCT++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testPasswordDriverPCT++++++++++++++++++++++++++++++");
			System.out.println();
		}
	}

	@Test
	public void testNameDriverPCT() {
		DriverPCT d = new DriverPCT();
		d.setUsername("nicecpe");
		d.setPassword("pandora");
		d.setName(null);
		d.setAddress("3440000000000000");
		d.setVehicleType("car");
		d.setPhone("0938939801");
		d.setGender(gender);
		d.setProvince(province);
		d.setCareer(career);

		try {
			entityManager.persist(d);
			entityManager.flush();

			//fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testNameDriverPCT++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testNameDriverPCT++++++++++++++++++++++++++++++");
			System.out.println();
		}
	}

	@Test
	public void testAddressDriverPCT() {
		DriverPCT d = new DriverPCT();
		d.setUsername("nicecpe");
		d.setPassword("pandora");
		d.setName("Channarong");
		d.setAddress(null);
		d.setVehicleType("car");
		d.setPhone("0938939801");
		d.setGender(gender);
		d.setProvince(province);
		d.setCareer(career);

		try {
			entityManager.persist(d);
			entityManager.flush();

			//fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testAddressDriverPCT++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testAddressDriverPCT++++++++++++++++++++++++++++++");
			System.out.println();
		}
	}

	@Test
	public void testVehicleTypeDriverPCT() {
		DriverPCT d = new DriverPCT();
		d.setUsername("nicecpe");
		d.setPassword("pandora");
		d.setName("Channarong");
		d.setAddress("3440000000000000");
		d.setVehicleType(null);
		d.setPhone("0938939801");
		d.setGender(gender);
		d.setProvince(province);
		d.setCareer(career);

		try {
			entityManager.persist(d);
			entityManager.flush();

			//fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testVehicleTypeDriverPCT++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testVehicleTypeDriverPCT++++++++++++++++++++++++++++++");
			System.out.println();
		}
	}

	@Test
	public void testPhoneDriverPCT() {
		DriverPCT d = new DriverPCT();
		d.setUsername("nicecpe");
		d.setPassword("pandora");
		d.setName("Channarong");
		d.setAddress("3440000000000000");
		d.setVehicleType("car");
		d.setPhone(null);
		d.setGender(gender);
		d.setProvince(province);
		d.setCareer(career);

		try {
			entityManager.persist(d);
			entityManager.flush();

			//fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testPhoneDriverPCT++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testPhoneDriverPCT++++++++++++++++++++++++++++++");
			System.out.println();
		}
	}

	@Test
	public void testGenderDriverPCT() {
		DriverPCT d = new DriverPCT();
		d.setUsername("nicecpe");
		d.setPassword("pandora");
		d.setName("Channarong");
		d.setAddress("3440000000000000");
		d.setVehicleType("car");
		d.setPhone("0938939801");
		d.setGender(null);
		d.setProvince(province);
		d.setCareer(career);

		try {
			entityManager.persist(d);
			entityManager.flush();

			//fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testGenderDriverPCT++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testGenderDriverPCT++++++++++++++++++++++++++++++");
			System.out.println();
		}
	}

	@Test
	public void testProvinceDriverPCT() {
		DriverPCT d = new DriverPCT();
		d.setUsername("nicecpe");
		d.setPassword("pandora");
		d.setName("Channarong");
		d.setAddress("3440000000000000");
		d.setVehicleType("car");
		d.setPhone("0938939801");
		d.setGender(gender);
		d.setProvince(null);
		d.setCareer(career);

		try {
			entityManager.persist(d);
			entityManager.flush();

			//fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testProvinceDriverPCT++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testProvinceDriverPCT++++++++++++++++++++++++++++++");
			System.out.println();
		}
	}

	@Test
	public void testCareerDriverPCT() {
		DriverPCT d = new DriverPCT();
		d.setUsername("nicecpe");
		d.setPassword("pandora");
		d.setName("Channarong");
		d.setAddress("3440000000000000");
		d.setVehicleType("car");
		d.setPhone("0938939801");
		d.setGender(gender);
		d.setProvince(province);
		d.setCareer(null);

		try {
			entityManager.persist(d);
			entityManager.flush();

			//fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testCareerDriverPCT++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++testCareerDriverPCT++++++++++++++++++++++++++++++");
			System.out.println();
		}
	}

// --------------------------------Test DriverPCT--------------------------------------------------------

}

