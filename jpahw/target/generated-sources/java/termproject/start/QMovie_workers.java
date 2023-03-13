package termproject.start;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMovie_workers is a Querydsl query type for Movie_workers
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMovie_workers extends EntityPathBase<Movie_workers> {

    private static final long serialVersionUID = -279097415L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMovie_workers movie_workers = new QMovie_workers("movie_workers");

    public final QMovies movies;

    public final NumberPath<Long> mw_id = createNumber("mw_id", Long.class);

    public final EnumPath<RoleType> role_type = createEnum("role_type", RoleType.class);

    public final QWorkers workers;

    public QMovie_workers(String variable) {
        this(Movie_workers.class, forVariable(variable), INITS);
    }

    public QMovie_workers(Path<? extends Movie_workers> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMovie_workers(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMovie_workers(PathMetadata metadata, PathInits inits) {
        this(Movie_workers.class, metadata, inits);
    }

    public QMovie_workers(Class<? extends Movie_workers> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.movies = inits.isInitialized("movies") ? new QMovies(forProperty("movies")) : null;
        this.workers = inits.isInitialized("workers") ? new QWorkers(forProperty("workers")) : null;
    }

}

