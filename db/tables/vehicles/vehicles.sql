create table "Vehicle" (
    vehicle_id serial primary key,
    garage_id  int not null check ( garage_id > 0 ),
    driver_id  int not null check ( driver_id > 0 ),
    year       smallint not null check ( year <= date_part('year', CURRENT_DATE) AND year >= 1930 ),

    foreign key (garage_id) references "Garages",
    foreign key (driver_id) references "Drivers"
);