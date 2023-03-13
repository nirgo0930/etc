package termproject.start;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QActors is a Querydsl query type for Actors
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QActors extends EntityPathBase<Actors> {

    private static final long serialVersionUID = -966764693L;

    public static final QActors actors = new QActors("actors");

    public final QWorkers _super = new QWorkers(this);

    //inherited
    public final DatePath<java.util.Date> birth_date = _super.birth_date;

    //inherited
    public final DateTimePath<java.util.Date> create_time = _super.create_time;

    public final NumberPath<Integer> height = createNumber("height", Integer.class);

    public final StringPath instagram_id = createString("instagram_id");

    //inherited
    public final ListPath<Movie_workers, QMovie_workers> mw = _super.mw;

    //inherited
    public final StringPath name = _super.name;

    //inherited
    public final DateTimePath<java.util.Date> update_time = _super.update_time;

    //inherited
    public final NumberPath<Long> worker_id = _super.worker_id;

    public QActors(String variable) {
        super(Actors.class, forVariable(variable));
    }

    public QActors(Path<? extends Actors> path) {
        super(path.getType(), path.getMetadata());
    }

    public QActors(PathMetadata metadata) {
        super(Actors.class, metadata);
    }

}

