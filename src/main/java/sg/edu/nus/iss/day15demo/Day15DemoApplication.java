package sg.edu.nus.iss.day15demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import sg.edu.nus.iss.day15demo.repo.TestRepo;

import java.util.List;

@SpringBootApplication
public class Day15DemoApplication implements CommandLineRunner {

	@Autowired
	TestRepo testRepo;

	// @Autowired
	// RedisTemplate redisTemplate;

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

		testRepo.addToList("cart", "apple");
		testRepo.addToList("cart", "orange");
		testRepo.addToList("cart", "pear");
		List<String> fruits = testRepo.getList("cart");
		fruits.forEach(System.out::println);


		// ValueOperations vOps = redisTemplate.opsForValue();
		// vOps.set("count", 1000);
		// String countValue = vOps.get("count").toString();

		// System.out.println(countValue);
	}

}
