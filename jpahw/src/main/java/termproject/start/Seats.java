package termproject.start;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import lombok.*;

@Getter
@Setter
@Entity(name = "SEATS")
public class Seats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SEAT_ID")
    private Long seat_id;
    @Column(name = "SEAT_ROW")
    private String row;
    @Column(name = "SEAT_COLUMN")
    private int column;
    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "seats")
    private List<Ticket_seats> ticket_seatsList = new ArrayList<Ticket_seats>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "THEATER_ID")
    Theaters theaters;

    public Seats(String row, int column, Status status, Theaters theaters) {
        this.row = row;
        this.column = column;
        this.status = status;
        this.theaters = theaters;
    }
}

enum Status {
    UNBOOKED, BOOKED
}