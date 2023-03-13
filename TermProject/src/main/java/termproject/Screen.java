package termproject;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "SCREENS")
public class Screen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SCREEN_ID")
    private Long screenId;

    @Column(name = "START_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;

    @Column(name = "END_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;

    @OneToMany(mappedBy = "screen")
    private List<Ticket> tickets = new ArrayList<Ticket>();

    public void addTicket(Ticket ticket){
        this.tickets.add(ticket);
        if(ticket.getScreen()!=this){
            ticket.setScreen(this);
        }
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "THEATER_ID")
    Theater theater;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MOVIE_ID")
    Movie movie;

    public Screen(Date startTime, Date endTime, Theater theater, Movie movie) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.theater = theater;
        this.movie = movie;
    }
}
