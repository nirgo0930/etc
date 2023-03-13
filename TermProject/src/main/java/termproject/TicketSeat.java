package termproject;

import javax.persistence.*;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "TICKET_SEATS")
public class TicketSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TICKET_SEATS_ID")
    private Long ticketSeatId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SEAT_ID")
    Seat seat;

    public void setSeat(Seat seat){
        if(this.seat !=null){
            this.seat.getTicketSeats().remove(this);
        }
        this.seat=seat;
        seat.getTicketSeats().add(this);
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TICKET_ID")
    Ticket ticket;

    public void setTicket(Ticket ticket){
        if(this.ticket !=null){
            this.ticket.getTicketSeats().remove(this);
        }
        this.ticket=ticket;
        ticket.getTicketSeats().add(this);
    }

    public TicketSeat(Seat seat, Ticket ticket) {
        this.seat = seat;
        this.ticket = ticket;
    }
}
