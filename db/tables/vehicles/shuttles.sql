create table "Shuttles models" (
    shuttle_id         serial primary key,
    model_name         text not null check ( length(model_name) > 0 )
);

create table "Vehicle-Shuttle model" (
    vehicle_id int primary key check ( vehicle_id > 0 ),
    shuttle_id int not null check ( shuttle_id > 0 ),
    route_id   int not null check ( route_id > 0 ),

    foreign key (vehicle_id) references "Passengers transport",
    foreign key (shuttle_id) references "Shuttles models",
    foreign key (route_id)   references "Routes"
);

create trigger is_already_mapped_to_vehicle_type
    before insert on "Vehicle-Shuttle model"
    for each row
execute function is_already_mapped_to_vehicle_type();