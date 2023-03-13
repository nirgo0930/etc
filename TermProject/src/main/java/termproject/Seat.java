package termproject;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import lombok.*;

@Getter
@Setter
@Entity(name = "SEATS")
@NoArgsConstructor
@AllArgsConstructor
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SEAT_ID")
    private Long seatId;
    @Column(name = "SEAT_ROW")
    private String row;
    @Column(name = "SEAT_COLUMN")
    private int column;
    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "seat")
    private List<TicketSeat> ticketSeats = new ArrayList<TicketSeat>();

    public void addTicketSeat(TicketSeat ticketSeat){
        this.ticketSeats.add(ticketSeat);
        if(ticketSeat.getSeat()!=this){
            ticketSeat.setSeat(this);
        }
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "THEATER_ID")
    Theater theater;

    public void setTheater(Theater theater) {
        if(this.theater!=null){
            this.theater.getSeats().remove(this);
        }
        this.theater=theater;
        theater.getSeats().add(this);
    }

    public Seat(String row, int column, Status status, Theater theater) {
        this.row = row;
        this.column = column;
        this.status = status;
        this.theater = theater;
    }
}

enum Status {
    UNUSABLE, USABLE
}