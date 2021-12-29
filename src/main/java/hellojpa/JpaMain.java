package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpafirst");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //code
        try {
            Member member1 = new Member();
            member1.setUsername("a");
            Member member2 = new Member();
            member2.setUsername("b");
            Member member3 = new Member();
            member3.setUsername("c");

            //call1 -> -49 -> 1
            //call2 -> 1 -> 51 셋팅
            em.persist(member1); // memory : 1 , db : 51
            em.persist(member2); // memory : 2 , db : 51
            em.persist(member3); // memory : 3 , db : 51
            System.out.println("member.getId() = " + member1.getId());

            System.out.println("=========");
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
