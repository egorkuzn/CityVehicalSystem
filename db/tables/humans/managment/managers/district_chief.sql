create table "District chief" (
    human_id    int primary key check ( human_id > 0 ),
    master_id   int not null check ( master_id > 0 ),
    district_id int not null check ( district_id > 0 ),

    foreign key (human_id)    references "Humans",
    foreign key (master_id)   references "Masters",
    foreign key (district_id) references "District"
);

create or replace function district_chief_check() returns trigger as $$
begin
    if exists (
        select 1
        from "Workers" as W
        where new.human_id = W.human_id
    ) or exists (
        select 1
        from "Brigadier" as B
        where new.human_id = B.human_id
    ) or exists (
        select 1
        from "Masters" as M
        where new.human_id = M.human_id
    ) or exists (
        select 1
        from "Department chief" as DepC
        where new.human_id = DepC.human_id
    ) then
        raise exception 'District chief can be managed by himself/herself';
    end if;
    return new;
end;
$$ language plpgsql;

create trigger hierarchy_check
before insert or update on "District chief"
for each row
execute function district_chief_check();

insert into "District chief" (human_id, master_id, district_id)
values (22, 17, 1),
       (23, 18, 2),
       (24, 19, 3),
       (25, 20, 4),
       (26, 21, 5);