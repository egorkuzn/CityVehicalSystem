create table "Trip-Cargo volume" (
    trip_id      int primary key check ( trip_id > 0 ),
    cargo_volume smallint not null check ( cargo_volume > 0),

    foreign key (trip_id) references "Trips"
);

insert into "Trips" (vehicle_id, distance)
values (1, 20),
       (2, 19),
       (3, 18),
       (4, 17),
       (5, 16),
       (6, 15),
       (7, 14),
       (8, 13),
       (9, 12),
       (10, 11),
       (11, 12),
       (12, 13),
       (13, 14),
       (14, 15),
       (15, 15),
       (16, 16),
       (17, 17);

create or replace function trip_cargo_check() returns trigger as $$
begin
    if exists (
        select *
        from "Trip-Passengers volume" as TPV
        where new.trip_id = TPV.trip_id
    )
    then raise exception 'This trip_id already uses by "Trip-Passengers volume" table';
    end if;

    if not exists(
        select 1
        from "Vehicle-Truck model" as VTM,
             "Trips" as T
        where new.trip_id = T.trip_id
            and T.vehicle_id = VTM.vehicle_id
    )
    then raise exception 'This transport cannot transfer cargo';
    end if;

    if (
        select TM.cargo_capacity
        from "Vehicle-Truck model" as VTM,
             "Trucks models" as TM,
             "Trips" as T
        where new.trip_id = T.trip_id
        and T.vehicle_id = VTM.vehicle_id
        and VTM.truck_id = TM.truck_model_id
    ) < new.cargo_volume
    then raise exception 'Transferred volume bigger than this truck could take';
    end if;

    return new;
end;
$$ language plpgsql;

create trigger trip_cargo_check
before insert or update on "Trip-Cargo volume"
for each row
execute function trip_cargo_check();

insert into "Trip-Cargo volume" (trip_id, cargo_volume)
values (1, 20),
       (2, 20);






