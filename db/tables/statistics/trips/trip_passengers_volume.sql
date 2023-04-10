create table "Trip-Passengers volume" (
    trip_id      int primary key check ( trip_id > 0 ),
    passengers_volume smallint not null check ( passengers_volume > 0),

    foreign key (trip_id) references "Trips"
);

create or replace function trip_passengers_check() returns trigger as $$
begin
    if exists (
        select *
        from "Trip-Cargo volume" as TCV
        where new.trip_id = TCV.trip_id
    )
    then raise exception 'This trip_id already uses by "Trip-Cargo volume" table';
    end if;

    if exists (
        select 1
        from "Vehicle-Truck model" as VTruckM,
             "Trips" as T
        where new.trip_id = T.trip_id
            and T.vehicle_id = VTruckM.vehicle_id
    ) or exists (
        select 1
        from "Vehicle-Auxiliary model" as VAM,
             "Trips" as T
        where new.trip_id = T.trip_id
            and T.vehicle_id = VAM.vehicle_id
    )
    then raise exception 'This transport cannot transfer passengers';
    end if;

    if exists (
        select 1
        from "Passenger transport models" as PTM,
             "Buses models" as A,
             "Vehicle-Bus model" as B,
             "Trips" as T
        where new.trip_id = T.trip_id
        and T.vehicle_id = B.vehicle_id
        and B.bus_model_id = A.bus_model_id
        and PTM.model_id = A.bus_model_id
        and PTM.passengers_capacity < new.passengers_volume
    ) or exists (
        select 1
        from "Passenger transport models" as PTM,
             "Cars models" as A,
             "Vehicle-Car model" as B,
             "Trips" as T
        where new.trip_id = T.trip_id
          and T.vehicle_id = B.vehicle_id
          and B.car_model_id = A.car_model_id
          and PTM.model_id = A.car_model_id
          and PTM.passengers_capacity < new.passengers_volume
    ) or exists (
        select 1
        from "Passenger transport models" as PTM,
             "Shuttles models" as A,
             "Vehicle-Shuttle model" as B,
             "Trips" as T
        where new.trip_id = T.trip_id
          and T.vehicle_id = B.vehicle_id
          and B.shuttle_model_id = A.shuttle_model_id
          and PTM.model_id = A.shuttle_model_id
          and PTM.passengers_capacity < new.passengers_volume
    ) or exists (
        select 1
        from "Passenger transport models" as PTM,
             "Cars models" as A,
             "Vehicle-Taxi model" as B,
             "Trips" as T
        where new.trip_id = T.trip_id
          and T.vehicle_id = B.vehicle_id
          and B.taxi_model_id = A.car_model_id
          and PTM.model_id = A.car_model_id
          and PTM.passengers_capacity < new.passengers_volume
    )
    then raise exception 'Transferred volume bigger than this transport could take';
    end if;

    return new;
end;
$$ language plpgsql;

create trigger trip_passengers_check
before insert or update on "Trip-Passengers volume"
for each row
execute function trip_passengers_check();

insert into "Trip-Passengers volume" (trip_id, passengers_volume)
values (10, 5),
       (11, 5);

