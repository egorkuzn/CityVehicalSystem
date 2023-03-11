create table "Vehicle" (
    vehicle_id serial primary key,
    garage_id  int not null check ( garage_id > 0 ),
    driver_id  int not null check ( driver_id > 0 ),
    year       smallint not null check ( year <= date_part('year', CURRENT_DATE) AND year >= 1930 ),
    -- True is active
    -- False is archived
    status        boolean not null,
    -- When become active
    add_year   smallint not null check ( add_year <= date_part('year', CURRENT_DATE) AND add_year >= 1930 ),
    -- When become archived
    archive_year  smallint not null check ( (NOT status)
                                    AND (archive_year <= date_part('year', CURRENT_DATE) AND archive_year >= 1930)
                                    AND (add_year <= archive_year) OR status) DEFAULT -1,

    foreign key (garage_id) references "Garages",
    foreign key (driver_id) references "Drivers"
);