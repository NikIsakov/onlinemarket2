create table products (
    id                      bigserial primary key,
    title                   varchar(255),
    price                   int,
    created_at              timestamp default current_timestamp,
    updated_at              timestamp default current_timestamp
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