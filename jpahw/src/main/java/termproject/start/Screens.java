package termproject.start;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.*;

@Getter @Setter
@Entity(name = "SCREENS")
public class Screens {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SCREEN_ID")
    private Long screen_id;

    @Column(name = "START_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date start_time;

    @Column(name = "END_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date end_time;

    @OneToMany(mappedBy = "screens")
    private List<Tickets> mw = new ArrayList<Tickets>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "THEATER_ID")
    Theaters theaters;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MOVIE_ID")
    Movies movies;

    public Screens(Date start_time, Date end_time, Theaters theaters, Movies movies) {
        this.start_time = start_time;
        this.end_time = end_time;
        this.theaters = theaters;
        this.movies = movies;
    }
}
