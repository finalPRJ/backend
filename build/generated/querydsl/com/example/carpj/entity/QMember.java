package com.example.carpj.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = -1209631596L;

    public static final QMember member = new QMember("member1");

    public final StringPath address = createString("address");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final EnumPath<AuthProvider> authProvider = createEnum("authProvider", AuthProvider.class);

    public final StringPath detail_Address = createString("detail_Address");

    public final StringPath email = createString("email");

    public final BooleanPath emailVerified = createBoolean("emailVerified");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath location_Num = createString("location_Num");

    public final StringPath name = createString("name");

    public final StringPath nickname = createString("nickname");

    public final StringPath password = createString("password");

    public final StringPath phone = createString("phone");

    public final StringPath platform = createString("platform");

    public final StringPath providerId = createString("providerId");

    public final StringPath refreshToken = createString("refreshToken");

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

