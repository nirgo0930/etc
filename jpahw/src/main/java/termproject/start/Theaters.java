package termproject.start;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.*;

@Getter @Setter
@Entity(name = "THEATERS")
public class Theaters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "THEATER_ID")
    private Long theater_id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "FLOOR")
    private int floor;

    @OneToMany(mappedBy = "theaters")
    private List<Seats> tickets = new ArrayList<Seats>();

    public Theaters(String name, int floor){
        this.setName(name);
        this.setFloor(floor);
    }
}