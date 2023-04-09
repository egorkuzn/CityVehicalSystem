create table "Cars models" (
    model_id   int  primary key check ( model_id > 0 ),
    model_name text not null check ( length(model_name) > 0 ),

    foreign key (model_id) references "Passenger transport models"
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

insert into "Vehicle-Car model" (vehicle_id, car_model_id)
values (1,1);