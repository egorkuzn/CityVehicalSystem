create table "Vehicle" (
    vehicle_id serial primary key,
    garage_id  int not null check ( garage_id > 0 ),
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

    foreign key (garage_id) references "Garages"
);

alter table "Vehicle"
drop archive_year,
drop status;

alter table "Vehicle"
add archive_year smallint,
add constraint archive_year check (
    archive_year <= date_part('year', CURRENT_DATE)
        and (add_year <= archive_year)
);

alter table "Vehicle"
drop constraint "Vehicle_add_year_check",
add constraint add_year check (
    add_year <= date_part('year', CURRENT_DATE)
        and (year <= add_year)
);

insert into "Vehicle" (garage_id, year, add_year)
values (1, 2002, 2002),
       (1, 2003, 2008);

update "Vehicle"
set archive_year = 2022
where year <= 2007;

insert into "Vehicle" (garage_id, year, add_year)
values (5, 2021, 2021),
       (2, 2020, 2020),
       (2, 2010, 2015),
       (1, 2011, 2011);



