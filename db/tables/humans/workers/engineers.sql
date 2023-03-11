create table "Engineer specialisation" (
    specialisation_id serial primary key,
    description       text not null check ( length(description) > 0 )
);

create table "Engineers" (
    engineer_id         int primary key check ( engineer_id > 0 ),
    specialisation_id   int not null check ( specialisation_id > 0 ),

    foreign key (engineer_id) references "Workers",
    foreign key (specialisation_id) references "Engineer specialisation"
);