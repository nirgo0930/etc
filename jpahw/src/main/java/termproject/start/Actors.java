package termproject.start;

import javax.persistence.*;
import java.util.Date;
import lombok.*;

@Getter @Setter
@Entity(name = "ACTORS")
@DiscriminatorValue("ACTOR")
public class Actors extends Workers {
    @Column(name = "HEIGHT")
    private int height;
    @Column(name = "INSTAGRAM_ID")
    private String instagram_id;

    public Actors(String name, Date birthdate, int height, String instagram_id) {
        this.setName(name);
        this.setBirth_date(birthdate);
        this.setHeight(height);
        this.setInstagram_id(instagram_id);
    }
}