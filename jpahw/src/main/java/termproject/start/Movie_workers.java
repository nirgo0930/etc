package termproject.start;

import javax.persistence.*;
import lombok.*;

@Getter @Setter
@Entity(name = "MOVIE_WORKERS")
public class Movie_workers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MOVIE_WORKERS_ID")
    private Long mw_id;

    @Column(name = "ROLE_TYPE")
    @Enumerated(EnumType.STRING)
    private RoleType role_type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "WORKER_ID")
    Workers workers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MOVIE_ID")
    Movies movies;

    public Movie_workers(RoleType role_type,Workers worker,Movies movie){
        this.setRole_type(role_type);
        this.setWorkers(worker);
        this.setMovies(movie);
    }
}

enum RoleType{
    Director, MainCharacter, SubCharacter
}