package lab3.demo;

import lab3.demo.Entity.*;
import lab3.demo.Repository.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import java.util.stream.Stream;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	ApplicationRunner init(CarTypeRepository repository,
							BankRepository bankrepository,
							GenderRepository genderRepository,
							ProvinceRepository provinceRepository,
							CareerRepository careerRepository,
							DriverTaxiRepository driverTaxiRepository,
							TimeRangeRepository timeRangeRepository,
							AdminRepository adminRepository,
						    CauseRepository causeRepository,
							   PriceTypeRepository priceTypeRepository,
							   ScoreRepository scoreRepository) {
		return args -> {
			Stream.of("Ferrari", "Jaguar", "Porsche", "Lamborghini", "Bugatti",
					"AMC Gremlin", "Triumph Stag", "Ford Pinto", "Yugo GV").forEach(name -> {
				CarType car = new CarType();
				car.setName(name);
				repository.save(car);
			});
			repository.findAll().forEach(System.out::println);

			Stream.of("Men", "Women").forEach(name -> {
				Gender gender = new Gender();
				gender.setSex(name);
				genderRepository.save(gender);
			});
			genderRepository.findAll().forEach(System.out::println);


			
				DriverTaxi driverTaxi = new DriverTaxi();
				driverTaxi.setName("name1");
				driverTaxi.setTel("0866666666");
				driverTaxi.setAddress("Address1");
				driverTaxi.setEmail("Email1");
				driverTaxiRepository.save(driverTaxi);
			

			driverTaxiRepository.findAll().forEach(System.out::println);


			Stream.of("จังหวัดเชียงใหม่", "จังหวัดเชียงราย", "จังหวัดลำปาง", "จังหวัดลำพูน", "จังหวัดแม่ฮ่องสอน",
					"จังหวัดน่าน", "จังหวัดพะเยา", "จังหวัดแพร่", "จังหวัดอุตรดิตถ์").forEach(name -> {
				Province province = new Province();
				province.setName(name);
				provinceRepository.save(province);
			});
			provinceRepository.findAll().forEach(System.out::println);

			Stream.of("รับจ้าง", "ข้าราชการ", "นักศึกษา", "ว่างงาน").forEach(name -> {
				Career career = new Career();
				career.setName(name);
				careerRepository.save(career);
			});
			careerRepository.findAll().forEach(System.out::println);

			Stream.of(1, 2, 3, 4, 5
					).forEach(name -> {
				Score province = new Score();
				province.setPoint(name);
				scoreRepository.save(province);
			});
			provinceRepository.findAll().forEach(System.out::println);

			Stream.of("กษิกรนะ", "ไทยพานิชนะ", "กรุงทองนะ").forEach(name -> {
				Bank bank = new Bank();
				bank.setName(name);
				bankrepository.save(bank);
			});
			bankrepository.findAll().forEach(System.out::println);

			Stream.of("รถยางรั่ว", "เกิดอุบัติเหตุ", "น้ำมันหมด", "ไม่ทราบสาเหตุ", "อื่นๆ"
					).forEach(name -> {
				PriceType priceType = new PriceType();
				priceType.setPriceType(name);
				priceTypeRepository.save(priceType);
			});
			priceTypeRepository.findAll().forEach(System.out::println);

			Stream.of("ราคา 200 บาท รถจักรยานยนต์", "ราคา 500 บาท รถ ECO-Car", "ราคา 700 บาท รถ Compact Car", "ราคา 1000 บาท รถ Mid-Size Car", "ราคา 1500 บาท รถ Full-Size Car"
			).forEach(causetype -> {
				Cause cause = new Cause();
				cause.setCauseType(causetype);
				causeRepository.save(cause);
			});
			causeRepository.findAll().forEach(System.out::println);

			
			TimeRange t = new TimeRange();
			t.setTimeRange("08.00-12.00");
			t.setStart("08.00");
			t.setFinish("12.00");
			timeRangeRepository.save(t);

			TimeRange t1 = new TimeRange();
			t1.setTimeRange("12.00-16.00");
			t1.setStart("12.00");
			t1.setFinish("16.00");
			timeRangeRepository.save(t1);

			TimeRange t2 = new TimeRange();
			t2.setTimeRange("16.00-20.00");
			t2.setStart("16.00");
			t2.setFinish("20.00");
			timeRangeRepository.save(t2);

			TimeRange t3 = new TimeRange();
			t3.setTimeRange("20.00-24.00");
			t3.setStart("20.00");
			t3.setFinish("24.00");
			timeRangeRepository.save(t3);
		

		timeRangeRepository.findAll().forEach(System.out::println);

		Admin a = new Admin();
			a.setUsername("pop");
			a.setPassword("123");
			a.setName("POP");
			adminRepository.save(a);
		

		adminRepository.findAll().forEach(System.out::println);
		};

		
		
	}
}

