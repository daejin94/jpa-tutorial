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

            Member member = em.find(Member.class, 103L);
            member.setName("KKK");

//            em.detach(member); // 준영속 상태로 만듬.
            em.clear(); // entityManager 초기화

            Member member2 = em.find(Member.class, 103L);

            System.out.println("=====================================");
            System.out.println(member == member2);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close(); // 종료
        }
        emf.close();

    }

}
