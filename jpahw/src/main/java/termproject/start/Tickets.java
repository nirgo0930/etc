package termproject.start;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.*;

@Getter @Setter
@Entity(name = "TICKETS")
public class Tickets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TICKET_ID")
    private Long ticket_id;

    @OneToMany(mappedBy = "tickets")
    private List<Ticket_seats> ticket_seatsList = new ArrayList<Ticket_seats>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    Users users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SCREEN_ID")
    Screens screens;

    public Tickets(Users users, Screens screens) {
        this.users = users;
        this.screens = screens;
    }
}
