package sg.edu.nus.iss.day15demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sg.edu.nus.iss.day15demo.repo.TestRepo;

@SpringBootApplication
public class Day15DemoApplication implements CommandLineRunner {

	@Autowired
	TestRepo testRepo;

	public static void main(String[] args) {
		SpringApplication.run(Day15DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		testRepo.storeValueData("count", String.valueOf(1000));
		String countValue = testRepo.retrieveValueData("count");
		System.out.println("Count from Redis: " + countValue);

		testRepo.storeValueData("email", "darrylng@nus.edu.sg");
		String email = testRepo.retrieveValueData("email");
		System.out.println("Email from Redis: " + email);
	}

}
