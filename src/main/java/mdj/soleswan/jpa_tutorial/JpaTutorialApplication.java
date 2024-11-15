package mdj.soleswan.jpa_tutorial;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import mdj.soleswan.jpa_tutorial.entity.Member;
import mdj.soleswan.jpa_tutorial.entity.RoleType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaTutorialApplication {

    public static void main(String[] args) {

//		SpringApplication.run(JpaTutorialApplication.class, args);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Member member = new Member();
            member.setId(3);
            member.setRoleType(RoleType.ADMIN);
            member.setUsername("ddd");

            em.persist(member);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {

            em.close();
        }

        emf.close();

    }

}
