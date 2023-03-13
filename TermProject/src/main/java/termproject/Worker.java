package termproject;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "WORKERS")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DTYPE")
public abstract class Worker extends TimeData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WORKER_ID")
    private Long workerId;
    @Column(name = "NAME")
    private String name;
    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTH_DATE")
    private Date birthDate;

    @OneToMany(mappedBy = "worker")
    private List<MovieWorker> movieWorkers = new ArrayList<MovieWorker>();

    public void addMovieWorkers(MovieWorker MovieWorker) {
        this.movieWorkers.add(MovieWorker);
        if (MovieWorker.getWorker() != this)
            MovieWorker.setWorker(this);
    }
}