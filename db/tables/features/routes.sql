create table "Routes" (
    route_id   serial primary key,
    distance   smallint not null check ( distance > 0 ),
    route_name text not null check ( length(route_name) > 0 )
);

insert into "Routes" (distance, route_name)
values (19, 'Маршрутка 13. Учительская-Вокзал Новосибрск-Главный'),
       (31, 'Маршрутка 14. Цветущая плющиха-ТЭЦ 5')