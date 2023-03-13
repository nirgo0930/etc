package termproject;

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
            List<Movie> movieList = new ArrayList<>();
            {
                movieList.add(new Movie("공포영화1", java.sql.Date.valueOf(LocalDate.of(2021, 11, 11)), Genre.HORROR, 120));
                movieList.add(new Movie("공포영화2", java.sql.Date.valueOf(LocalDate.of(2021, 10, 24)), Genre.HORROR, 90));
                movieList.add(new Movie("코미디영화1", java.sql.Date.valueOf(LocalDate.of(2021, 11, 21)), Genre.COMEDY, 100));
                movieList.add(new Movie("액션영화1", java.sql.Date.valueOf(LocalDate.of(2021, 9, 30)), Genre.ACTION, 80));

                for (Movie item : movieList) {
                    em.persist(item);
                }
            }
            //2 worker
            List<Worker> workerList = new ArrayList<>();
            {
                workerList.add(new Actor("배우1", java.sql.Date.valueOf(LocalDate.of(1998, 9, 30)), 178, "insta1"));
                workerList.add(new Actor("배우2", java.sql.Date.valueOf(LocalDate.of(1970, 10, 21)), 182, "insta2"));
                workerList.add(new Actor("배우3", java.sql.Date.valueOf(LocalDate.of(1965, 8, 1)), 165, "insta3"));
                workerList.add(new Actor("배우4", java.sql.Date.valueOf(LocalDate.of(1977, 9, 30)), 170, "insta4"));
                workerList.add(new Actor("배우5", java.sql.Date.valueOf(LocalDate.of(1988, 3, 25)), 173, "insta5"));
                workerList.add(new Actor("배우6", java.sql.Date.valueOf(LocalDate.of(2000, 1, 30)), 171, "insta6"));
                workerList.add(new Actor("배우7", java.sql.Date.valueOf(LocalDate.of(2003, 7, 1)), 160, "insta7"));
                workerList.add(new Actor("배우8", java.sql.Date.valueOf(LocalDate.of(1960, 5, 5)), 170, "insta8"));
                workerList.add(new Actor("배우9", java.sql.Date.valueOf(LocalDate.of(1978, 6, 3)), 174, "insta9"));
                workerList.add(new Actor("배우10", java.sql.Date.valueOf(LocalDate.of(1978, 6, 3)), 164, "insta10"));
                workerList.add(new Actor("배우11", java.sql.Date.valueOf(LocalDate.of(1970, 4, 7)), 169, "insta11"));
                workerList.add(new Actor("배우12", java.sql.Date.valueOf(LocalDate.of(1960, 8, 19)), 179, "insta12"));

                workerList.add(new Director("감독1", java.sql.Date.valueOf(LocalDate.of(1970, 4, 24)), "대구"));
                workerList.add(new Director("감독2", java.sql.Date.valueOf(LocalDate.of(1980, 7, 2)), "서울"));
                workerList.add(new Director("감독3", java.sql.Date.valueOf(LocalDate.of(1976, 9, 13)), "뉴욕"));
                workerList.add(new Director("감독4", java.sql.Date.valueOf(LocalDate.of(1966, 2, 25)), "부산"));

                for (Worker item : workerList) {
                    em.persist(item);
                }
            }
            //3 movie_worker
            List<MovieWorker> movie_workersList = new ArrayList<>();
            {
                movie_workersList.add(newMW(workerList, movieList, RoleType.Director, "감독1", "공포영화1"));
                movie_workersList.add(newMW(workerList, movieList, RoleType.Director, "감독2", "공포영화2"));
                movie_workersList.add(newMW(workerList, movieList, RoleType.Director, "감독3", "코미디영화1"));
                movie_workersList.add(newMW(workerList, movieList, RoleType.Director, "감독4", "액션영화1"));

                movie_workersList.add(newMW(workerList, movieList, RoleType.MainCharacter, "배우1", "공포영화1"));
                movie_workersList.add(newMW(workerList, movieList, RoleType.MainCharacter, "배우2", "공포영화1"));
                movie_workersList.add(newMW(workerList, movieList, RoleType.SubCharacter, "배우3", "공포영화1"));
                movie_workersList.add(newMW(workerList, movieList, RoleType.SubCharacter, "배우4", "공포영화1"));
                movie_workersList.add(newMW(workerList, movieList, RoleType.SubCharacter, "배우5", "공포영화1"));

                movie_workersList.add(newMW(workerList, movieList, RoleType.MainCharacter, "배우3", "공포영화2"));
                movie_workersList.add(newMW(workerList, movieList, RoleType.MainCharacter, "배우4", "공포영화2"));
                movie_workersList.add(newMW(workerList, movieList, RoleType.SubCharacter, "배우8", "공포영화2"));
                movie_workersList.add(newMW(workerList, movieList, RoleType.SubCharacter, "배우9", "공포영화2"));
                movie_workersList.add(newMW(workerList, movieList, RoleType.SubCharacter, "배우10", "공포영화2"));

                movie_workersList.add(newMW(workerList, movieList, RoleType.MainCharacter, "배우5", "코미디영화1"));
                movie_workersList.add(newMW(workerList, movieList, RoleType.MainCharacter, "배우6", "코미디영화1"));
                movie_workersList.add(newMW(workerList, movieList, RoleType.SubCharacter, "배우9", "코미디영화1"));
                movie_workersList.add(newMW(workerList, movieList, RoleType.SubCharacter, "배우10", "코미디영화1"));
                movie_workersList.add(newMW(workerList, movieList, RoleType.SubCharacter, "배우11", "코미디영화1"));

                movie_workersList.add(newMW(workerList, movieList, RoleType.MainCharacter, "배우7", "액션영화1"));
                movie_workersList.add(newMW(workerList, movieList, RoleType.MainCharacter, "배우8", "액션영화1"));
                movie_workersList.add(newMW(workerList, movieList, RoleType.SubCharacter, "배우12", "액션영화1"));
                movie_workersList.add(newMW(workerList, movieList, RoleType.SubCharacter, "배우1", "액션영화1"));
                movie_workersList.add(newMW(workerList, movieList, RoleType.SubCharacter, "배우2", "액션영화1"));

                for (MovieWorker item : movie_workersList) {
                    em.persist(item);
                }
            }
            //4 theater
            List<Theater> theaterList = new ArrayList<>();
            {
                theaterList.add(new Theater("1상영관", 1));
                theaterList.add(new Theater("2상영관", 2));

                for (Theater item : theaterList) {
                    em.persist(item);
                }
            }
            //5 screen
            List<Screen> screenList = new ArrayList<>();
            {
                screenList.add(newScreen(theaterList, movieList, (LocalDateTime.of(2021, 12, 10, 6, 0)), "1상영관", "공포영화2"));
                screenList.add(newScreen(theaterList, movieList, (LocalDateTime.of(2021, 12, 10, 14, 30)), "1상영관", "공포영화1"));
                screenList.add(newScreen(theaterList, movieList, (LocalDateTime.of(2021, 12, 10, 23, 30)), "1상영관", "코미디영화1"));

                screenList.add(newScreen(theaterList, movieList, (LocalDateTime.of(2021, 12, 11, 8, 0)), "1상영관", "공포영화2"));
                screenList.add(newScreen(theaterList, movieList, (LocalDateTime.of(2021, 12, 11, 17, 0)), "1상영관", "공포영화1"));
                screenList.add(newScreen(theaterList, movieList, (LocalDateTime.of(2021, 12, 12, 1, 30)), "1상영관", "액션영화1"));

                screenList.add(newScreen(theaterList, movieList, (LocalDateTime.of(2021, 12, 12, 10, 0)), "1상영관", "공포영화2"));
                screenList.add(newScreen(theaterList, movieList, (LocalDateTime.of(2021, 12, 12, 19, 30)), "1상영관", "코미디영화1"));
                screenList.add(newScreen(theaterList, movieList, (LocalDateTime.of(2021, 12, 13, 3, 0)), "1상영관", "액션영화1"));

                screenList.add(newScreen(theaterList, movieList, (LocalDateTime.of(2021, 12, 13, 12, 0)), "1상영관", "공포영화1"));
                screenList.add(newScreen(theaterList, movieList, (LocalDateTime.of(2021, 12, 13, 21, 30)), "1상영관", "코미디영화1"));
                screenList.add(newScreen(theaterList, movieList, (LocalDateTime.of(2021, 12, 14, 4, 30)), "1상영관", "액션영화1"));


                screenList.add(newScreen(theaterList, movieList, (LocalDateTime.of(2021, 12, 10, 6, 0)), "2상영관", "코미디영화1"));
                screenList.add(newScreen(theaterList, movieList, (LocalDateTime.of(2021, 12, 10, 14, 0)), "2상영관", "액션영화1"));
                screenList.add(newScreen(theaterList, movieList, (LocalDateTime.of(2021, 12, 10, 21, 0)), "2상영관", "공포영화2"));

                screenList.add(newScreen(theaterList, movieList, (LocalDateTime.of(2021, 12, 11, 8, 0)), "2상영관", "코미디영화1"));
                screenList.add(newScreen(theaterList, movieList, (LocalDateTime.of(2021, 12, 11, 15, 30)), "2상영관", "액션영화1"));
                screenList.add(newScreen(theaterList, movieList, (LocalDateTime.of(2021, 12, 11, 23, 0)), "2상영관", "공포영화1"));

                screenList.add(newScreen(theaterList, movieList, (LocalDateTime.of(2021, 12, 12, 10, 0)), "2상영관", "코미디영화1"));
                screenList.add(newScreen(theaterList, movieList, (LocalDateTime.of(2021, 12, 12, 17, 0)), "2상영관", "공포영화2"));
                screenList.add(newScreen(theaterList, movieList, (LocalDateTime.of(2021, 12, 13, 1, 30)), "2상영관", "공포영화1"));

                screenList.add(newScreen(theaterList, movieList, (LocalDateTime.of(2021, 12, 13, 12, 30)), "2상영관", "액션영화1"));
                screenList.add(newScreen(theaterList, movieList, (LocalDateTime.of(2021, 12, 13, 19, 0)), "2상영관", "공포영화2"));
                screenList.add(newScreen(theaterList, movieList, (LocalDateTime.of(2021, 12, 14, 4, 0)), "2상영관", "공포영화1"));


                for (Screen item : screenList) {
                    em.persist(item);
                }
            }
            //6 user
            List<User> userList = new ArrayList<>();
            {
                userList.add(new User("테스터1", 22, "경상북도 구미시", "대학로", "61"));
                userList.add(new User("테스터2", 23, "경상북도 구미시", "구미대로", "350-27"));

                for (User item : userList) {
                    em.persist(item);
                }
            }
            //7 ticket
            List<Ticket> ticketList = new ArrayList<>();
            {
                ticketList.add(newTicket(userList, screenList, "테스터1", (LocalDateTime.of(2021, 12, 10, 6, 0))));
                ticketList.add(newTicket(userList, screenList, "테스터2", (LocalDateTime.of(2021, 12, 10, 6, 0))));

                for (Ticket item : ticketList) {
                    em.persist(item);
                }
            }
            //8 seat
            List<Seat> seatList = new ArrayList<>();
            {
                for (int i = 1; i < 6; i++) {
                    seatList.add(newSeat(theaterList, "A", i, Status.USABLE, "1상영관"));
                    seatList.add(newSeat(theaterList, "B", i, Status.USABLE, "1상영관"));

                    seatList.add(newSeat(theaterList, "A", i, Status.USABLE, "2상영관"));
                    seatList.add(newSeat(theaterList, "B", i, Status.USABLE, "2상영관"));
                }
                for (Seat item : seatList) {
                    em.persist(item);
                }
            }
            //9 ticket_seat
            List<TicketSeat> ticket_seatsList = new ArrayList<>();
            {
                ticket_seatsList.add(newTS(seatList, ticketList, "A", 1, "테스터1", "1상영관", (LocalDateTime.of(2021, 12, 10, 6, 0))));
                ticket_seatsList.add(newTS(seatList, ticketList, "A", 2, "테스터1", "1상영관", (LocalDateTime.of(2021, 12, 10, 6, 0))));

                ticket_seatsList.add(newTS(seatList, ticketList, "B", 4, "테스터2", "1상영관", (LocalDateTime.of(2021, 12, 10, 6, 0))));
                ticket_seatsList.add(newTS(seatList, ticketList, "B", 5, "테스터2", "1상영관", (LocalDateTime.of(2021, 12, 10, 6, 0))));

                for (TicketSeat item : ticket_seatsList) {
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

    public static MovieWorker newMW(List<Worker> workerList, List<Movie> movieList, RoleType r, String w, String m) {
        MovieWorker result = new MovieWorker(
                r, workerList.stream().filter(workers -> workers.getName().equals(w)).findFirst().orElseThrow(() -> new IllegalArgumentException()),
                movieList.stream().filter(movies -> movies.getName().equals(m)).findFirst().orElseThrow(() -> new IllegalArgumentException()));
        return result;
    }

    public static Screen newScreen(List<Theater> theaterList, List<Movie> movieList, LocalDateTime sTime, String t, String m) {
        Movie mov = movieList.stream().filter(movies -> movies.getName().equals(m)).findFirst().orElseThrow(() -> new IllegalArgumentException());
        Screen result = new Screen(
                java.sql.Timestamp.valueOf(sTime), java.sql.Timestamp.valueOf(sTime.plusMinutes(mov.getRunningTime())),
                theaterList.stream().filter(theater -> theater.getName().equals(t)).findFirst().orElseThrow(() -> new IllegalArgumentException()), mov);
        return result;
    }

    public static Ticket newTicket(List<User> userList, List<Screen> screenList, String u, LocalDateTime sTime) {
        Ticket result = new Ticket(
                userList.stream().filter(user -> user.getName().equals(u)).findFirst().orElseThrow(() -> new IllegalArgumentException()),
                screenList.stream().filter(screen -> screen.getStartTime().equals(java.sql.Timestamp.valueOf(sTime))).findFirst().orElseThrow(() -> new IllegalArgumentException()));
        return result;
    }

    public static Seat newSeat(List<Theater> theaterList, String r, int c, Status s, String t) {
        Seat result = new Seat(r, c, s, theaterList.stream().filter(theater -> theater.getName().equals(t)).findFirst().orElseThrow(() -> new IllegalArgumentException()));
        return result;
    }

    public static TicketSeat newTS(List<Seat> seatList, List<Ticket> ticketList, String r, int c, String u, String tn, LocalDateTime t) {
        TicketSeat result = new TicketSeat(
                seatList.stream().filter(seats -> seats.getRow().equals(r)).filter(seats -> seats.getColumn() == c).findFirst().orElseThrow(() -> new IllegalArgumentException()),
                ticketList.stream().filter(tickets -> tickets.getUser().getName().equals(u))
                        .filter(tickets -> tickets.getScreen().getTheater().getName().equals(tn))
                        .filter(tickets -> tickets.getScreen().getStartTime().equals(java.sql.Timestamp.valueOf(t)))
                        .findFirst().orElseThrow(() -> new IllegalArgumentException()));
        return result;
    }

}