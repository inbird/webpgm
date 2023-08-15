package study.webpgm.jpa.domain;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Entity
@Table(name="jpa_person")
@Getter @Setter
public class Person {

    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
    private Long personId;


    @Column(name = "person_name") //필드명과 컬럼명 매핑
    private String personName;
    private String personTel;
    private Integer personAge;

    //기본 생성자 필수
    public Person() {
    }

    public Person(String personName, String personTel, Integer personAge) {
        this.personName = personName;
        this.personTel = personTel;
        this.personAge = personAge;
    }

}
