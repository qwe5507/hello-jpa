package hellojpa;

import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpafirst");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //code
        try {
            Member member = new Member();
            member.setUsername("member1");
            em.persist(member); //이 시점엔 DB에 안들어가 있음.

            //flush -> commit, query날라갈때(CreateQuery[JPQL], CreateNativeQuery[네이티브 쿼리])

            em.flush();

            //결과 0
            //dbconn.executeQuery("select * from member");

//            for (Member member1 : resultList) {
//                System.out.println("member1 = " + member1);
//            }
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();
    }

}
