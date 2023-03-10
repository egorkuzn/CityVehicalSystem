create table "Routes" (
    route_id   serial primary key,
    distance   smallint not null check ( distance > 0 ),
    route_name text not null check ( length(route_name) > 0 )
);