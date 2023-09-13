package study.webpgm.jpa.domain;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
@Transactional
@Slf4j
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

    @Override
    public void testJpa() {
        log.info("0000000000000");
        Person p1 = new Person("testJpa", "1234", 10);
        em.persist(p1);
        log.info("1111111111111");
        Person p2 = em.find(Person.class, 2);
        log.info("2222222222222");
        Person p3 = em.find(Person.class, 2);
        log.info("3333333333333");
        log.info("p2={}, p3={}", p2, p3);
        p3.setPersonName(p3.getPersonName() + "0");
        log.info("4444444444444");
    }

    @Override
    public void testJpql() {
        String jpql = "select p from Person p ";

        //TypedQuery는 반환 타입이 명확한 경우, Query는 반환 타입이 명확하지 않을떄 사용
        TypedQuery<Person> query1 = em.createQuery("select i from Person i", Person.class);
        Query query2 = em.createQuery("select i.personId, i.personName, i.personAge from Person i");

        List<Person> resultList = query1.getResultList();
        List resultList1 = query2.getResultList();
        //Person 객체가 명확
        for( Person p : resultList ){
            log.info("TypedQuery ID={}, NAME={}, AGE={}", p.getPersonId(), p.getPersonName(), p.getPersonAge());
        }
        log.info("========================================================");

        //객체 타입 부정확, Object[]로 처리
        for (Object o : resultList1) {
            Object[] result = (Object[])o;
            log.info("Query ID={}, NAME={}", result[0], result[1]);
        }
        log.info("========================================================");

        //조건문 파라미터 처리
        Person person = em.createQuery("select i from Person i WHERE i.personId = :personId", Person.class)
                .setParameter("personId", 1L)
                .getSingleResult();
        log.info("Person ID={}, NAME={}", person.getPersonId(), person.getPersonName());
        log.info("========================================================");

        //DTO로 조회
        List<PersonDTO> dtoList = em.createQuery("select new study.webpgm.jpa.domain.PersonDTO(p.personName, p.personAge) from Person p", PersonDTO.class)
                .getResultList();
        PersonDTO personDTO = dtoList.get(0);
        log.info("PersonDTO NAME={}, AGE={}", personDTO.getPersonName(), personDTO.getPersonAge());
        log.info("========================================================");

        //Paging 처리
        List<PersonDTO> dtoList2 = em.createQuery("select new study.webpgm.jpa.domain.PersonDTO(p.personName, p.personAge) from Person p order by p.personId desc", PersonDTO.class)
                .setFirstResult(2)
                .setMaxResults(3)
                .getResultList();

        for( PersonDTO page : dtoList2 ){
            log.info("Paging NAME={}, AGE={}", page.getPersonName(), page.getPersonAge());
        }

    }
}
