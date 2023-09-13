package study.webpgm.jpa.relation;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="jpa_department")
@Getter
@Setter
public class JpaDepartment {
    @Id
    private int JpaDepartmentId;
    private String JpaDepartmentName;

    //3.양방향 매핑추가
    @OneToMany(mappedBy = "jpaDepartment", fetch = FetchType.LAZY)
    private List<JpaEmployee> jpaEmployeeList = new ArrayList<>();
}
