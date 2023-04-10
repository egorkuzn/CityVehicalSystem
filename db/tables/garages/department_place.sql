create table "Department place" (
    department_place_id int primary key check ( department_id > 0 ),
    department_id       int not null check ( department_id > 0 ),

    foreign key (department_place_id) references "Garages economy",
    foreign key (department_id)       references "Department"
);

insert into "Garages economy" (street_name, house_number)
values
('Ленина', '12'),
('Советская', '25'),
('Пушкина', '7'),
('Гагарина', '34'),
('Мира', '15');

insert into "Department place" (department_place_id, department_id)
values (6, 8),
       (7, 9),
       (8, 10),
       (9, 11),
       (10, 12);