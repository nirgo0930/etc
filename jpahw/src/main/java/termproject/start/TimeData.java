package termproject.start;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.*;
import org.hibernate.annotations.*;

@Getter @Setter
@MappedSuperclass
public abstract class TimeData {
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "CREATE_TIME")
    private Date create_time = java.sql.Timestamp.valueOf(LocalDateTime.now());

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(name = "UPDATE_TIME")
    private Date update_time = java.sql.Timestamp.valueOf(LocalDateTime.now());
}
