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
@Entity(name = "MOVIES")
public class Movie extends TimeData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MOVIE_ID")
    private Long movieId;
    @Column(name = "NAME")
    private String name;
    @Temporal(TemporalType.DATE)
    @Column(name = "OPEN_DATE")
    private Date openDate;
    @Column(name = "GENRE")
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @Column(name = "RUNNING_TIME")
    private int runningTime;

    @OneToMany(mappedBy = "movie")
    private List<MovieWorker> movieWorkers = new ArrayList<>();

    public void addMovieWorkers(MovieWorker movieWorker){
        this.movieWorkers.add(movieWorker);
        if(movieWorker.getMovie()!=this)
            movieWorker.setMovie(this);
    }
    public Movie(String name, Date openDate, Genre genre, int runningTime) {
        this.setName(name);
        this.setOpenDate(openDate);
        this.setGenre(genre);
        this.setRunningTime(runningTime);
    }
}

enum Genre {
    ACTION, ADVENTURE, ANIMATED, COMEDY, DRAMA, FANTASY, HISTORICAL, HORROR, SF, THRILLER, WESTERN
}