create table "Department chief" (
    human_id             int primary key check ( human_id > 0 ),
    district_chef_id     int not null check ( district_chef_id > 0 ),
    department_id        int not null check ( department_id > 0 ),

    foreign key (human_id)         references "Humans",
    foreign key (district_chef_id) references "District chief",
    foreign key (department_id)    references "Department"
);