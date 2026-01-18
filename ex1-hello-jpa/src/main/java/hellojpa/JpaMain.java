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

//            List<Member> result =  em.createQuery("select m from Member as m", Member.class)
//                .setFirstResult(5)
//                .setMaxResults(8)
//                .getResultList();
//
//            for (Member member: result) {
//                System.out.println("member.name:" + member.getName());
//            }\

            // 비영속
//            Member member = new Member();
//            member.setId(100L);
//            member.setName("HelloJpa");
//
//            //영속
//            System.out.println("==Before==");
//            em.persist(member);
//            System.out.println("==After==");
//
//            Member findMember = em.find(Member.class, 100L);
//            System.out.println("findMember.id=" + findMember.getId());
//            System.out.println("findMember.name=" + findMember.getName());

//            Member findMember1 = em.find(Member.class, 100L);
//            Member findMember2 = em.find(Member.class, 100L);
//
//            System.out.println("result = " + (findMember1 == findMember2));

//            Member memeber1 = new Member(150L, "A");
//            Member memeber2 = new Member(151L, "B");
//
//            em.persist(memeber1);
//            em.persist(memeber2);
//
//            // 여기까지가 데이터베이스에 저장되는게 아니라 영속성 컨텍스트에 차곡차곡 쌓임
//            System.out.println("========");

            // 더티 체크
//            Member member = em.find(Member.class, 150L);
//            member.setName("더티체크");
//
//            // 여기서 em.persist(member)나 이런게 필요없다.

//            Member member = new Member(200L,"flush");
//            em.persist(member);
//            em.flush();

//            Member member = em.find(Member.class, 150L);
//            member.setName("준영속");
//
//            em.detach(member);
//
//            System.out.println("=============");
//            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
