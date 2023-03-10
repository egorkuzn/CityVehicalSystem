create table "Humans" (
    human_id   serial primary key,
    firstname  varchar(35) not null check ( length(firstname) > 0 ),
    surname    varchar(35) not null check ( length(surname) > 0 ),
    fathername varchar(70)
);