create table "Department" (
    department_id serial primary key,
    name          text not null check ( length(name) > 0 )
);