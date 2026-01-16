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
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("테스트2");
//            em.persist(member);

//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.name = " + findMember.getName());

//            Member findMember = em.find(Member.class, 1L);
//            em.remove(findMember)

//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("수정 이름");

            List<Member> result =  em.createQuery("select m from Member as m", Member.class)
                .setFirstResult(5)
                .setMaxResults(8)
                .getResultList();

            for (Member member: result) {
                System.out.println("member.name:" + member.getName());
            }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
