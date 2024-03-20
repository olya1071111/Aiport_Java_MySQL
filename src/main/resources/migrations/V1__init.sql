create table user
(
    id     int          not null primary key auto_increment,
    name   varchar(256) not null,
    job    varchar(256)
);

create table plane
(
    id     int          not null primary key auto_increment,
    number   varchar(256) not null
);

create table city
(
    id     int          not null primary key auto_increment,
    name   varchar(256) not null
);

create table airport
(
    id     int          not null primary key auto_increment,
    name   varchar(256) not null,
    city_id int,
    CONSTRAINT FK_AIRPORT_CITY FOREIGN KEY (city_id) REFERENCES city(id)
);

create table user_plane
(
    id     int          not null primary key auto_increment,
    plane_id int,
    user_id int,
    job varchar(256),
    CONSTRAINT FK_PLANE FOREIGN KEY (plane_id) REFERENCES plane(id),
    CONSTRAINT FK_USER FOREIGN KEY (user_id) REFERENCES user(id)
);

create table route
(
    id     int          not null primary key auto_increment,
    number int,
    arrival_date datetime,
    departure_date datetime,
    arrival_city_id int,
    departure_city_id int,
    route_time time,
    plane_id int,
    stat varchar(256),
    price int,
    CONSTRAINT FK_PLANE_ROUTE FOREIGN KEY (plane_id) REFERENCES plane(id),
    CONSTRAINT FK_ARRIVAL_CITY FOREIGN KEY (arrival_city_id) REFERENCES city(id),
    CONSTRAINT FK_DEPARTURE_CITY FOREIGN KEY (departure_city_id) REFERENCES city(id)
);

create table ticket
(
    id     int          not null primary key auto_increment,
    user_id int,
    route_id int,
    stat varchar(256),
    seat int,
    CONSTRAINT FK_USER_TICKET FOREIGN KEY (user_id) REFERENCES user(id),
    CONSTRAINT FK_ROUTE FOREIGN KEY (route_id) REFERENCES route(id)
);