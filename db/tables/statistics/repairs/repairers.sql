create table "Repairers" (
    worker_id int not null check ( worker_id > 0 ),
    repair_id int not null check ( repair_id > 0 ),
    detail_id int not null check ( detail_id > 0 ),

    foreign key (worker_id) references "Workers" ,
    foreign key (repair_id) references "Repairs",
    foreign key (detail_id) references "Details"
);