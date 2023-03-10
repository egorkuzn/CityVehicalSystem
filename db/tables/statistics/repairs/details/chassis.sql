create table "Chassis" (
    chassis_id int primary key check ( chassis_id > 0 ),

    foreign key (chassis_id) references "Details"
);