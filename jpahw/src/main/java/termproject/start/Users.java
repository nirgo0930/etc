package termproject.start;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import lombok.*;

@Getter
@Setter @NoArgsConstructor
@Entity(name = "USERS")
public class Users extends TimeData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long user_id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "AGE")
    private int age;
    @Embedded
    Address address;

    @OneToMany(mappedBy = "users")
    private List<Tickets> tickets = new ArrayList<Tickets>();

    public Users(String name, int age, String city, String street, String zipCode) {
        this.name = name;
        this.age = age;
        this.address = new Address(city, street, zipCode);
    }
}
