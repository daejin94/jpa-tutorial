package mdj.soleswan.jpa_tutorial;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.List;
import mdj.soleswan.jpa_tutorial.entity.Member;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaTutorialApplication {

    public static void main(String[] args) {

//		SpringApplication.run(JpaTutorialApplication.class, args);

        // db 당 하나. 실행되면 생성 됨.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); // persistence.xml 의 unit name

        // 요청 마다 생성 후 사용 하고 닫기.
        // 절때 쓰레드 간 공유 X

        EntityManager em = emf.createEntityManager(); // 일관적인 단위를 사용할 때 마다 생성해야함.

        EntityTransaction ex = em.getTransaction();

        ex.begin();

        try {

            // 쿼리문을 쓴다고 해도, 객체 대상으로 쿼리 조회를 함.
            List<Member> rs = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(5)
                    .setMaxResults(5)
                    .getResultList();

            for (Member member : rs) {
                System.out.println("member.name = " + member.getName());
            }

            ex.commit();
        } catch (Exception e) {
            ex.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }

}
