create table "Shuttles models" (
    shuttle_model_id   int primary key check ( shuttle_model_id > 0 ),
    model_name         text not null check ( length(model_name) > 0 ),

    foreign key ( shuttle_model_id ) references "Passenger transport models"
);

create table "Vehicle-Shuttle model" (
    vehicle_id       int primary key check ( vehicle_id > 0 ),
    shuttle_model_id int not null check ( shuttle_model_id > 0 ),
    route_id         int not null check ( route_id > 0 ),

    foreign key (vehicle_id)       references "Vehicle",
    foreign key (shuttle_model_id) references "Shuttles models",
    foreign key (route_id)         references "Routes"
);

create trigger is_already_mapped_to_vehicle_type
    before insert on "Vehicle-Shuttle model"
    for each row
execute function is_already_mapped_to_vehicle_type();

insert into "Passenger transport models" (passengers_capacity)
values (18),
       (19),
       (32),
       (19),
       (31),
       (22),
       (40);

insert into "Shuttles models" (shuttle_model_id, model_name)
values (11, 'Ford Transit'),
       (12, 'Mercedes-Benz Sprinter'),
       (13, 'ЗИС-155, 60'),
       (14, 'Iveco Daily 50C15CV'),
       (15, 'Iveco Bus Daily MIDIBUS'),
       (16, 'Mercedes-Benz Sprinter City 45'),
       (17, 'Mercedes-Benz Sprinter City 77');
