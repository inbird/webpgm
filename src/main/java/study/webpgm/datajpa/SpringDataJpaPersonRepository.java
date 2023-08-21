package study.webpgm.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import study.webpgm.jpa.domain.Person;

import java.util.List;

public interface SpringDataJpaPersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByPersonNameLike(String personName);

    @Query("select p from Person p where p.personName like :personName")
            List<Person> findPersons(@Param("personName") String personName );

}
