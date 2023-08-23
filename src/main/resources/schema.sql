create table user
(
    id       int auto_increment
        primary key,
    login    varchar(10)  not null,
    password varchar(100) not null,
    email    varchar(20)  not null
);

create table roles
(
    id   int         not null
        primary key,
    name varchar(50) not null
);

create table user_roles
(
    user_id int not null,
    role_id int not null,
    primary key (user_id, role_id),
    constraint user_roles_ibfk_1
        foreign key (user_id) references user (id),
    constraint user_roles_ibfk_2
        foreign key (role_id) references roles (id)
);

create table post
(
    id      int auto_increment
        primary key,
    message varchar(100) null,
    user_id int          null,
    constraint post_user__fk
        foreign key (user_id) references user (id) ON DELETE CASCADE
);

create table message
(
    id       int auto_increment
        primary key,
    message  varchar(100) null,
    userfrom int          null,
    userto   int          null,
    constraint message_user_id_fk
        foreign key (userfrom) references user (id),
    constraint message_user_id_fk_2
        foreign key (userto) references user (id)
);

create table friendship
(
    id        int auto_increment
        primary key,
    user_id   int null,
    friend_id int null,
    constraint constraint_name
        unique (user_id, friend_id),
    constraint friend_user_id_fk
        foreign key (user_id) references user (id)
            on delete cascade,
    constraint friend_user_id_fk_2
        foreign key (friend_id) references user (id)
            on delete cascade
);

create table follower
(
    id          int auto_increment
        primary key,
    user_id     int null,
    follower_id int null,
    constraint constraint_name
        unique (user_id, follower_id),
    constraint follower_user_id_fk
        foreign key (user_id) references user (id)
            on delete cascade,
    constraint follower_user_id_fk_2
        foreign key (follower_id) references user (id)
            on delete cascade
);

create table invite
(
    id       int auto_increment
        primary key,
    userfrom int null,
    userto   int null,

    constraint invite_user_id_fk_2
        foreign key (userto) references user (id)
            on delete cascade,
    constraint invite_user_id_fk
        foreign key (userfrom) references user (id)
            on delete cascade
);