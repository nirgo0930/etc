package termproject.start;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public class Transaction {
    //1번
    public static void createUser(EntityManagerFactory emf,String name, Integer age, String city, String street, String zipCode)
    {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            Users user = new Users();
            user.setName(name);
            user.setAge(age);
            user.setAddress(new Address(city,street,zipCode));
            em.persist(user);
            tx.commit();
        }catch (Exception e) {
            System.out.println("오류 발생");
            tx.rollback();
        } finally {
            em.close();
        }
    }
    //2번
    public static void updateUserAge(EntityManagerFactory emf,Long userId,Integer age)
    {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            Users user = em.find(Users.class,userId);
            user.setAge(age);
            tx.commit();
        }catch (Exception e) {
            System.out.println("오류 발생");
            tx.rollback();
        } finally {
            em.close();
        }
    }
    //3번
    public static void showMovieWithWorkerId(EntityManagerFactory emf, Long movieId){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            Movies movies = em.find(Movies.class, movieId);
            System.out.println("영화명= " + movies.getName());
            System.out.println("장르= " + movies.getGenre());
            System.out.println("개봉일 = " + movies.getOpen_date());
            System.out.println("러닝타임 = " + movies.getRunning_time());
            List<Movie_workers> mw = movies.getMw();
            for(Movie_workers movieWorkers:mw)
            {
                System.out.println("감독/배우명 = " + movieWorkers.getWorkers().getName());
                System.out.println("주연/조연여부 = " + movieWorkers.getRole_type());
            }
            tx.commit();
        }catch (Exception e) {
            System.out.println("오류 발생");
            tx.rollback();
        } finally {
            em.close();
        }
    }
}