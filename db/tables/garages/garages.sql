create table "Garages" (
    garage_id int primary key check ( garage_id > 0 ),

    foreign key (garage_id) references "Garages economy"
);

insert into "Garages economy" (street_name, house_number)
values ('Сакко и Ванцетти', 108);

insert into "Garages economy" (street_name, house_number, after_fraction)
values ('Военная', 8, 5);

insert into "Garages economy" (street_name, house_number, letter)
values ('Театральная', 1, 'А');

insert into "Garages" (garage_id)
values (1), (2), (5);