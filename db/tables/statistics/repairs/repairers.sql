create table "Repairers" (
    engineer_id int not null check ( engineer_id > 0 ),
    repair_id int not null check ( repair_id > 0 ),
    detail_id int not null check ( detail_id > 0 ),

    foreign key (engineer_id) references "Engineers" ,
    foreign key (repair_id) references "Repairs",
    foreign key (detail_id) references "Details"
);



alter table "Repairers"
add constraint repairers_pr_key primary key (engineer_id, repair_id, detail_id);

insert into "Repairers" (engineer_id, repair_id, detail_id)
values (1, 1, 2);

insert into "Repairers" (engineer_id, repair_id, detail_id)
values (3, 3, 16);