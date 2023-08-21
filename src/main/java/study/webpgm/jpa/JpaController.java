package study.webpgm.jpa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import study.webpgm.jpa.domain.Person;
import study.webpgm.jpa.domain.PersonRepository;

import java.util.List;
import java.util.Optional;


@RestController
public class JpaController {

    private final PersonRepository personRepository;

    public JpaController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/jpa/save")
    public Person savePerson( String personName, String personTel, int personAge){
        Person person = new Person(personName, personTel, personAge);
        return personRepository.save(person);
    }

    @GetMapping("/jpa/update")
    public Person updatePerson(Long personId, String personName, String personTel, int personAge){
        Person person = new Person(personName, personTel, personAge);
        return personRepository.update(personId, person);
    }

    @GetMapping("/jpa/findById")
    public Optional<Person> findById(Long personId){
        return personRepository.findById(personId);
    }

    @GetMapping("/jpa/findAll")
    public List<Person> findAll(){
        return personRepository.findAll();
    }

    @GetMapping("/jpa/findNameLIke")
    public List<Person> findNameLIke(String personName){
        return personRepository.findNameLIke(personName);
    }

}
