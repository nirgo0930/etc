package termproject.start;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTicket_seats is a Querydsl query type for Ticket_seats
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTicket_seats extends EntityPathBase<Ticket_seats> {

    private static final long serialVersionUID = -177316696L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTicket_seats ticket_seats = new QTicket_seats("ticket_seats");

    public final QSeats seats;

    public final QTickets tickets;

    public final NumberPath<Long> ts_id = createNumber("ts_id", Long.class);

    public QTicket_seats(String variable) {
        this(Ticket_seats.class, forVariable(variable), INITS);
    }

    public QTicket_seats(Path<? extends Ticket_seats> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTicket_seats(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTicket_seats(PathMetadata metadata, PathInits inits) {
        this(Ticket_seats.class, metadata, inits);
    }

    public QTicket_seats(Class<? extends Ticket_seats> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.seats = inits.isInitialized("seats") ? new QSeats(forProperty("seats"), inits.get("seats")) : null;
        this.tickets = inits.isInitialized("tickets") ? new QTickets(forProperty("tickets"), inits.get("tickets")) : null;
    }

}

