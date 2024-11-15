package mdj.soleswan.jpa_tutorial.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member {

    @Id //primary key
    private long id;
    private String name;
}
