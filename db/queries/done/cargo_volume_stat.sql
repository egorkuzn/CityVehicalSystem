-- 10. Получить сведения о грузоперевозках, выполненных указанной
-- автомашиной за обозначенный период.

select vehicle_id,
    trip_date as "Date",
    cargo_volume as "Cargo volume transported",
    distance as "Distance"
from "Trip-Cargo volume" TCV left join "Trips" T on TCV.trip_id = T.trip_id
where T.vehicle_id = :vehicle_id
    and T.trip_date >= :from_one_date
    and T.trip_date <= :to_another_date