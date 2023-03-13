package termproject;

import javax.persistence.*;
import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "MOVIE_WORKERS")
public class MovieWorker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MOVIE_WORKERS_ID")
    private Long movieWorkerId;

    @Column(name = "ROLE_TYPE")
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "WORKER_ID")
    Worker worker;

    public void setWorker(Worker worker){
        if(this.worker !=null)
            this.worker.getMovieWorkers().remove(this);
        this.worker = worker;
        worker.getMovieWorkers().add(this);
    }


    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "MOVIE_ID")
    Movie movie;

    public void setMovie(Movie movie){
        if(this.movie !=null)
            this.movie.getMovieWorkers().remove(this);
        this.movie = movie;
        movie.getMovieWorkers().add(this);
    }
    public MovieWorker(RoleType roleType, Worker worker, Movie movie){
        this.setRoleType(roleType);
        this.setWorker(worker);
        this.setMovie(movie);
    }
}

enum RoleType{
    Director, MainCharacter, SubCharacter
}