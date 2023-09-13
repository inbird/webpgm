package study.webpgm.jpa.relation;


import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@Slf4j
public class JpaRelationRepository {

    private final EntityManager em;

    @Autowired
    public JpaRelationRepository(EntityManager em) {
        this.em = em;
    }

    public JpaEmployee save(JpaEmployee jpaEmployee) {
        em.persist(jpaEmployee);
        return jpaEmployee;
    }

    public JpaEmployee findEmployeeById(int jpaEmployeeId) {
        return em.find(JpaEmployee.class, jpaEmployeeId);
    }

    public JpaDepartment findDepartmentById(int jpaDepartmentId) {
        return em.find(JpaDepartment.class, jpaDepartmentId);
    }
}
