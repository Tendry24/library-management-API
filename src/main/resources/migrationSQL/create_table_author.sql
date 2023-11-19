create table if not exists author (
                                      id serial primary key,
                                      name varchar(250) not null,
                                      gender char check ( gender = 'M' or gender = 'F' )
    );

insert into author(name,gender) values ('Jean' , 'M'),('Lara' , 'F'),('Yuu','F');