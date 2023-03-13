package termproject.start;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTheaters is a Querydsl query type for Theaters
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTheaters extends EntityPathBase<Theaters> {

    private static final long serialVersionUID = 1400925583L;

    public static final QTheaters theaters = new QTheaters("theaters");

    public final NumberPath<Integer> floor = createNumber("floor", Integer.class);

    public final StringPath name = createString("name");

    public final NumberPath<Long> theater_id = createNumber("theater_id", Long.class);

    public final ListPath<Seats, QSeats> tickets = this.<Seats, QSeats>createList("tickets", Seats.class, QSeats.class, PathInits.DIRECT2);

    public QTheaters(String variable) {
        super(Theaters.class, forVariable(variable));
    }

    public QTheaters(Path<? extends Theaters> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTheaters(PathMetadata metadata) {
        super(Theaters.class, metadata);
    }

}

