create table "Brigadier" (
    human_id     int primary key check ( human_id > 0 ),
    brigade_id   int not null check ( brigade_id > 0 ),

    foreign key (human_id)   references "Humans",
    foreign key (brigade_id) references "Brigades"
);