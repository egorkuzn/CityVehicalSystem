create table "Repairs" (
    repair_id     serial primary key,
    vehicle_id    int not null check (vehicle_id > 0),
    description   text not null check ( length(description) > 0 ),
    when_started  date not null check ( when_started <= CURRENT_DATE ),
    when_finished date not null check ( when_started <= when_finished ),
    price         money not null check ( price::numeric::float8 > 0.0 ),

    foreign key (vehicle_id) references "Vehicle"
);