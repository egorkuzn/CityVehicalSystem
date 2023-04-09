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

insert into "Passenger transport models" (passengers_capacity)
values (108), (90), (100), (40), (22), (75), (160), (110), (50), (75);

insert into "Buses models" (bus_model_id, model_name)
values (1, 'ЛИАЗ-5292.65-03'),
       (2, 'МАЗ-103'),
       (3, 'НЕФАЗ-5299'),
       (4, 'КАВЗ-4238'),
       (5, 'ГАЗель Next Cityline'),
       (6, 'МАЗ-107'),
       (7, 'ЛИАЗ-6213'),
       (8, 'НЕФАЗ-5294'),
       (9, 'КАВЗ-6858'),
       (10, 'Курсор Е433.00');
