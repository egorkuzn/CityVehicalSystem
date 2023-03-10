create table "Trip-Cargo volume" (
    trip_id      int not null check ( trip_id > 0 ),
    cargo_volume smallint not null check ( cargo_volume > 0),

    foreign key (cargo_volume) references "Trips"
);

