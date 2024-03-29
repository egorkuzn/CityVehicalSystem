create table "Repairs" (
    repair_id     serial primary key,
    vehicle_id    int not null check (vehicle_id > 0),
    description   text not null check ( length(description) > 0 ),
    when_started  date not null check ( when_started <= CURRENT_DATE ),
    when_finished date not null check ( when_started <= when_finished ),
    price         money not null check ( price::numeric::float8 > 0.0 ),

    foreign key (vehicle_id) references "Vehicle"
);

insert into "Repairs" (vehicle_id, description, when_started, when_finished, price)
values (1, 'Замена двигателя', '2022-05-11', '2022-06-11', 500);

insert into "Repairs" (vehicle_id, description, when_started, when_finished, price)
values (1, 'Замена масла', '2023-02-11', '2023-02-11', 20);