create table if not exists subscribers (
                                           id serial primary key,
                                           reference text unique default gen_random_uuid(),
                                           name varchar(255)
    );

insert into subscribers (name) values ('Tex_carat') , ('yang') , ('yin');


