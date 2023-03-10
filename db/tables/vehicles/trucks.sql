create table "Trucks models" (
    truck_model_id serial primary key,
    model_name     text not null check ( length(model_name) > 0 ),
    cargo_capacity smallint not null check ( cargo_capacity > 0 )
);

create table "Vehicle-Truck model" (
    vehicle_id int primary key check ( vehicle_id > 0 ),
    truck_id   int not null check ( truck_id > 0 ),

    foreign key (vehicle_id) references "Vehicle",
    foreign key (truck_id) references "Trucks models"
)