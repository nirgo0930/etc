package termproject;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "TICKETS")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TICKET_ID")
    private Long ticketId;

    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TicketSeat> ticketSeats = new ArrayList<TicketSeat>();

    public void addTicketSeat(TicketSeat ticketSeat){
        this.ticketSeats.add(ticketSeat);
        if(ticketSeat.getTicket()!=this){
            ticketSeat.setTicket(this);
        }
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    User user;

    public void setUser(User user){
        if(this.user!=null){
            this.user.getTickets().remove(this);
        }
        this.user=user;
        user.getTickets().add(this);
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SCREEN_ID")
    Screen screen;

    public void setScreen(Screen screen){
        if(this.screen!=null){
            this.screen.getTickets().remove(this);
        }
        this.screen=screen;
        screen.getTickets().add(this);
    }
    public Ticket(User user, Screen screen) {
        this.user = user;
        this.screen = screen;
    }
}
