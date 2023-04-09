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

create trigger is_already_mapped_to_vehicle_type
    before insert on "Vehicle-Auxiliary model"
    for each row
execute function is_already_mapped_to_vehicle_type();

insert into "Auxiliary models" (model_name, description)
values ('ГАЗ-33081 «Спасатель»', 'Пожарная машина'),
       ('ГАЗ-33081 «Пожарная лестница»', 'Пожарная машина'),
       ('ГАЗ-33081 «Пожарный автомобиль»', 'Пожарная машина');

 insert into "Vehicle-Auxiliary model" (vehicle_id, auxiliary_id)
 values (3, 1),
        (4, 2),
        (5, 1),
        (6, 3);
