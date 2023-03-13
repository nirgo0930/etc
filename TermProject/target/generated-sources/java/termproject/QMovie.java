package termproject;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMovie is a Querydsl query type for Movie
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMovie extends EntityPathBase<Movie> {

    private static final long serialVersionUID = 755063567L;

    public static final QMovie movie = new QMovie("movie");

    public final QTimeData _super = new QTimeData(this);

    //inherited
    public final DateTimePath<java.util.Date> createTime = _super.createTime;

    public final EnumPath<Genre> genre = createEnum("genre", Genre.class);

    public final NumberPath<Long> movieId = createNumber("movieId", Long.class);

    public final ListPath<MovieWorker, QMovieWorker> movieWorkers = this.<MovieWorker, QMovieWorker>createList("movieWorkers", MovieWorker.class, QMovieWorker.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final DatePath<java.util.Date> openDate = createDate("openDate", java.util.Date.class);

    public final NumberPath<Integer> runningTime = createNumber("runningTime", Integer.class);

    //inherited
    public final DateTimePath<java.util.Date> updateTime = _super.updateTime;

    public QMovie(String variable) {
        super(Movie.class, forVariable(variable));
    }

    public QMovie(Path<? extends Movie> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMovie(PathMetadata metadata) {
        super(Movie.class, metadata);
    }

}

