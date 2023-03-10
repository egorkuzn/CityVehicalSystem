create table "Taxis models" (
    model_id            serial primary key,
    model_name          text not null check ( length(model_name) > 0 )
);

create table "Vehicle-Taxi model" (
    vehicle_id int primary key check ( vehicle_id > 0 ),
    taxi_id int not null check ( taxi_id > 0 ),

    foreign key (vehicle_id) references "Passengers transport",
    foreign key (taxi_id)    references "Taxis models"
);