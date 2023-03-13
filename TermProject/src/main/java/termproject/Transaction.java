package termproject;

import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.*;

import termproject.QMovie;
import termproject.QMovieWorker;
import termproject.QWorker;

public class Transaction {
    //1번
    public static void createUser(EntityManagerFactory emf,String name, Integer age, String city, String street, String zipCode)
    {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            User user = new User();
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
            User user = em.find(User.class,userId);
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
            Movie movie = em.find(Movie.class, movieId);
            System.out.println("영화명= " + movie.getName());
            System.out.println("장르= " + movie.getGenre());
            System.out.println("개봉일 = " + movie.getOpenDate());
            System.out.println("러닝타임 = " + movie.getRunningTime());
            List<MovieWorker> movieWorkers = movie.getMovieWorkers();
            System.out.println("=============================================");
            for(MovieWorker movieWorker :movieWorkers)
            {

                System.out.println("감독/배우명 = " + movieWorker.getWorker().getName());
                System.out.println("담당 = " + movieWorker.getRoleType());
                System.out.println("생년월일 = " + movieWorker.getWorker().getBirthDate());
                if(movieWorker.getRoleType().equals(RoleType.Director))
                {
                    Director director = em.find(Director.class, movieWorker.getWorker().getWorkerId());
                    System.out.println("출생지 = " + director.getBirthPlace());
                }
                else{
                    Actor actor = em.find(Actor.class, movieWorker.getWorker().getWorkerId());
                    System.out.println("키 = " + actor.getHeight());
                    System.out.println("인스타그램ID = " + actor.getInstagramId());
                }
                System.out.println("=============================================");
            }
            tx.commit();
        }catch (Exception e) {
            System.out.println("오류 발생");
            tx.rollback();
        } finally {
            em.close();
        }
    }
    public static Worker findWorker(EntityManagerFactory emf, Long workerId){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        Worker worker =null;
        try{
            tx.begin();
            worker = em.find(Worker.class, workerId);

            tx.commit();
        }catch (Exception e) {
            System.out.println("오류 발생");
            tx.rollback();
        } finally {
            em.close();
        }
        return worker;
    }
    //4번
    public static void findMovieWithWorkerOpeningDateRunningTime(EntityManagerFactory emf, Worker director, Worker actor, Date openDate){
        EntityManager em = emf.createEntityManager();
        JPAQueryFactory query = new JPAQueryFactory(em);

        QMovie qMovies= new QMovie("m");
        QMovieWorker qMovie_workers= new QMovieWorker("mw");
        QMovieWorker qMovie_workers2= new QMovieWorker("mw2");

        List<Movie> movies=query.selectFrom(qMovies)
                .join(qMovies.movieWorkers,qMovie_workers)
                .join(qMovies.movieWorkers,qMovie_workers2)
                .where(qMovies.openDate.eq(openDate),qMovie_workers.worker.eq(director),qMovie_workers2.worker.eq(actor))
                .fetchJoin()
                .fetch();
        movies.stream().distinct().forEach(m->
                System.out.println("영화 검색 결과= " + m.getName()));

    }
    //5번
    public static void findMoviesAndActors(EntityManagerFactory emf)
    {
        EntityManager em = emf.createEntityManager();
        JPAQueryFactory query = new JPAQueryFactory(em);

        QMovie qMovies= new QMovie("m");
        termproject.QMovieWorker qMovieWorkers= new QMovieWorker("mw");
        QWorker qWorkers = new QWorker("w");

        List<Movie> movies=query.selectFrom(qMovies)
                .join(qMovies.movieWorkers,qMovieWorkers) .fetchJoin()
                .join(qMovieWorkers.worker,qWorkers).fetchJoin()
                .where(qMovieWorkers.roleType.ne(RoleType.Director))
                .offset(0).limit(2)
                .fetch();
        for(Movie movie:movies){
            System.out.println("=============================================");
            System.out.println("영화명 = " + movie.getName());
            System.out.println("장르 = " + movie.getGenre());
            System.out.println("러닝타임 = " + movie.getRunningTime());
            System.out.println("개봉일 = " + movie.getOpenDate());
            System.out.println("=============================================");

            List<MovieWorker> mw= movie.getMovieWorkers();
            for(MovieWorker movieWorker :mw) {

                Actor actor = (Actor) movieWorker.getWorker();
                System.out.println("배우명 = " + actor.getName());
                System.out.println("담당 = " + movieWorker.getRoleType());
                System.out.println("생년월일 = " + actor.getBirthDate());
                System.out.println("키 = " + actor.getHeight());
                System.out.println("인스타그램ID = " + actor.getInstagramId());
                System.out.println("=============================================");
            }
        }
    }
    public static void searchScreenInfo(EntityManagerFactory emf, Long screenId) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Screen screens = em.find(Screen.class, screenId);
            List<Seat> seats = Arrays.asList(screens.getTheater().getSeats().stream()
                    .filter(seat -> seat.getStatus().equals(Status.USABLE))
                    .sorted(Comparator.comparing(Seat::getRow).thenComparing(Seat::getColumn))
                    .toArray(Seat[]::new));
            List<Ticket> bookedTickets = screens.getTickets();
            List<Seat> bookedSeats = new ArrayList<>();
            for (Ticket ticket : bookedTickets) {
                List<TicketSeat> ticket_seats = ticket.getTicketSeats();
                for (TicketSeat ts : ticket_seats) {
                    bookedSeats.add(ts.getSeat());
                }
            }
            List<Seat> remainSeats = new ArrayList<Seat>(seats);
            remainSeats.removeAll(bookedSeats);

            System.out.println("영화명 = " + screens.getMovie().getName());
            System.out.println("시작시간 = " + screens.getStartTime());
            System.out.println("종료시간 = " + screens.getEndTime());
            System.out.println("총 좌석 = " + seats.size());
            System.out.print("잔여 좌석 = ");

            for (Seat seat : remainSeats) {
                if (seat.getStatus().equals(Status.USABLE)) {
                    System.out.print(seat.getRow() + seat.getColumn() + " ");
                }
            }
            System.out.println("(총 " + remainSeats.size() + "석)\n");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
    }

    public static void bookSeat(EntityManagerFactory emf, Long userId, Long screenId, Long[] bookSeatsId) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            User user = em.find(User.class, userId);
            Screen screen = em.find(Screen.class, screenId);
            List<Seat> seats = Arrays.asList(screen.getTheater().getSeats().stream()
                    .filter(seat -> seat.getStatus().equals(Status.USABLE))
                    .sorted(Comparator.comparing(Seat::getRow).thenComparing(Seat::getColumn))
                    .toArray(Seat[]::new));
            List<Ticket> bookedTickets = screen.getTickets();
            List<Seat> bookedSeats = new ArrayList<>();
            for (Ticket ticket : bookedTickets) {
                List<TicketSeat> ticket_seats = ticket.getTicketSeats();
                for (TicketSeat ts : ticket_seats) {
                    bookedSeats.add(ts.getSeat());
                }
            }
            List<Seat> remainSeats = new ArrayList<Seat>(seats);
            remainSeats.removeAll(bookedSeats);

            Ticket ticket = new Ticket(user, screen);
            List<TicketSeat> bookTicket_seatsList = new ArrayList<>();

            for (Long seatId : bookSeatsId) {
                for (Seat seat : remainSeats) {
                    if (seat.getStatus().equals(Status.USABLE) && seat.getSeatId() == seatId) {
                        bookTicket_seatsList.add(new TicketSeat(seat, ticket));
                    }
                }
            }
            System.out.println();
            em.persist(ticket);
            for (TicketSeat item : bookTicket_seatsList) {
                em.persist(item);
            }
            tx.commit();
        } catch (Exception e) {
            System.out.println(e);
            tx.rollback();
        } finally {
            em.close();
        }
    }

    public static void unBookSeat(EntityManagerFactory emf, Long userId, Long ticketId) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            User user = em.find(User.class, userId);
            for (Ticket ticket : user.getTickets()) {
                if (ticket.getTicketId().equals(ticketId)) {
                    for (TicketSeat ts : ticket.getTicketSeats()) {
                        em.remove(ts);
                    }
                }
            }

            tx.commit();
        } catch (Exception e) {
            System.out.println(e);
            tx.rollback();
        } finally {
            em.close();
        }
    }

    public static void printBookInfo(EntityManagerFactory emf, Long userId) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            User user = em.find(User.class, userId);
            System.out.println("사용자 : " + user.getName());
            List<Ticket> ticketsList = user.getTickets();
            System.out.println("예매 현황");
            for (Ticket ticket : ticketsList) {
                System.out.print("\t예매 번호 : " + ticket.getTicketId());
                List<TicketSeat> ts = ticket.getTicketSeats();
                if (ts.size() < 1) {
                    System.out.println("(결제 취소)\n");
                } else {
                    System.out.println("(결졔 완료)\n");
                }
            }
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
    }

    public static void printTicketInfo(EntityManagerFactory emf, Long ticketId) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Ticket ticket = em.find(Ticket.class, ticketId);
            System.out.println("티켓 번호 : " + ticket.getTicketId());
            System.out.println("관람 영화 : " + ticket.getScreen().getMovie().getName());
            System.out.println("상영관 : " + ticket.getScreen().getTheater().getName());
            System.out.print("선택 좌석 : ");
            for (TicketSeat item : ticket.getTicketSeats()) {
                Seat seat = item.getSeat();
                System.out.print(seat.getRow() + seat.getColumn() + " ");
            }
            System.out.println();
            System.out.println("시작 시간 : " + ticket.getScreen().getStartTime() + "\n");

            tx.commit();
        } catch (Exception e) {
            System.out.println(e);
            tx.rollback();
        } finally {
            em.close();
        }
    }

    public static void removeUser(EntityManagerFactory emf, Long userId) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            User user = em.find(User.class, userId);

            em.remove(user);

            tx.commit();
        } catch (Exception e) {
            System.out.println(e);
            tx.rollback();
        } finally {
            em.close();
        }

    }
}
