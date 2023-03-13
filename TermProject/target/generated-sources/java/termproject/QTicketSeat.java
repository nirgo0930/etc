package termproject;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTicketSeat is a Querydsl query type for TicketSeat
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTicketSeat extends EntityPathBase<TicketSeat> {

    private static final long serialVersionUID = 490716850L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTicketSeat ticketSeat = new QTicketSeat("ticketSeat");

    public final QSeat seat;

    public final QTicket ticket;

    public final NumberPath<Long> ticketSeatId = createNumber("ticketSeatId", Long.class);

    public QTicketSeat(String variable) {
        this(TicketSeat.class, forVariable(variable), INITS);
    }

    public QTicketSeat(Path<? extends TicketSeat> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTicketSeat(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTicketSeat(PathMetadata metadata, PathInits inits) {
        this(TicketSeat.class, metadata, inits);
    }

    public QTicketSeat(Class<? extends TicketSeat> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.seat = inits.isInitialized("seat") ? new QSeat(forProperty("seat"), inits.get("seat")) : null;
        this.ticket = inits.isInitialized("ticket") ? new QTicket(forProperty("ticket"), inits.get("ticket")) : null;
    }

}

