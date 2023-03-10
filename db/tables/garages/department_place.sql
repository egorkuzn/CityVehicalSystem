create table "Department place" (
    department_place_id int primary key check ( department_id > 0 ),
    department_id       int not null check ( department_id > 0 ),

    foreign key (department_place_id) references "Garages economy",
    foreign key (department_id)       references "Department"
);