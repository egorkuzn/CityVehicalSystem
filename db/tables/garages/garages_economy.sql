create table "Garages economy" (
    garage_economy_id serial primary key
);

alter table "Garages economy"
    add street_name varchar(255);

update "Garages economy" set street_name=0 where street_name is null;

alter table "Garages economy"
    alter column street_name set not null,
    add constraint street_name check( length(street_name) > 0 );

alter table "Garages economy"
    add house_number smallint,
    alter column house_number set not null,
    add constraint house_number check( house_number > 0 );

alter table "Garages economy"
    add after_fraction smallint,
    add letter char;
-- Checks for russian char
alter table "Garages economy"
    add constraint letter check (letter >= 'А'and letter <= 'Я');





