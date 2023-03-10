create table "Trip-Passengers volume" (
    trip_id      int primary key check ( trip_id > 0 ),
    passengers_volume smallint not null check ( passengers_volume > 0),

    foreign key (passengers_volume) references "Trips"
);