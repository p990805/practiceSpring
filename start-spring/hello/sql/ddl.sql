drop table if exists member CASCADE;
create table member
(
    id bigint generated bt default as identity,
    name varchar(255),
    primary key (id)
);