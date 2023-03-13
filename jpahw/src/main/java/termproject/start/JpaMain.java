package termproject.start;

import javax.persistence.*;

import static termproject.start.Transaction.*;


public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("termproject");

        BaseData.addBaseData(emf);

        createUser(emf,"한기윤",24,"대구","서구","12354");
        updateUserAge(emf,3L,27);
        showMovieWithWorkerId(emf,4L);

        emf.close();
    }
}
