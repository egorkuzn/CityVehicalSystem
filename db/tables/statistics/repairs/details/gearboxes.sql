create table "Gearboxes" (
    gearboxes_id int primary key check ( gearboxes_id > 0 ),

    foreign key (gearboxes_id) references "Details"
);