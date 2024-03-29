create table "Trips" (
    trip_id             serial primary key,
    vehicle_id          int not null check (vehicle_id > 0),
    distance            int not null check (distance > 0),
    trip_date           date not null,

    foreign key (vehicle_id) references "Vehicle"
);