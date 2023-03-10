create table "Garages" (
    garage_id int primary key check ( garage_id > 0 ),

    foreign key (garage_id) references "Garages economy"
);
