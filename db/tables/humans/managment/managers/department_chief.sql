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
        from "Workers" as W,
             "Masters" as M,
             "Brigadier" as B,
             "District chief" as DC
        where (new.human_id = W.human_id)
           or  (new.human_id = M.human_id)
           or  (new.human_id = B.human_id)
           or  (new.human_id = DC.human_id)
    ) then
        raise exception 'Department chief can be managed by himself/herself';
    end if;
    return new;
end;
$$ language plpgsql;

create trigger hierarchy_check
    before insert on "Department chief"
    for each row
execute function department_chief_check();