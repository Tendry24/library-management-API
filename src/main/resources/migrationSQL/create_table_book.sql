create type Topic AS ENUM ( 'ROMANCE', 'COMEDY', 'OTHER' );

create table if not exists book (
                                    id serial primary key,
                                    bookName text,
                                    pageNumbers int,
                                    topic Topic not null,
                                    authorId int references author(id),
                                    releaseDate timestamp
    );

INSERT INTO book (bookName, pageNumbers, topic, authorId, releaseDate)
VALUES
    ('The Great Gatsby', 300, 'ROMANCE', 1, '2022-01-01 13:59'),
    ('The Hitchhiker''s Guide to the Galaxy', 200, 'COMEDY', 2, '2022-02-15 13:00'),
    ('The Hobbit', 400, 'OTHER', 3, '2022-03-30 16:57');