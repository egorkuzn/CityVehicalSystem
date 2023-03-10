create table "Passengers transport" (
    vehicle_id int primary key check ( vehicle_id > 0 ),
    passengers_capacity smallint not null check ( passengers_capacity > 0 ),

    foreign key (vehicle_id) references "Vehicle"
);