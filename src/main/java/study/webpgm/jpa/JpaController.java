package study.webpgm.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import study.webpgm.jpa.domain.Person;
import study.webpgm.jpa.domain.PersonRepository;



@RestController
public class JpaController {

    private final PersonRepository personRepository;

    public JpaController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/jpa/save")
    public Person getUser(){
        Person person = new Person("홍길동", "02-123-1234", 30);
        Person savePerson = personRepository.save(person);
        return savePerson ;
    }


}
