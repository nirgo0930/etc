//package termproject.start;
//
//import com.querydsl.jpa.impl.JPAQueryFactory;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//
//public class Transection {
//    public void searchScreenInfo(EntityManagerFactory emf, Long screenId) {
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
//        try {
//
//            JPAQueryFactory query = new JPAQueryFactory(em);
//            termproject.start.QScreens qMember = new QMember("m");
//            List<Member> members = query.select(qMember)
//                    .from(qMember)
//                    .where(qMember.username.contains("kim"))
//                    .orderBy(qMember.username.desc())
//                    .fetch();
//            members.stream().forEach(m -> System.out.println("m.getUsername() = " + m.getUsername()));
//
//
//            tx.commit();
//        } catch (
//                Exception e) {
//            e.printStackTrace();
//            tx.rollback();
//        } finally {
//            em.close();
//        }
//    }
//}
