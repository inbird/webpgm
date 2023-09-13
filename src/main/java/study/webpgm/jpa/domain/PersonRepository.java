package study.webpgm.jpa.domain;

import java.util.List;
import java.util.Optional;

public interface PersonRepository {
    Person save(Person person);

    Person update(Long personId, Person updatePerson);

    Optional<Person> findById(Long id);

    List<Person> findAll();

    List<Person> findNameLIke(String personName);

    void testJpa();

    void testJpql();

}
