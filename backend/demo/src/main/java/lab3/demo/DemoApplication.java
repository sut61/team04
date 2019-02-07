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
							DriverTaxiRepository driverTaxiRepository,
						    CauseRepository causeRepository,
						   	PriceTypeRepository priceTypeRepository) {
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
		};
		
	}
}

