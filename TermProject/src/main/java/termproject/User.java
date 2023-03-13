package termproject;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import lombok.*;


@Getter
@Setter
@Entity(name = "USERS")
@NoArgsConstructor
@AllArgsConstructor
public class User extends TimeData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long userId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "AGE")
    private int age;
    @Embedded
    Address address;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> tickets = new ArrayList<Ticket>();

    public void addTicket(Ticket ticket){
        this.tickets.add(ticket);
        if(ticket.getUser()!=this){
            ticket.setUser(this);
        }
    }

    public User(String name, int age, String city, String street, String zipCode) {
        this.name = name;
        this.age = age;
        this.address = new Address(city, street, zipCode);
    }
}
