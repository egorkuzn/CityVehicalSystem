create table "Vehicle-Taxi model" (
    vehicle_id    int primary key check ( vehicle_id > 0 ),
    taxi_model_id int not null check ( taxi_model_id > 0 ),

    foreign key (vehicle_id)    references "Vehicle",
    foreign key (taxi_model_id) references "Cars models"
);

create trigger is_already_mapped_to_vehicle_type
    before insert on "Vehicle-Taxi model"
    for each row
execute function is_already_mapped_to_vehicle_type();