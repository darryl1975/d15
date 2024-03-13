package sg.edu.nus.iss.day15demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.day15demo.model.Person;
import sg.edu.nus.iss.day15demo.repo.PersonRepo;

@Service
public class PersonService {
    
    @Autowired
    PersonRepo personRepo;

    public void addPerson(String key, Person person) {
        personRepo.addToList(key, person.toString());
    }

    public List<Person> getPersonList(String key) {
        
        List<String> rawList = personRepo.getList(key);

        List<Person> persons = new ArrayList<>();

        for(String raw: rawList) {
            String [] record = raw.split(",");
            Person p = new Person();
            p.setId(Integer.parseInt(record[0]));
            p.setFullname(record[1]);
            p.setSalary(Integer.parseInt(record[2]));
            persons.add(p);
        }

        return persons;
    }
}
