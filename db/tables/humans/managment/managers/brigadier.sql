create table "Brigadier" (
    human_id     int primary key check ( human_id > 0 ),
    brigade_id   int not null check ( brigade_id > 0 ),

    foreign key (human_id)   references "Humans",
    foreign key (brigade_id) references "Brigades"
);

create or replace function brigadier_check() returns trigger as $$
begin
    if exists (
        select 1
        from "Workers" as W,
            "Masters" as M,
            "District chief" as DC,
            "Department chief" as DepC
        where (new.human_id = W.human_id)
        or  (new.human_id = M.human_id)
        or  (new.human_id = DC.human_id)
        or  (new.human_id = DepC.human_id)
    ) then
        raise exception 'Brigadier can be managed by himself/herself';
    end if;
    return new;
end;
$$ language plpgsql;

create trigger hierarchy_check
before insert on "Brigadier"
for each row
execute function brigadier_check();
