create table "Engineer specialisation" (
    specialisation_id serial primary key,
    description       text not null check ( length(description) > 0 )
);

create table "Engineers" (
    engineer_id         int primary key check ( engineer_id > 0 ),
    specialisation_id   int not null check ( specialisation_id > 0 ),

    foreign key (engineer_id) references "Workers",
    foreign key (specialisation_id) references "Engineer specialisation"
);

insert into "Engineer specialisation" (description)
values ('Техник'),
       ('Сварщик'),
       ('Слесарь'),
       ('Сборщик');

create or replace function engineers_check() returns trigger as $$
begin
    if exists(
        select 1
        from "Drivers" as D
        where D.worker_id = new.engineer_id
    )
    then
        raise exception 'Driver and engineer one time';
    end if;
    return new;
end;
$$ language plpgsql;

create trigger engineers_check
before insert or update on "Engineers"
for each row
execute function engineers_check();

insert into "Engineers" (engineer_id, specialisation_id)
values (1, 1),
       (2, 2),
       (3, 3),
       (4, 4),
       (5, 1);