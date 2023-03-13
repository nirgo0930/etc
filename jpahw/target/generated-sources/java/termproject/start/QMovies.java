package termproject.start;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMovies is a Querydsl query type for Movies
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMovies extends EntityPathBase<Movies> {

    private static final long serialVersionUID = -612079216L;

    public static final QMovies movies = new QMovies("movies");

    public final QTimeData _super = new QTimeData(this);

    //inherited
    public final DateTimePath<java.util.Date> create_time = _super.create_time;

    public final EnumPath<Genre> genre = createEnum("genre", Genre.class);

    public final NumberPath<Long> movie_id = createNumber("movie_id", Long.class);

    public final ListPath<Movie_workers, QMovie_workers> mw = this.<Movie_workers, QMovie_workers>createList("mw", Movie_workers.class, QMovie_workers.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final DatePath<java.util.Date> open_date = createDate("open_date", java.util.Date.class);

    public final NumberPath<Integer> running_time = createNumber("running_time", Integer.class);

    //inherited
    public final DateTimePath<java.util.Date> update_time = _super.update_time;

    public QMovies(String variable) {
        super(Movies.class, forVariable(variable));
    }

    public QMovies(Path<? extends Movies> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMovies(PathMetadata metadata) {
        super(Movies.class, metadata);
    }

}

