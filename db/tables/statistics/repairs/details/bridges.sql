create table "Bridges" (
    bridge_id int primary key check ( bridge_id > 0 ),

    foreign key (bridge_id) references "Details"
);