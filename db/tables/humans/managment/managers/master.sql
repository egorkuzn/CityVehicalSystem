create table "Masters" (
    human_id     int primary key check ( human_id > 0 ),
    brigadier_id int not null check ( brigadier_id > 0 ),

    foreign key (brigadier_id) references "Brigadier",
    foreign key (human_id)     references "Humans"
);