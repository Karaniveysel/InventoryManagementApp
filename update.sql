
    create table category (
       id bigint not null auto_increment,
        definition varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table category_aud (
       id bigint not null,
        rev integer not null,
        revtype tinyint,
        definition varchar(255),
        primary key (id, rev)
    ) engine=InnoDB

    create table depot (
       id bigint not null auto_increment,
        city varchar(255),
        address varchar(255),
        definition varchar(255),
        region varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table depot_aud (
       id bigint not null,
        rev integer not null,
        revtype tinyint,
        city varchar(255),
        address varchar(255),
        definition varchar(255),
        region varchar(255),
        primary key (id, rev)
    ) engine=InnoDB

    create table product (
       id bigint not null auto_increment,
        definition varchar(255),
        status varchar(255),
        threshold varchar(255),
        category_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table product_aud (
       id bigint not null,
        rev integer not null,
        revtype tinyint,
        definition varchar(255),
        status varchar(255),
        threshold varchar(255),
        category_id bigint,
        primary key (id, rev)
    ) engine=InnoDB

    create table productsindepot (
       id bigint not null auto_increment,
        quantity bigint,
        depot_id bigint,
        product_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table productsindepot_aud (
       id bigint not null,
        rev integer not null,
        revtype tinyint,
        quantity bigint,
        depot_id bigint,
        product_id bigint,
        primary key (id, rev)
    ) engine=InnoDB

    create table revinfo (
       rev integer not null auto_increment,
        revtstmp bigint,
        primary key (rev)
    ) engine=InnoDB

    alter table category_aud 
       add constraint FKc9m640crhsib2ws80um6xuk1w 
       foreign key (rev) 
       references revinfo (rev)

    alter table depot_aud 
       add constraint FKrx6ugb6fxpl06lehripnwbdim 
       foreign key (rev) 
       references revinfo (rev)

    alter table product 
       add constraint FK1mtsbur82frn64de7balymq9s 
       foreign key (category_id) 
       references category (id)

    alter table product_aud 
       add constraint FK9vwllld6jlw5xys1ay911oh1x 
       foreign key (rev) 
       references revinfo (rev)

    alter table productsindepot 
       add constraint FK4y500xhdh2lx4jg3wc3lo11h5 
       foreign key (depot_id) 
       references depot (id)

    alter table productsindepot 
       add constraint FKeftom2b59w5668ewo316sdsw3 
       foreign key (product_id) 
       references product (id)

    alter table productsindepot_aud 
       add constraint FKlvnmesagq9va1tbj1tswv5fiq 
       foreign key (rev) 
       references revinfo (rev)
