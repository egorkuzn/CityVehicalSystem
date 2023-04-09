create table "Cars models" (
    car_model_id   int  primary key check ( car_model_id > 0 ),
    model_name text not null check ( length(model_name) > 0 ),

    foreign key (car_model_id) references "Passenger transport models"
);

create table "Vehicle-Car model" (
    vehicle_id       int primary key check ( vehicle_id > 0 ),
    car_model_id     int not null check ( car_model_id > 0 ),

    foreign key (vehicle_id)   references "Vehicle",
    foreign key (car_model_id) references "Cars models"
);

create trigger is_already_mapped_to_vehicle_type
before insert on "Vehicle-Car model"
for each row execute function is_already_mapped_to_vehicle_type();

insert into "Passenger transport models" (passengers_capacity)
values (5),
       (5),
       (5),
       (6),
       (5),
       (5),
       (7),
       (7),
       (5),
       (7);

insert into "Cars models" (car_model_id, model_name)
values (18, 'Toyota Corolla'),
       (19, 'Toyota RAV4'),
       (20, 'Honda CR-V'),
       (21, 'Ford F-150'),
       (22, 'Nissan Sentra'),
       (23, 'Volkswagen Polo'),
       (24, 'Volkswagen Teramont'),
       (25, 'Infiniti QX60'),
       (26, 'Mercedes-Benz E 220 D 4 MATIC All-Terrain'),
       (27, 'Ford Galaxy');

insert into "Vehicle-Car model" (vehicle_id, car_model_id)
values (7, 18),
       (8, 19),
       (9, 20),
       (10, 21);