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
            //영속 상태
            Member member = em.find(Member.class, 250L);
            System.out.println("member = " + member.getId());
            System.out.println("member = " + member.getName());
//            member.setName("AAAAA");

//            em.detach(member); //jpa에서 관리 안함
//            em.clear(); // 영속성 컨텍스트 통째로 삭제

//            Member member2 = em.find(Member.class, 250L);

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
