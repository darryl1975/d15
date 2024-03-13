package sg.edu.nus.iss.day15demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import sg.edu.nus.iss.day15demo.model.Person;
import sg.edu.nus.iss.day15demo.repo.PersonRepo;
import sg.edu.nus.iss.day15demo.repo.TestRepo;
import sg.edu.nus.iss.day15demo.service.PersonService;
import sg.edu.nus.iss.day15demo.utils.Util;

import java.util.List;

@SpringBootApplication
public class Day15DemoApplication implements CommandLineRunner {

	// @Autowired
	// TestRepo testRepo;


	@Autowired
	PersonService personService;

	// @Autowired
	// RedisTemplate redisTemplate;

	public static void main(String[] args) {
		SpringApplication.run(Day15DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// testRepo.storeValueData("count", String.valueOf(1000));
		// String countValue = testRepo.retrieveValueData("count");
		// System.out.println("Count from Redis: " + countValue);

		// testRepo.storeValueData("email", "darrylng@nus.edu.sg");
		// String email = testRepo.retrieveValueData("email");
		// System.out.println("Email from Redis: " + email);

		// testRepo.addToList("cart", "apple");
		// testRepo.addToList("cart", "orange");
		// testRepo.addToList("cart", "pear");
		// List<String> fruits = testRepo.getList("cart");
		// fruits.forEach(System.out::println);


		// ValueOperations vOps = redisTemplate.opsForValue();
		// vOps.set("count", 1000);
		// String countValue = vOps.get("count").toString();

		// System.out.println(countValue);

		Person p = new Person(1, "Darryl", 20000);
		personService.addPerson(Util.KEY_PERSON, p);
		p = new Person(2, "Farm", 25000);
		personService.addPerson(Util.KEY_PERSON, p);
		p = new Person(3, "Felicia", 30000);
		personService.addPerson(Util.KEY_PERSON, p);

		List<Person> persons = personService.getPersonList(Util.KEY_PERSON);

		for(Person per: persons) {
			System.out.println("Record :" + per.toString());
		}

	}

}
