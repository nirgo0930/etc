package termproject.start;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.*;

@Entity(name = "MOVIES")    @Getter @Setter @NoArgsConstructor
public class Movies extends TimeData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MOVIE_ID")
    private Long movie_id;
    @Column(name = "NAME")
    private String name;
    @Temporal(TemporalType.DATE)
    @Column(name = "OPEN_DATE")
    private Date open_date;
    @Column(name = "GENRE")
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @Column(name = "RUNNING_TIME")
    private int running_time;

    @OneToMany(mappedBy = "movies")
    private List<Movie_workers> mw = new ArrayList<Movie_workers>();

    public Movies(String name, Date open_date, Genre genre, int running_time) {
        this.setName(name);
        this.setOpen_date(open_date);
        this.setGenre(genre);
        this.setRunning_time(running_time);
    }
}

enum Genre {
    ACTION, ADVENTURE, ANIMATED, COMEDY, DRAMA, FANTASY, HISTORICAL, HORROR, SF, THRILLER, WESTERN
}