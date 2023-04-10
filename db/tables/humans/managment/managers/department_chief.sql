create table "Department chief" (
    human_id             int primary key check ( human_id > 0 ),
    district_chef_id     int not null check ( district_chef_id > 0 ),
    department_id        int not null check ( department_id > 0 ),

    foreign key (human_id)         references "Humans",
    foreign key (district_chef_id) references "District chief",
    foreign key (department_id)    references "Department"
);

create or replace function department_chief_check() returns trigger as $$
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
        from "District chief" as DC
        where new.human_id = DC.human_id
    ) then
        raise exception 'District chief can be managed by himself/herself';
    end if;
    return new;
end;
$$ language plpgsql;

create trigger hierarchy_check
before insert or update on "Department chief"
for each row
execute function department_chief_check();

insert into "Department chief" (human_id, district_chef_id, department_id)
values (27, 22, 1),
       (31, 26, 5)