package termproject.start;

import javax.persistence.*;
import lombok.*;

@Embeddable @Getter @Setter @NoArgsConstructor
public class Address {
    @Column(name = "CITY")
    private String city;
    @Column(name = "STREET")
    private String street;
    @Column(name = "ZIPCODE")
    private String zipCode;

    public Address(String city, String street, String zipCode) {
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
    }
}
