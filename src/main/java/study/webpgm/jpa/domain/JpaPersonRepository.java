package study.webpgm.jpa.domain;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//@Repository
//@Transactional
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
    public Person update(Long personID, Person updatePerson) {
        Person findPerson = em.find(Person.class, personID);
        findPerson.setPersonName(updatePerson.getPersonName());
        findPerson.setPersonTel(updatePerson.getPersonTel());
        findPerson.setPersonAge(updatePerson.getPersonAge());
        return em.find(Person.class, personID);
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

    @Override
    public List<Person> findNameLIke(String personName) {
        String jpql = "select p from Person p ";

        //String queryCondition = personName;
        if( personName != null & personName != ""){
            jpql += " where p.personName like concat('%',:personName,'%')";
        }

        TypedQuery<Person> query = em.createQuery(jpql, Person.class);

        if (personName != null & personName != "") {
            query.setParameter("personName", personName);
        }

        return query.getResultList();
    }
}
