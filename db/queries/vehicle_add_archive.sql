-- Получить сведения о полученной и списанной автотехники за указанный период.
select vehicle_id,
       case when ((V.archive_year >= :from_one_year and V.archive_year <= :to_another_year)
                  and (V.add_year >= :from_one_year and V.add_year <= :to_another_year)) then 'Archived and added'
            when (V.archive_year >= :from_one_year and V.archive_year <= :to_another_year) then 'Archived'
       else 'Added' end as "Status"
from "Vehicle" as V
where (V.archive_year >= :from_one_year and V.archive_year <= :to_another_year)
    or (V.add_year >= :from_one_year and V.add_year <= :to_another_year)