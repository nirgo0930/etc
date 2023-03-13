package termproject.start;

import javax.persistence.*;
import java.util.Date;
import lombok.*;

@Getter @Setter
@Entity(name = "DIRECTORS")
@DiscriminatorValue("DIRECTOR")
public class Directors extends Workers {
    @Column(name = "BIRTH_PLACE")
    private String birth_place;

    public Directors(String name, Date birthdate, String birth_place) {
        this.setName(name);
        this.setBirth_date(birthdate);
        this.setBirth_place(birth_place);
    }
}