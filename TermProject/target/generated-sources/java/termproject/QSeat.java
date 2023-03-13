package termproject;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSeat is a Querydsl query type for Seat
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSeat extends EntityPathBase<Seat> {

    private static final long serialVersionUID = 24525382L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSeat seat = new QSeat("seat");

    public final NumberPath<Integer> column = createNumber("column", Integer.class);

    public final StringPath row = createString("row");

    public final NumberPath<Long> seatId = createNumber("seatId", Long.class);

    public final EnumPath<Status> status = createEnum("status", Status.class);

    public final QTheater theater;

    public final ListPath<TicketSeat, QTicketSeat> ticketSeats = this.<TicketSeat, QTicketSeat>createList("ticketSeats", TicketSeat.class, QTicketSeat.class, PathInits.DIRECT2);

    public QSeat(String variable) {
        this(Seat.class, forVariable(variable), INITS);
    }

    public QSeat(Path<? extends Seat> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSeat(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSeat(PathMetadata metadata, PathInits inits) {
        this(Seat.class, metadata, inits);
    }

    public QSeat(Class<? extends Seat> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.theater = inits.isInitialized("theater") ? new QTheater(forProperty("theater")) : null;
    }

}

