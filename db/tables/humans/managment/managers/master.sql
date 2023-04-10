create table "Masters" (
    human_id     int primary key check ( human_id > 0 ),
    brigadier_id int not null check ( brigadier_id > 0 ),

    foreign key (brigadier_id) references "Brigadier",
    foreign key (human_id)     references "Humans"
);

create or replace function master_check() returns trigger as $$
begin
    if exists (
        select 1
        from "Workers" as W,
             "Brigadier" as B,
             "District chief" as DC,
             "Department chief" as DepC
        where (new.human_id = W.human_id)
           or  (new.human_id = B.human_id)
           or  (new.human_id = DC.human_id)
           or  (new.human_id = DepC.human_id)
    ) then
        raise exception 'Master can be managed by himself';
    end if;
    return new;
end;
$$ language plpgsql;

create trigger hierarchy_check
    before insert on "Masters"
    for each row
execute function master_check();