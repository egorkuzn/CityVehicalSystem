create table "Auxiliary models" (
      model_id    serial primary key,
      model_name  text not null check ( length(model_name) > 0 ),
      description text not null check ( length(description) > 0 )
);

create table "Vehicle-Auxiliary model" (
    vehicle_id   int primary key check ( vehicle_id > 0 ),
    auxiliary_id int not null check ( auxiliary_id > 0 ),

    foreign key (vehicle_id)   references "Vehicle",
    foreign key (auxiliary_id) references "Auxiliary models"
);