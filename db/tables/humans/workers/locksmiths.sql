create table "Locksmiths" (
    worker_id int primary key check ( worker_id > 0 ),

    foreign key (worker_id) references "Workers"
);