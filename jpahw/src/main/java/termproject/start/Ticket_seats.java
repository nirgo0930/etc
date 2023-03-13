package termproject.start;

import javax.persistence.*;
import lombok.*;

@Getter @Setter
@Entity(name = "TICKET_SEATS")
public class Ticket_seats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TICKET_SEATS_ID")
    private Long ts_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SEAT_ID")
    Seats seats;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TICKET_ID")
    Tickets tickets;

    public Ticket_seats(Seats seats, Tickets tickets) {
        this.seats = seats;
        this.tickets = tickets;
    }
}
