create table "Buses models" (
    bus_model_id       int primary key check ( bus_model_id > 0 ),
    model_name         text not null check ( length(model_name) > 0 ),

    foreign key (bus_model_id) references "Passenger transport models"
);

create table "Vehicle-Bus model" (
    vehicle_id int primary key check ( vehicle_id > 0 ),
    bus_model_id     int not null check ( bus_model_id > 0 ),
    route_id   int not null check ( route_id > 0 ),

    foreign key (vehicle_id)   references "Vehicle",
    foreign key (bus_model_id) references "Buses models",
    foreign key (route_id)     references "Routes"
);

create trigger is_already_mapped_to_vehicle_type
    before insert on "Vehicle-Bus model"
    for each row
execute function is_already_mapped_to_vehicle_type();