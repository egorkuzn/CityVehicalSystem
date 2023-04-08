create table "Cars models" (
    model_id   serial primary key,
    model_name text not null check ( length(model_name) > 0 )
);

create table "Vehicle-Car model" (
    vehicle_id int primary key check ( vehicle_id > 0 ),
    car_id     int not null check ( car_id > 0 ),

    foreign key (vehicle_id) references "Passengers transport",
    foreign key (car_id)     references "Cars models"
);

insert into "Cars models" (model_name)
values ('Toyota Corolla'),
       ('Honda Civic'),
       ('Ford F-Series'),
       ('Chevrolet Silverado'),
       ('Toyota Camry'),
       ('Honda Accord'),
       ('Nissan Altima'),
       ('Ford Fusion');

create trigger is_already_mapped_to_vehicle_type
before insert on "Vehicle-Car model"
for each row execute function is_already_mapped_to_vehicle_type();

insert into "Vehicle-Car model" (vehicle_id, car_id)
values (1,1);