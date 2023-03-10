create table "Engines" (
    engines_id int primary key check ( engines_id > 0 ),

    foreign key (engines_id) references "Details"
);