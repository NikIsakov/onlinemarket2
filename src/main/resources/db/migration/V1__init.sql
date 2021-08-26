create table products (
    id                      bigserial primary key,
    title                   varchar(255),
    price                   int,
    created_at              timestamp default current_timestamp,
    updated_at              timestamp default current_timestamp,
    cart_id                 integer
        references          cart
);

insert into products (title, price)
values
('Масло черного тмина 500 мл', 1890),
('Спирулина 500г', 2300),
('Масло Гхи 570г', 650),
('Нейролецитин', 1950),
('Лецитин соевый', 890),
('Ликоподий 70г', 1025),
('Cheese7', 327),
('Cheese8', 328),
('Cheese9', 328),
('Cheese10', 328),
('Cheese11', 328),
('Cheese12', 328),
('Cheese13', 328),
('Cheese14', 328),
('Cheese15', 328);

create table role_table
(
    id   serial      not null
        constraint role_table_pk
            primary key,
    name varchar(20) not null
);

create table user_table
(
    id       serial not null
        constraint user_table_pk
            primary key,
    login    varchar(50),
    password varchar(500),
    role_id  integer
        constraint user_table_role_table_id_fk
            references role_table
);

create
unique index user_table_login_uindex
    on user_table (login);

insert into role_table(name) values ('ROLE_ADMIN');
insert into role_table(name) values ('ROLE_USER');

create table blog (
id                      bigserial primary key,
title                   varchar(255),
description             text,
);

create table cart (
id                      bigserial primary key,
countItem               integer,
);

create table category (
id                      bigserial primary key,
title                   varchar(255),
);

CREATE TABLE product_category (
    product_id integer REFERENCES products (id),
    category_id integer REFERENCES category (id)
);


create table discount (
id                      bigserial primary key,
value                   integer,
);

CREATE TABLE product_discount (
    product_id integer REFERENCES products (id),
    discount_id integer REFERENCES discount (id)
);

CREATE TABLE category_discount (
    category_id integer REFERENCES category (id),
    discount_id integer REFERENCES discount (id)
);

create table order (
id                      bigserial primary key,
username                varchar(255),
orderItems_id integer REFERENCES orderitems (id),
user_table_id integer REFERENCES user_table (id)
);

create table orderitems (
id                      bigserial primary key,
product                 varchar(255),
count                   integer,
);

CREATE TABLE product_orderItems (
    product_id integer REFERENCES products (id),
    orderItems_id integer REFERENCES orderItems (id)
);