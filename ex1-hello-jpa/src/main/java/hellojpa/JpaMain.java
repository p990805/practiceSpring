package hellojpa;

import jakarta.persistence.*;
import java.util.List;


public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        //code
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Member member = new Member();
            member.setUserName("회원1");

            System.out.println("persist 홏출 전 여기서 바로 IDENTITY 면 Insert 날라감");
            em.persist(member);
            System.out.println("member.getId() = " + member.getId());
            System.out.println("persist 호출 후 ");
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
