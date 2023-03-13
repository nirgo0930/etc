package termproject;

import javax.persistence.*;
import java.util.Date;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "DIRECTORS")
@DiscriminatorValue("DIRECTOR")
public class Director extends Worker {
    @Column(name = "BIRTH_PLACE")
    private String birthPlace;

    public Director(String name, Date birthdate, String birthPlace) {
        this.setName(name);
        this.setBirthDate(birthdate);
        this.setBirthPlace(birthPlace);
    }
}