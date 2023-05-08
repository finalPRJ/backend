package com.example.carpj.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QRecall is a Querydsl query type for Recall
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRecall extends EntityPathBase<Recall> {

    private static final long serialVersionUID = -1066784501L;

    public static final QRecall recall = new QRecall("recall");

    public final NumberPath<Integer> amount = createNumber("amount", Integer.class);

    public final StringPath brand = createString("brand");

    public final StringPath model = createString("model");

    public final StringPath ranking = createString("ranking");

    public final StringPath reasons = createString("reasons");

    public final NumberPath<Integer> rNo = createNumber("rNo", Integer.class);

    public QRecall(String variable) {
        super(Recall.class, forVariable(variable));
    }

    public QRecall(Path<? extends Recall> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRecall(PathMetadata metadata) {
        super(Recall.class, metadata);
    }

}

