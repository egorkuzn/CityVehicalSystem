create table "Locksmiths" (
    engineer_id int primary key check ( engineer_id > 0 ),

    foreign key (engineer_id) references "Engineers"
);