create table "Boxes" (
    box_id int primary key check ( box_id > 0 ),

    foreign key (box_id) references "Garages economy"
);