create table "District" (
    district_id   serial primary key,
    firstname     text not null check ( length(firstname) > 0 ),
    department_id int not null check ( department_id > 0 ),

    foreign key (department_id) references "Department"
);
