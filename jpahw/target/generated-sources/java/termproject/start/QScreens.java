package termproject.start;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QScreens is a Querydsl query type for Screens
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QScreens extends EntityPathBase<Screens> {

    private static final long serialVersionUID = -1111894822L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QScreens screens = new QScreens("screens");

    public final DateTimePath<java.util.Date> end_time = createDateTime("end_time", java.util.Date.class);

    public final QMovies movies;

    public final ListPath<Tickets, QTickets> mw = this.<Tickets, QTickets>createList("mw", Tickets.class, QTickets.class, PathInits.DIRECT2);

    public final NumberPath<Long> screen_id = createNumber("screen_id", Long.class);

    public final DateTimePath<java.util.Date> start_time = createDateTime("start_time", java.util.Date.class);

    public final QTheaters theaters;

    public QScreens(String variable) {
        this(Screens.class, forVariable(variable), INITS);
    }

    public QScreens(Path<? extends Screens> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QScreens(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QScreens(PathMetadata metadata, PathInits inits) {
        this(Screens.class, metadata, inits);
    }

    public QScreens(Class<? extends Screens> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.movies = inits.isInitialized("movies") ? new QMovies(forProperty("movies")) : null;
        this.theaters = inits.isInitialized("theaters") ? new QTheaters(forProperty("theaters")) : null;
    }

}

