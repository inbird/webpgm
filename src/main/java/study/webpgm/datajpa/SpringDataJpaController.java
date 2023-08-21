//package study.webpgm.datajpa;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import study.webpgm.jpa.domain.Person;
//import study.webpgm.jpa.domain.PersonRepository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Controller
//@RequiredArgsConstructor
//public class SpringDataJpaController {
//
//    private final SpringDataJpaPersonRepository springDataJpaPersonRepository;
//
//    @GetMapping("/sdjpa/save")
//    public Person savePerson(String personName, String personTel, int personAge){
//        Person person = new Person(personName, personTel, personAge);
//        return springDataJpaPersonRepository.save(person);
//    }
//
//    @GetMapping("/jpa/update")
//    public Person updatePerson(Long personId, String personName, String personTel, int personAge){
//        Person person = new Person(personName, personTel, personAge);
//        return springDataJpaPersonRepository. .update(personId, person);
//    }
//
//    @GetMapping("/jpa/findById")
//    public Optional<Person> findById(Long personId){
//        return personRepository.findById(personId);
//    }
//
//    @GetMapping("/jpa/findAll")
//    public List<Person> findAll(){
//        return personRepository.findAll();
//    }
//
//    @GetMapping("/jpa/findNameLIke")
//    public List<Person> findNameLIke(String personName){
//        return personRepository.findNameLIke(personName);
//    }
//
//}
