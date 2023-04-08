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
);

insert into "Trucks models" (model_name, cargo_capacity)
values ('Volvo VNL 760', 20),
       ('Scania R730', 25),
       ('Mercedes-Benz Actros 1863', 18),
       ('DAF XF 530', 25),
       ('Iveco Stralis XP 570', 20),
       ('Renault T High 520', 25),
       ('MAN TGX 18.680', 18),
       ('Peterbilt Model 389 Pride & Class Edition', 20),
       ('International LoneStar', 20);

create trigger is_already_mapped_to_vehicle_type
before insert on "Vehicle-Truck model"
for each row
execute function is_already_mapped_to_vehicle_type();

insert into "Vehicle-Truck model" (vehicle_id, truck_id)
values  (1,1),
        (2, 1);


