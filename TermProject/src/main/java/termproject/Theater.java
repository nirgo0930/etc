package termproject;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import lombok.*;

@Getter
@Setter
@Entity(name = "THEATERS")
@NoArgsConstructor
@AllArgsConstructor
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "THEATER_ID")
    private Long theaterId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "FLOOR")
    private int floor;

    @OneToMany(mappedBy = "theater")
    private List<Seat> seats = new ArrayList<Seat>();

    public void addSeat(Seat seat){
        this.seats.add(seat);
        if(seat.getTheater()!=this){
            seat.setTheater(this);
        }
    }
    public Theater(String name, int floor) {
        this.setName(name);
        this.setFloor(floor);
    }
}