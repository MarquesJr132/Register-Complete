create table if not exists cliente(
   id text primary key,
   firstname varchar(20) not null check ( length(firstname)>2 ),
    lastname varchar(20) not null ,
    password text not null,
    email varchar unique not null,
    active boolean not null ,
    locked boolean not null,
    role varchar(5) not null
    );
