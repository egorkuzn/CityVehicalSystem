create table "Details" (
    detail_id   serial primary key,
    description text not null check ( length(description) > 0 )
);