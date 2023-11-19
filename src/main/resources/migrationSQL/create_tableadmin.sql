create table if not exists "admin" (
                                       id serial primary key,
                                       email varchar(255) not null,
    name varchar(255),
    password varchar(250)
    );

insert into  "admin" values ('Tendry@gmail.com','Tendry','123478') , ('Aro@gmail.com','Aro','456789'),
                            ('Fy@gmail.com','Fy','456123');