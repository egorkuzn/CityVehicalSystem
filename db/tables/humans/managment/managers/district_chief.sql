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
        from "Workers" as W,
             "Masters" as M,
             "Brigadier" as B,
             "Department chief" as DC
        where (new.human_id = W.human_id)
           or  (new.human_id = M.human_id)
           or  (new.human_id = B.human_id)
           or  (new.human_id = DC.human_id)
    ) then
        raise exception 'District chief can be managed by himself/herself';
    end if;
    return new;
end;
$$ language plpgsql;

create trigger hierarchy_check
    before insert on "District chief"
    for each row
execute function district_chief_check();