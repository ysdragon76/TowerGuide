package com.oawg.io;

import com.oawg.io.dao.DriveDataRepository;
import com.oawg.io.domain.DrivePlaceMarkerVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class Application {
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(DriveDataRepository repository) {
		return (args) -> {
			// save a couple of customers
			// fetch all customers
//			log.info("Customers found with findAll():");
//			log.info("-------------------------------");
//			for (DrivePlaceMarkerVO customer : repository.findAll()) {
//				log.info(customer.toString());
//			}
//			log.info("");

			// fetch an individual customer by ID
			Long foo[] = { 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L };

			List<Long> list = Arrays.asList(foo);
// or
//			Iterable<Long> iterable = Arrays.asList(foo);
//			repository.findAllById(iterable).ifPresent(data -> {
//						log.info("Customer found with findById(1L):");
//						log.info("--------------------------------");
//						log.info(data.toString());
//						log.info("");
//					});

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
//			repository.findByStateIgnoreCase("D").forEach(bauer -> {
//				log.info(bauer.toString());
//			});
			// for (Customer bauer : repository.findByLastName("Bauer")) {
			// 	log.info(bauer.toString());
			// }
			log.info("");
		};
	}
}
