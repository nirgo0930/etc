package termproject.start;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BaseData {
    public static void addBaseData(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //1 movie
            List<Movies> moviesList = new ArrayList<>();
            {
                moviesList.add(new Movies("공포영화1", java.sql.Date.valueOf(LocalDate.of(2021, 11, 11)), Genre.HORROR, 120));
                moviesList.add(new Movies("공포영화2", java.sql.Date.valueOf(LocalDate.of(2021, 10, 24)), Genre.HORROR, 90));
                moviesList.add(new Movies("코미디영화1", java.sql.Date.valueOf(LocalDate.of(2021, 11, 21)), Genre.COMEDY, 100));
                moviesList.add(new Movies("액션영화1", java.sql.Date.valueOf(LocalDate.of(2021, 9, 30)), Genre.ACTION, 80));

                for (Movies item : moviesList) {
                    em.persist(item);
                }
            }
            //2 worker
            List<Workers> workersList = new ArrayList<>();
            {
                workersList.add(new Actors("배우1", java.sql.Date.valueOf(LocalDate.of(1998, 9, 30)), 178, "insta1"));
                workersList.add(new Actors("배우2", java.sql.Date.valueOf(LocalDate.of(1970, 10, 21)), 182, "insta2"));
                workersList.add(new Actors("배우3", java.sql.Date.valueOf(LocalDate.of(1965, 8, 1)), 165, "insta3"));
                workersList.add(new Actors("배우4", java.sql.Date.valueOf(LocalDate.of(1977, 9, 30)), 170, "insta4"));
                workersList.add(new Actors("배우5", java.sql.Date.valueOf(LocalDate.of(1988, 3, 25)), 173, "insta5"));
                workersList.add(new Actors("배우6", java.sql.Date.valueOf(LocalDate.of(2000, 1, 30)), 171, "insta6"));
                workersList.add(new Actors("배우7", java.sql.Date.valueOf(LocalDate.of(2003, 7, 1)), 160, "insta7"));
                workersList.add(new Actors("배우8", java.sql.Date.valueOf(LocalDate.of(1960, 5, 5)), 170, "insta8"));
                workersList.add(new Actors("배우9", java.sql.Date.valueOf(LocalDate.of(1978, 6, 3)), 174, "insta9"));
                workersList.add(new Actors("배우10", java.sql.Date.valueOf(LocalDate.of(1978, 6, 3)), 164, "insta10"));
                workersList.add(new Actors("배우11", java.sql.Date.valueOf(LocalDate.of(1970, 4, 7)), 169, "insta11"));
                workersList.add(new Actors("배우12", java.sql.Date.valueOf(LocalDate.of(1960, 8, 19)), 179, "insta12"));

                workersList.add(new Directors("감독1", java.sql.Date.valueOf(LocalDate.of(1970, 4, 24)), "대구"));
                workersList.add(new Directors("감독2", java.sql.Date.valueOf(LocalDate.of(1980, 7, 2)), "서울"));
                workersList.add(new Directors("감독3", java.sql.Date.valueOf(LocalDate.of(1976, 9, 13)), "뉴욕"));
                workersList.add(new Directors("감독4", java.sql.Date.valueOf(LocalDate.of(1966, 2, 25)), "부산"));

                for (Workers item : workersList) {
                    em.persist(item);
                }
            }
            //3 movie_worker
            List<Movie_workers> movie_workersList = new ArrayList<>();
            {
                movie_workersList.add(newMW(workersList, moviesList, RoleType.Director, "감독1", "공포영화1"));
                movie_workersList.add(newMW(workersList, moviesList, RoleType.Director, "감독2", "공포영화2"));
                movie_workersList.add(newMW(workersList, moviesList, RoleType.Director, "감독3", "코미디영화1"));
                movie_workersList.add(newMW(workersList, moviesList, RoleType.Director, "감독4", "액션영화1"));

                movie_workersList.add(newMW(workersList, moviesList, RoleType.MainCharacter, "배우1", "공포영화1"));
                movie_workersList.add(newMW(workersList, moviesList, RoleType.MainCharacter, "배우2", "공포영화1"));
                movie_workersList.add(newMW(workersList, moviesList, RoleType.SubCharacter, "배우3", "공포영화1"));
                movie_workersList.add(newMW(workersList, moviesList, RoleType.SubCharacter, "배우4", "공포영화1"));
                movie_workersList.add(newMW(workersList, moviesList, RoleType.SubCharacter, "배우5", "공포영화1"));

                movie_workersList.add(newMW(workersList, moviesList, RoleType.MainCharacter, "배우3", "공포영화2"));
                movie_workersList.add(newMW(workersList, moviesList, RoleType.MainCharacter, "배우4", "공포영화2"));
                movie_workersList.add(newMW(workersList, moviesList, RoleType.SubCharacter, "배우8", "공포영화2"));
                movie_workersList.add(newMW(workersList, moviesList, RoleType.SubCharacter, "배우9", "공포영화2"));
                movie_workersList.add(newMW(workersList, moviesList, RoleType.SubCharacter, "배우10", "공포영화2"));

                movie_workersList.add(newMW(workersList, moviesList, RoleType.MainCharacter, "배우5", "코미디영화1"));
                movie_workersList.add(newMW(workersList, moviesList, RoleType.MainCharacter, "배우6", "코미디영화1"));
                movie_workersList.add(newMW(workersList, moviesList, RoleType.SubCharacter, "배우9", "코미디영화1"));
                movie_workersList.add(newMW(workersList, moviesList, RoleType.SubCharacter, "배우10", "코미디영화1"));
                movie_workersList.add(newMW(workersList, moviesList, RoleType.SubCharacter, "배우11", "코미디영화1"));

                movie_workersList.add(newMW(workersList, moviesList, RoleType.MainCharacter, "배우7", "액션영화1"));
                movie_workersList.add(newMW(workersList, moviesList, RoleType.MainCharacter, "배우8", "액션영화1"));
                movie_workersList.add(newMW(workersList, moviesList, RoleType.SubCharacter, "배우12", "액션영화1"));
                movie_workersList.add(newMW(workersList, moviesList, RoleType.SubCharacter, "배우1", "액션영화1"));
                movie_workersList.add(newMW(workersList, moviesList, RoleType.SubCharacter, "배우2", "액션영화1"));

                for (Movie_workers item : movie_workersList) {
                    em.persist(item);
                }
            }
            //4 theater
            List<Theaters> theatersList = new ArrayList<>();
            {
                theatersList.add(new Theaters("1상영관", 1));
                theatersList.add(new Theaters("2상영관", 2));

                for (Theaters item : theatersList) {
                    em.persist(item);
                }
            }
            //5 screen
            List<Screens> screensList = new ArrayList<>();
            {
                screensList.add(newScreen(theatersList, moviesList, (LocalDateTime.of(2021, 12, 10, 6, 0)), "1상영관", "공포영화2"));
                screensList.add(newScreen(theatersList, moviesList, (LocalDateTime.of(2021, 12, 10, 14, 30)), "1상영관", "공포영화1"));
                screensList.add(newScreen(theatersList, moviesList, (LocalDateTime.of(2021, 12, 10, 23, 30)), "1상영관", "코미디영화1"));

                screensList.add(newScreen(theatersList, moviesList, (LocalDateTime.of(2021, 12, 11, 8, 0)), "1상영관", "공포영화2"));
                screensList.add(newScreen(theatersList, moviesList, (LocalDateTime.of(2021, 12, 11, 17, 0)), "1상영관", "공포영화1"));
                screensList.add(newScreen(theatersList, moviesList, (LocalDateTime.of(2021, 12, 12, 1, 30)), "1상영관", "액션영화1"));

                screensList.add(newScreen(theatersList, moviesList, (LocalDateTime.of(2021, 12, 12, 10, 0)), "1상영관", "공포영화2"));
                screensList.add(newScreen(theatersList, moviesList, (LocalDateTime.of(2021, 12, 12, 19, 30)), "1상영관", "코미디영화1"));
                screensList.add(newScreen(theatersList, moviesList, (LocalDateTime.of(2021, 12, 13, 3, 0)), "1상영관", "액션영화1"));

                screensList.add(newScreen(theatersList, moviesList, (LocalDateTime.of(2021, 12, 13, 12, 0)), "1상영관", "공포영화1"));
                screensList.add(newScreen(theatersList, moviesList, (LocalDateTime.of(2021, 12, 13, 21, 30)), "1상영관", "코미디영화1"));
                screensList.add(newScreen(theatersList, moviesList, (LocalDateTime.of(2021, 12, 14, 4, 30)), "1상영관", "액션영화1"));


                screensList.add(newScreen(theatersList, moviesList, (LocalDateTime.of(2021, 12, 10, 6, 0)), "2상영관", "코미디영화1"));
                screensList.add(newScreen(theatersList, moviesList, (LocalDateTime.of(2021, 12, 10, 14, 0)), "2상영관", "액션영화1"));
                screensList.add(newScreen(theatersList, moviesList, (LocalDateTime.of(2021, 12, 10, 21, 0)), "2상영관", "공포영화2"));

                screensList.add(newScreen(theatersList, moviesList, (LocalDateTime.of(2021, 12, 11, 8, 0)), "2상영관", "코미디영화1"));
                screensList.add(newScreen(theatersList, moviesList, (LocalDateTime.of(2021, 12, 11, 15, 30)), "2상영관", "액션영화1"));
                screensList.add(newScreen(theatersList, moviesList, (LocalDateTime.of(2021, 12, 11, 23, 0)), "2상영관", "공포영화1"));

                screensList.add(newScreen(theatersList, moviesList, (LocalDateTime.of(2021, 12, 12, 10, 0)), "2상영관", "코미디영화1"));
                screensList.add(newScreen(theatersList, moviesList, (LocalDateTime.of(2021, 12, 12, 17, 0)), "2상영관", "공포영화2"));
                screensList.add(newScreen(theatersList, moviesList, (LocalDateTime.of(2021, 12, 13, 1, 30)), "2상영관", "공포영화1"));

                screensList.add(newScreen(theatersList, moviesList, (LocalDateTime.of(2021, 12, 13, 12, 30)), "2상영관", "액션영화1"));
                screensList.add(newScreen(theatersList, moviesList, (LocalDateTime.of(2021, 12, 13, 19, 0)), "2상영관", "공포영화2"));
                screensList.add(newScreen(theatersList, moviesList, (LocalDateTime.of(2021, 12, 14, 4, 0)), "2상영관", "공포영화1"));


                for (Screens item : screensList) {
                    em.persist(item);
                }
            }
            //6 user
            List<Users> usersList = new ArrayList<>();
            {
                usersList.add(new Users("테스터1", 22, "경상북도 구미시", "대학로", "61"));
                usersList.add(new Users("테스터2", 23, "경상북도 구미시", "구미대로", "350-27"));

                for (Users item : usersList) {
                    em.persist(item);
                }
            }
            //7 ticket
            List<Tickets> ticketsList = new ArrayList<>();
            {
                ticketsList.add(newTicket(usersList, screensList, "테스터1", (LocalDateTime.of(2021, 12, 10, 6, 0))));
                ticketsList.add(newTicket(usersList, screensList, "테스터2", (LocalDateTime.of(2021, 12, 10, 6, 0))));

                for (Tickets item : ticketsList) {
                    em.persist(item);
                }
            }
            //8 seat
            List<Seats> seatsList = new ArrayList<>();
            {
                for (int i = 1; i < 6; i++) {
                    seatsList.add(newSeat(theatersList, "A", i, Status.UNBOOKED, "1상영관"));
                    seatsList.add(newSeat(theatersList, "B", i, Status.UNBOOKED, "1상영관"));

                    seatsList.add(newSeat(theatersList, "A", i, Status.UNBOOKED, "2상영관"));
                    seatsList.add(newSeat(theatersList, "B", i, Status.UNBOOKED, "2상영관"));
                }
                for (Seats item : seatsList) {
                    em.persist(item);
                }
            }
            //9 ticket_seat
            List<Ticket_seats> ticket_seatsList = new ArrayList<>();
            {
                ticket_seatsList.add(newTS(seatsList, ticketsList, "A", 1, "테스터1", "1상영관", (LocalDateTime.of(2021, 12, 10, 6, 0))));
                ticket_seatsList.add(newTS(seatsList, ticketsList, "A", 2, "테스터1", "1상영관", (LocalDateTime.of(2021, 12, 10, 6, 0))));

                ticket_seatsList.add(newTS(seatsList, ticketsList, "B", 4, "테스터2", "1상영관", (LocalDateTime.of(2021, 12, 10, 6, 0))));
                ticket_seatsList.add(newTS(seatsList, ticketsList, "B", 5, "테스터2", "1상영관", (LocalDateTime.of(2021, 12, 10, 6, 0))));

                for (Ticket_seats item : ticket_seatsList) {
                    em.persist(item);
                }
            }

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
    }

    public static Movie_workers newMW(List<Workers> workersList, List<Movies> moviesList, RoleType r, String w, String m) {
        Movie_workers result = new Movie_workers(
                r, workersList.stream().filter(workers -> workers.getName().equals(w)).findFirst().orElseThrow(() -> new IllegalArgumentException()),
                moviesList.stream().filter(movies -> movies.getName().equals(m)).findFirst().orElseThrow(() -> new IllegalArgumentException()));
        return result;
    }

    public static Screens newScreen(List<Theaters> theatersList, List<Movies> moviesList, LocalDateTime sTime, String t, String m) {
        Movies mov = moviesList.stream().filter(movies -> movies.getName().equals(m)).findFirst().orElseThrow(() -> new IllegalArgumentException());
        Screens result = new Screens(
                java.sql.Timestamp.valueOf(sTime), java.sql.Timestamp.valueOf(sTime.plusMinutes(mov.getRunning_time())),
                theatersList.stream().filter(theaters -> theaters.getName().equals(t)).findFirst().orElseThrow(() -> new IllegalArgumentException()), mov);
        return result;
    }

    public static Tickets newTicket(List<Users> usersList, List<Screens> screensList, String u, LocalDateTime sTime) {
        Tickets result = new Tickets(
                usersList.stream().filter(users -> users.getName().equals(u)).findFirst().orElseThrow(() -> new IllegalArgumentException()),
                screensList.stream().filter(screens -> screens.getStart_time().equals(java.sql.Timestamp.valueOf(sTime))).findFirst().orElseThrow(() -> new IllegalArgumentException()));
        return result;
    }

    public static Seats newSeat(List<Theaters> theatersList, String r, int c, Status s, String t) {
        Seats result = new Seats(r, c, s, theatersList.stream().filter(theaters -> theaters.getName().equals(t)).findFirst().orElseThrow(() -> new IllegalArgumentException()));
        return result;
    }

    public static Ticket_seats newTS(List<Seats> seatsList, List<Tickets> ticketsList, String r, int c, String u, String tn, LocalDateTime t) {
        Ticket_seats result = new Ticket_seats(
                seatsList.stream().filter(seats -> seats.getRow().equals(r)).filter(seats -> seats.getColumn() == c).findFirst().orElseThrow(() -> new IllegalArgumentException()),
                ticketsList.stream().filter(tickets -> tickets.getUsers().getName().equals(u))
                        .filter(tickets -> tickets.getScreens().getTheaters().getName().equals(tn))
                        .filter(tickets -> tickets.getScreens().getStart_time().equals(java.sql.Timestamp.valueOf(t)))
                        .findFirst().orElseThrow(() -> new IllegalArgumentException()));
        return result;
    }

}
