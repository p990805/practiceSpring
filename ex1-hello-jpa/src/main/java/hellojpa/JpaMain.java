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
            Member member  = new Member();
            member.setUserName("hello");
            member.setHomeAddress(new Address("homeCity", "state", "country"));

            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("족발");
            member.getFavoriteFoods().add("피자");

            member.getAddressHistory().add(new Address("old1", "state", "country"));
            member.getAddressHistory().add(new Address("old2", "state", "country"));

            em.persist(member);

            em.flush();
            em.clear();

            System.out.println("===========");
            Member findMember = em.find(Member.class, member.getId());

//            findMember.getHomeAddress().setCity("newCity");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

//    private static void printMember(Member member){
//        System.out.println("member: " + member.getUserName());
//
//    }
//
//    private static void printMemberAndTeam(Member member) {
//        String username = member.getUserName();
//        System.out.println("username: " + username);
//
//        Team team = member.getTeam();
//        System.out.println("team: " + team.getName());
//    }

}
