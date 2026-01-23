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
//            member.setUserName("hello");
//
//            Team team = new Team();
//            team.setName("team1");
//            em.persist(team);
//            member.setTeam(team);
//
//            em.persist(member);
//            em.flush();
//            em.clear();
//
//            List<Member> members = em.createQuery("select m from Member m join fetch m.team", Member.class)
//                .getResultList();

            Parent parent = new Parent();

            Child child1 = new Child();
            Child child2 = new Child();

            parent.addChild(child1);
            parent.addChild(child2);

            em.persist(parent);

            em.flush();
            em.clear();

            Parent findParent = em.find(Parent.class, parent.getId());

            findParent.getChildList().remove(0);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

    private static void printMember(Member member){
        System.out.println("member: " + member.getUserName());

    }

    private static void printMemberAndTeam(Member member) {
        String username = member.getUserName();
        System.out.println("username: " + username);

        Team team = member.getTeam();
        System.out.println("team: " + team.getName());
    }

}
