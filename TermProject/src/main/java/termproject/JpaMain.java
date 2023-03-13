package termproject;

import javax.persistence.*;

import static termproject.Transaction.*;


public class JpaMain {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("termproject");
    public static void main(String[] args) throws Exception {
        EntityManager em = emf.createEntityManager();
        //사전데이터
        //BaseData.addBaseData(emf);
        //1번
        //createUser(emf,"이윤석",24,"대구","서구","12354");
        //2번
        //updateUserAge(emf,3L,28);
        //3번
        //showMovieWithWorkerId(emf,4L);
        //4번
        //Worker director = findWorker(emf, 16L);
        //Worker actor = findWorker(emf, 7L);
        //findMovieWithWorkerOpeningDateRunningTime(emf,director,actor,java.sql.Date.valueOf("2021-09-30"));
        //5번
        //findMoviesAndActors(emf);
        //6번
        //searchScreenInfo(emf,1L);
        //7번
        //Long[] bookSeatsId = {13L, 17L};
        //bookSeat(emf,2L,1L,bookSeatsId);
        //8번
        //unBookSeat(emf,1L,1L);
        //9번
        //printBookInfo(emf,1L);
        //printTicketInfo(emf,1L);
        //10번
        //removeUser(emf,1L);
        emf.close();
    }

}
