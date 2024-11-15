package mdj.soleswan.jpa_tutorial;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import mdj.soleswan.jpa_tutorial.entity.Member;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaTutorialApplication {

    public static void main(String[] args) {

//		SpringApplication.run(JpaTutorialApplication.class, args);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); // persistence.xml 의 unit name
        EntityManager em = emf.createEntityManager(); // 일관적인 단위를 사용할 때 마다 생성해야함.

        Member member = new Member();

        member.setId(1L);
        member.setName("hello");

        em.persist(member);

        //code

        em.close();
        emf.close();

    }

}
