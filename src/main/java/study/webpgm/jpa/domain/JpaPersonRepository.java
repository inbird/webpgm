package study.webpgm.jpa.domain;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Repository
@Transactional
public class JpaPersonRepository implements PersonRepository {
    private final EntityManager em;

    @Autowired
    public JpaPersonRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Person save(Person person) {
        em.persist(person);
        return person;
    }

    @Override
    public void update(Long personID, Person updatePerson) {
        Person findPerson = em.find(Person.class, personID);
        findPerson.setPersonName(updatePerson.getPersonName());
        findPerson.setPersonTel(updatePerson.getPersonTel());
        findPerson.setPersonAge(updatePerson.getPersonAge());
    }

    @Override
    public Optional<Person> findById(Long personId) {
        Person person = em.find(Person.class, personId);
        return Optional.ofNullable(person);
    }

    @Override
    public List<Person> findAll() {
        String jpql = "select p from Person p";
        List<Person> result = em.createQuery(jpql, Person.class)
                .getResultList();
        return result;
    }
}
