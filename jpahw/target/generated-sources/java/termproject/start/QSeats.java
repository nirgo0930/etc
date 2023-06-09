package termproject.start;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSeats is a Querydsl query type for Seats
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSeats extends EntityPathBase<Seats> {

    private static final long serialVersionUID = 1648046881L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSeats seats = new QSeats("seats");

    public final StringPath column = createString("column");

    public final ListPath<Ticket_seats, QTicket_seats> mw = this.<Ticket_seats, QTicket_seats>createList("mw", Ticket_seats.class, QTicket_seats.class, PathInits.DIRECT2);

    public final StringPath row = createString("row");

    public final NumberPath<Long> seat_id = createNumber("seat_id", Long.class);

    public final StringPath status = createString("status");

    public final QTheaters theaters;

    public QSeats(String variable) {
        this(Seats.class, forVariable(variable), INITS);
    }

    public QSeats(Path<? extends Seats> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSeats(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSeats(PathMetadata metadata, PathInits inits) {
        this(Seats.class, metadata, inits);
    }

    public QSeats(Class<? extends Seats> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.theaters = inits.isInitialized("theaters") ? new QTheaters(forProperty("theaters")) : null;
    }

}

