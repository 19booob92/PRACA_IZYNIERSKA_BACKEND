create database webtesty;

create table users (    username varchar(50) not null primary key,    password varchar(255) not null,    enabled boolean not null) engine = InnoDb;
create table authorities (    username varchar(50) not null,    authority varchar(50) not null,    foreign key (username) references users (username),    unique index authorities_idx_1 (username, authority)) engine = InnoDb;

create uesr 'lector@' identified by 'webtesty';

insert into users values('admin', '$2a$10$sA20DyzGnrgduw6aZYEfRuwkgn3emue6OnCol/C7o07IGJ1j.c9LO', true);
insert into authorities values ('admin', 'ADMIN');
