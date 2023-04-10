create table "Brigadier" (
    human_id     int primary key check ( human_id > 0 ),
    brigade_id   int not null check ( brigade_id > 0 ),

    foreign key (human_id)   references "Humans",
    foreign key (brigade_id) references "Brigades"
);

create or replace function brigadier_check() returns trigger as $$
begin
    if exists (
        select
        from "Brigadier" as B
        where (new.brigade_id = B.brigade_id)
    ) or exists (
        select 1
        from "Workers" as W
        where new.human_id = W.human_id
    ) or exists (
        select 1
        from "Masters" as M
        where new.human_id = M.human_id
    ) or exists (
        select 1
        from "District chief" as DC
        where new.human_id = DC.human_id
    ) or exists (
        select 1
        from "Department chief" as DepC
        where new.human_id = DepC.human_id
    )
        then
        raise exception 'Brigadier can be managed by himself/herself';
    end if;
    return new;
end;
$$ language plpgsql;

create trigger hierarchy_check
before insert or update on "Brigadier"
for each row
execute function brigadier_check();

insert into "Brigadier" (human_id, brigade_id)
values (13, 1),
       (14, 2),
       (15, 3),
       (16, 4);

