package study.webpgm.datajpa;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import study.webpgm.jpa.domain.Person;
import study.webpgm.jpa.domain.PersonRepository;

import java.util.List;
import java.util.Optional;

//정상적 실행을 위해서는 PersonRepository 구현체가 2개이상 Bean으로 등록되지 않도록 주석 처리 필요
@RestController
@RequiredArgsConstructor
public class SpringDataJpaController {

   // private final SpringDataJpaPersonRepository springDataJpaPersonRepository;
    private final PersonRepository personRepository;

    @GetMapping("/datajpa/save")
    public Person savePerson(String personName, String personTel, int personAge){
        Person person = new Person(personName, personTel, personAge);
        return personRepository.save(person);
    }

    @GetMapping("/datajpa/update")
    public Person updatePerson(Long personId, String personName, String personTel, int personAge){
        Person person = new Person(personName, personTel, personAge);
        return personRepository.update(personId, person);
    }

    @GetMapping("/datajpa/findById")
    public Optional<Person> findById(Long personId){
        System.out.println("result findById: " + personRepository.findById(personId));

        return personRepository.findById(personId);
    }

    @GetMapping("/datajpa/findAll")
    public List<Person> findAll(){
        System.out.println("result findAll: " + personRepository.findAll());
        return personRepository.findAll();
    }

    @GetMapping("/datajpa/findNameLIke")
    public List<Person> findNameLIke(String personName){
        return personRepository.findNameLIke(personName);
    }

}
