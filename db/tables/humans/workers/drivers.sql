create table "Drivers" (
                           worker_id int primary key check ( worker_id > 0 ),

                           foreign key (worker_id) references "Workers"
);

create table "Drivers-Vehicles" (
    driver_id int not null check ( driver_id > 0 ),
    vehicle_id int not null check (vehicle_id > 0),

    primary key (driver_id, vehicle_id),

    foreign key (driver_id) references "Drivers",
    foreign key (vehicle_id) references "Vehicle"
);
