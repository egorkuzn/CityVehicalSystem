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