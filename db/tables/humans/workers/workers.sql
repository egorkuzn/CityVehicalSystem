create table "Workers" (
    human_id   int primary key check ( human_id > 0 ),
    brigade_id int not null check ( brigade_id > 0 ),

    foreign key (brigade_id) references "Brigades",
    foreign key (human_id)   references "Humans"
);

create or replace function worker_check() returns trigger as $$
begin
    if exists (
        select 1
        from "Masters" as M,
             "Brigadier" as B,
             "District chief" as DC,
             "Department chief" as DepC
        where  (new.human_id = M.human_id)
           or  (new.human_id = B.human_id)
           or  (new.human_id = DC.human_id)
           or  (new.human_id = DepC.human_id)
    ) then
        raise exception 'Worker can be managed by himself/herself';
    end if;
    return new;
end;
$$ language plpgsql;

create trigger hierarchy_check
    before insert on "Workers"
    for each row
execute function worker_check();

insert into "Workers" (human_id, brigade_id)
values (1, 1),
       (2, 2),
       (3, 3),
       (4, 4),
       (5, 1),
       (6, 2),
       (7, 3),
       (8, 4),
       (9, 1),
       (10, 2),
       (11, 3),
       (12, 4);
