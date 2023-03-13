package termproject.start;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.*;

@Entity @Getter @Setter
@Table(name = "WORKERS")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
public abstract class Workers extends TimeData{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WORKER_ID")
    private Long worker_id;
    @Column(name = "NAME")
    private String name;
    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTH_DATE")
    private Date birth_date;

    @OneToMany(mappedBy = "workers")
    private List<Movie_workers> mw = new ArrayList<Movie_workers>();
}