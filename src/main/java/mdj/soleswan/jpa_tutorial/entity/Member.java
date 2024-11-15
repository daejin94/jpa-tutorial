package mdj.soleswan.jpa_tutorial.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
public class Member {

    @Id
    private long id;
    // 유니크는 잘 안씀. 유니크 제약조건 이름이 개판이라서
    @Column(name = "name", nullable = false, unique = true, insertable = false, updatable = true, length = 10/*, columnDefinition = "varchar(100) default 'empty"*/)
    private String username;

    @Column(scale = 0)
    private BigDecimal age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creatDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob
    private String description;

    public Member() {

    }
}
