package com.example.services.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDepot is a Querydsl query type for Depot
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDepot extends EntityPathBase<Depot> {

    private static final long serialVersionUID = 1109124776L;

    public static final QDepot depot = new QDepot("depot");

    public final StringPath address = createString("address");

    public final StringPath City = createString("City");

    public final StringPath definition = createString("definition");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath region = createString("region");

    public QDepot(String variable) {
        super(Depot.class, forVariable(variable));
    }

    public QDepot(Path<? extends Depot> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDepot(PathMetadata metadata) {
        super(Depot.class, metadata);
    }

}

