package mdj.soleswan.jpa_tutorial.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    private String name;

    public Member() {

    }
}
