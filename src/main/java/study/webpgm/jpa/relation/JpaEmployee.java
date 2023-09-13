package study.webpgm.jpa.relation;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="jpa_employee")
@Getter
@Setter
public class JpaEmployee {

    @Id
    private int jpaEmployeeId;

    private String jpaEmployeeName;

    //private int jpaDepartmentId;

    public JpaEmployee() {
    }

    //2.단방향 매핑 추가
   @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "jpaDepartmentId")
    private JpaDepartment jpaDepartment;
}
