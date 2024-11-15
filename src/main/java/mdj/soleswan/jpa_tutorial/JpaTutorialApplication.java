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

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Member member1 = new Member(102L, "jijel");
            Member member2 = new Member(103L, "karina");

            em.persist(member1);
            em.persist(member2);

            System.out.println("=====================================");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();

    }

}
