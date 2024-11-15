package mdj.soleswan.jpa_tutorial;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import mdj.soleswan.jpa_tutorial.entity.Member;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaTutorialApplication {

    public static void main(String[] args) {

//		SpringApplication.run(JpaTutorialApplication.class, args);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); // persistence.xml 의 unit name
        EntityManager em = emf.createEntityManager(); // 일관적인 단위를 사용할 때 마다 생성해야함.

        EntityTransaction ex = em.getTransaction();

        ex.begin();

        try {

            Member member = new Member();

            member.setId(2L);
            member.setName("helloB");

            em.persist(member);

            ex.commit();
        } catch (Exception e) {
            ex.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }

}
