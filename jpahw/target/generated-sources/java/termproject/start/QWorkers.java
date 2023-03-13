package termproject.start;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QWorkers is a Querydsl query type for Workers
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QWorkers extends EntityPathBase<Workers> {

    private static final long serialVersionUID = -1513118712L;

    public static final QWorkers workers = new QWorkers("workers");

    public final QTimeData _super = new QTimeData(this);

    public final DatePath<java.util.Date> birth_date = createDate("birth_date", java.util.Date.class);

    //inherited
    public final DateTimePath<java.util.Date> create_time = _super.create_time;

    public final ListPath<Movie_workers, QMovie_workers> mw = this.<Movie_workers, QMovie_workers>createList("mw", Movie_workers.class, QMovie_workers.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    //inherited
    public final DateTimePath<java.util.Date> update_time = _super.update_time;

    public final NumberPath<Long> worker_id = createNumber("worker_id", Long.class);

    public QWorkers(String variable) {
        super(Workers.class, forVariable(variable));
    }

    public QWorkers(Path<? extends Workers> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWorkers(PathMetadata metadata) {
        super(Workers.class, metadata);
    }

}

