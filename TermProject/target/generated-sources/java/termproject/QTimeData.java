package termproject;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QTimeData is a Querydsl query type for TimeData
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QTimeData extends EntityPathBase<TimeData> {

    private static final long serialVersionUID = -622531624L;

    public static final QTimeData timeData = new QTimeData("timeData");

    public final DateTimePath<java.util.Date> createTime = createDateTime("createTime", java.util.Date.class);

    public final DateTimePath<java.util.Date> updateTime = createDateTime("updateTime", java.util.Date.class);

    public QTimeData(String variable) {
        super(TimeData.class, forVariable(variable));
    }

    public QTimeData(Path<? extends TimeData> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTimeData(PathMetadata metadata) {
        super(TimeData.class, metadata);
    }

}

