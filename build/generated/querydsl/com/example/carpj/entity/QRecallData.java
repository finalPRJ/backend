package com.example.carpj.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QRecallData is a Querydsl query type for RecallData
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRecallData extends EntityPathBase<RecallData> {

    private static final long serialVersionUID = -1108799659L;

    public static final QRecallData recallData = new QRecallData("recallData");

    public final StringPath brand = createString("brand");

    public final StringPath model = createString("model");

    public final StringPath reasons = createString("reasons");

    public final NumberPath<Integer> rNo = createNumber("rNo", Integer.class);

    public QRecallData(String variable) {
        super(RecallData.class, forVariable(variable));
    }

    public QRecallData(Path<? extends RecallData> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRecallData(PathMetadata metadata) {
        super(RecallData.class, metadata);
    }

}

