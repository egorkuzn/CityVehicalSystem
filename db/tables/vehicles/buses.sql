create table "Buses models" (
    bus_id             serial primary key,
    model_name         text not null check ( length(model_name) > 0 )
);

create table "Vehicle-Bus model" (
    vehicle_id int primary key check ( vehicle_id > 0 ),
    bus_id     int not null check ( bus_id > 0 ),
    route_id   int not null check ( route_id > 0 ),

    foreign key (vehicle_id) references "Passengers transport",
    foreign key (bus_id)     references "Buses models",
    foreign key (route_id)   references "Routes"
);

create trigger is_already_mapped_to_vehicle_type
    before insert on "Vehicle-Bus model"
    for each row
execute function is_already_mapped_to_vehicle_type();