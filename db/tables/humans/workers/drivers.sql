create table "Drivers" (
                           worker_id int primary key check ( worker_id > 0 ),

                           foreign key (worker_id) references "Workers"
);

create table "Drivers-Vehicles" (
    driver_id int not null check ( driver_id > 0 ),
    vehicle_id int not null check (vehicle_id > 0),

    primary key (driver_id, vehicle_id),

    foreign key (driver_id) references "Drivers",
    foreign key (vehicle_id) references "Vehicle"
);

create or replace function drivers_check() returns trigger as $$
begin
    if exists(
        select 1
        from "Engineers" as E
        where E.engineer_id = new.worker_id
    )
    then
        raise exception 'Driver and engineer one time';
    end if;
    return new;
end;
$$ language plpgsql;

create trigger drivers_check
before insert or update on "Drivers"
for each row
execute function drivers_check();

insert into "Drivers" (worker_id)
values (6),
       (7),
       (8),
       (9);