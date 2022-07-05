package com.example.services.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProductsInDepot is a Querydsl query type for ProductsInDepot
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProductsInDepot extends EntityPathBase<ProductsInDepot> {

    private static final long serialVersionUID = -231766657L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProductsInDepot productsInDepot = new QProductsInDepot("productsInDepot");

    public final QDepot depot;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QProduct product;

    public final NumberPath<Long> quantity = createNumber("quantity", Long.class);

    public QProductsInDepot(String variable) {
        this(ProductsInDepot.class, forVariable(variable), INITS);
    }

    public QProductsInDepot(Path<? extends ProductsInDepot> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProductsInDepot(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProductsInDepot(PathMetadata metadata, PathInits inits) {
        this(ProductsInDepot.class, metadata, inits);
    }

    public QProductsInDepot(Class<? extends ProductsInDepot> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.depot = inits.isInitialized("depot") ? new QDepot(forProperty("depot")) : null;
        this.product = inits.isInitialized("product") ? new QProduct(forProperty("product"), inits.get("product")) : null;
    }

}

