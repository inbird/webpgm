package study.webpgm.jpa.relation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import study.webpgm.jpa.domain.PersonRepository;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class JpaRelationController {
    private final JpaRelationRepository jpaRelationRepository;

    public JpaRelationController(JpaRelationRepository jpaRelationRepository) {
        this.jpaRelationRepository = jpaRelationRepository;
    }

/*
    @GetMapping("/jpa/rel/save")
    public JpaEmployee save(){
        JpaEmployee jpaEmployee = new JpaEmployee();

        jpaEmployee.setJpaEmployeeId(11);
        jpaEmployee.setJpaEmployeeName("김십동");
        jpaEmployee.setJpaDepartmentId(2);
        return jpaRelationRepository.save(jpaEmployee);
    }


    @GetMapping("/jpa/rel/find")
    public String find(int id){
        JpaEmployee jpaEmployee = jpaRelationRepository.findEmployeeById(id);
        JpaDepartment jpaDepartment = jpaRelationRepository.findDepartmentById(jpaEmployee.getJpaDepartmentId());
       return  jpaEmployee.getJpaEmployeeId() + "/"
                + jpaEmployee.getJpaEmployeeName() + "/"
                + jpaDepartment.getJpaDepartmentName();

    }
*/


    //2. 단방향 매핑 추가
/*
    @GetMapping("/jpa/rel/save2")
    public JpaEmployee save(){
        JpaEmployee jpaEmployee = new JpaEmployee();
        JpaDepartment jpaDepartment = new JpaDepartment();

        jpaEmployee.setJpaEmployeeId(13);
        jpaEmployee.setJpaEmployeeName("김십삼");

        jpaDepartment.setJpaDepartmentId(1);
        //jpaDepartment.setJpaDepartmentName("웹개발"); //???
        jpaEmployee.setJpaDepartment(jpaDepartment);
        return jpaRelationRepository.save(jpaEmployee);
    }

    @GetMapping("/jpa/rel/find2")
    public String find2(int id){
        JpaEmployee jpaEmployee = jpaRelationRepository.findEmployeeById(id);
        JpaDepartment jpaDepartment = jpaEmployee.getJpaDepartment();
        System.out.println("===============================================");
        return  jpaEmployee.getJpaEmployeeId() + "/"
                + jpaEmployee.getJpaEmployeeName() + "/"
                + jpaDepartment.getJpaDepartmentName();

    }
*/

    //3. 양방향 매핑 추가

    @GetMapping("/jpa/rel/find3")
    public String find3(int id){
        JpaEmployee jpaEmployee = jpaRelationRepository.findEmployeeById(id);
        List<JpaEmployee> jpaEmployeeList = jpaEmployee.getJpaDepartment().getJpaEmployeeList();

        log.info("jpaEmployee : ID={}, NAME={}", jpaEmployee.getJpaEmployeeId(), jpaEmployee.getJpaEmployeeName());
        String result = "";
        System.out.println("=================================");
        for( JpaEmployee employee : jpaEmployeeList ){
            result += employee.getJpaEmployeeId() + "/" + employee.getJpaEmployeeName() + "<br><br>";
        }

        return result;
    }
}
