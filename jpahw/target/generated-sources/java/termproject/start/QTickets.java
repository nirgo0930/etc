package termproject.start;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTickets is a Querydsl query type for Tickets
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTickets extends EntityPathBase<Tickets> {

    private static final long serialVersionUID = -66290118L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTickets tickets = new QTickets("tickets");

    public final ListPath<Ticket_seats, QTicket_seats> mw = this.<Ticket_seats, QTicket_seats>createList("mw", Ticket_seats.class, QTicket_seats.class, PathInits.DIRECT2);

    public final QScreens screens;

    public final NumberPath<Long> ticket_id = createNumber("ticket_id", Long.class);

    public final QUsers users;

    public QTickets(String variable) {
        this(Tickets.class, forVariable(variable), INITS);
    }

    public QTickets(Path<? extends Tickets> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTickets(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTickets(PathMetadata metadata, PathInits inits) {
        this(Tickets.class, metadata, inits);
    }

    public QTickets(Class<? extends Tickets> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.screens = inits.isInitialized("screens") ? new QScreens(forProperty("screens"), inits.get("screens")) : null;
        this.users = inits.isInitialized("users") ? new QUsers(forProperty("users"), inits.get("users")) : null;
    }

}

