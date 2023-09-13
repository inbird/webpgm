package study.webpgm.datajpa;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import study.webpgm.jpa.domain.Person;
import study.webpgm.jpa.domain.PersonRepository;

import java.util.List;
import java.util.Optional;


//@Transactional
//@Repository
@RequiredArgsConstructor
public class JpaPersonRepositoryV2 implements PersonRepository {

    private final SpringDataJpaPersonRepository springDataJpaPersonRepository;

    @Override
    public Person save(Person person) {
        return springDataJpaPersonRepository.save(person);
    }

    @Override
    public Person update(Long personId, Person updatePerson) {
        Person findPerson = springDataJpaPersonRepository.findById(personId).orElseThrow();
        findPerson.setPersonName(updatePerson.getPersonName());
        findPerson.setPersonTel(updatePerson.getPersonTel());
        findPerson.setPersonAge(updatePerson.getPersonAge());
        return springDataJpaPersonRepository.findById(personId).orElseThrow();
    }

    @Override
    public Optional<Person> findById(Long personId) {
        return springDataJpaPersonRepository.findById(personId);
    }

    @Override
    public List<Person> findAll() {
        return springDataJpaPersonRepository.findAll();
    }

    @Override
    public List<Person> findNameLIke(String personName) {
       return springDataJpaPersonRepository.findByPersonNameLike("%"+personName+"%");
       //return springDataJpaPersonRepository.findPersons("%"+personName+"%" );

    }

    @Override
    public void testJpa() {

    }

    @Override
    public void testJpql() {

    }
}
