create table "Passenger transport models" (
    model_id            serial primary key,
    passengers_capacity smallint not null check ( passengers_capacity > 0 )
);

values ()