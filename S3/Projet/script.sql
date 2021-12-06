create table users(
    id integer primary key,
    username varchar(255),
    password varchar(255),
    firstname varchar(255),
    lastname varchar(255),
    id_group int
);

create table usergroups(
    id integer primary key,
    name varchar(255)
);

create table reservations(
    id integer primary key,
    start timestamp,
    end timestamp,
    ongoing boolean,
    username varchar(255),
    id_room integer
);

create table rooms(
    id integer primary key,
    name varchar(255),
    capacity integer,
    isAvailable boolean,
    type varchar(255)
);

create table devicetypes(
    id integer primary key,
    name varchar(255),
    attributes json
);

create table defaultdevices(
    id integer primary key,
    name varchar(255),
    parameters json,
    ison boolean,
    id_type integer,
    id_room integer
);

create table reservationsdevices(
    id integer primary key,
    name varchar(255),
    parameters json,
    ison boolean,
    id_type integer,
    id_room integer,
    id_reservation integer
);

create table messages(
    id integer primary key,
    sender varchar(255),
    receiver varchar(255),
    body text,
    send_date timestamp
);

alter table users add
    foreign key (id_group) references usergroups(id);

alter table reservations add
    foreign key (username) references users(username),
    foreign key (id_room) references rooms(id);

alter table defaultdevices add
    foreign key (id_type) references devicetypes(id),
    foreign key (id_room) references rooms(id);

alter table reservationsdevices add
    foreign key (id_type) references devicetypes(id),
    foreign key (id_room) references rooms(id),
    foreign key (id_reservation) references reservations(id);

alter table messages add
    foreign key (sender) references users(username),
    foreign key (receiver) references users(username);
