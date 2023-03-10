create table "District chief" (
    human_id    int primary key check ( human_id > 0 ),
    master_id   int not null check ( master_id > 0 ),
    district_id int not null check ( district_id > 0 ),

    foreign key (human_id)    references "Humans",
    foreign key (master_id)   references "Masters",
    foreign key (district_id) references "District"
);