package termproject.start;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDirectors is a Querydsl query type for Directors
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDirectors extends EntityPathBase<Directors> {

    private static final long serialVersionUID = -171762438L;

    public static final QDirectors directors = new QDirectors("directors");

    public final QWorkers _super = new QWorkers(this);

    //inherited
    public final DatePath<java.util.Date> birth_date = _super.birth_date;

    public final StringPath birth_place = createString("birth_place");

    //inherited
    public final DateTimePath<java.util.Date> create_time = _super.create_time;

    //inherited
    public final ListPath<Movie_workers, QMovie_workers> mw = _super.mw;

    //inherited
    public final StringPath name = _super.name;

    //inherited
    public final DateTimePath<java.util.Date> update_time = _super.update_time;

    //inherited
    public final NumberPath<Long> worker_id = _super.worker_id;

    public QDirectors(String variable) {
        super(Directors.class, forVariable(variable));
    }

    public QDirectors(Path<? extends Directors> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDirectors(PathMetadata metadata) {
        super(Directors.class, metadata);
    }

}

