package termproject;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDirector is a Querydsl query type for Director
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDirector extends EntityPathBase<Director> {

    private static final long serialVersionUID = 1701361485L;

    public static final QDirector director = new QDirector("director");

    public final QWorker _super = new QWorker(this);

    //inherited
    public final DatePath<java.util.Date> birthDate = _super.birthDate;

    public final StringPath birthPlace = createString("birthPlace");

    //inherited
    public final DateTimePath<java.util.Date> createTime = _super.createTime;

    //inherited
    public final ListPath<MovieWorker, QMovieWorker> movieWorkers = _super.movieWorkers;

    //inherited
    public final StringPath name = _super.name;

    //inherited
    public final DateTimePath<java.util.Date> updateTime = _super.updateTime;

    //inherited
    public final NumberPath<Long> workerId = _super.workerId;

    public QDirector(String variable) {
        super(Director.class, forVariable(variable));
    }

    public QDirector(Path<? extends Director> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDirector(PathMetadata metadata) {
        super(Director.class, metadata);
    }

}

