package termproject;

import javax.persistence.*;
import java.util.Date;

import lombok.*;

@Getter
@Setter

@DiscriminatorValue("ACTOR")
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "ACTORS")
public class Actor extends Worker {
    @Column(name = "HEIGHT")
    private int height;
    @Column(name = "INSTAGRAM_ID")
    private String instagramId;

    public Actor(String name, Date birthdate, int height, String instagramId) {
        this.setName(name);
        this.setBirthDate(birthdate);
        this.setHeight(height);
        this.setInstagramId(instagramId);
    }
}