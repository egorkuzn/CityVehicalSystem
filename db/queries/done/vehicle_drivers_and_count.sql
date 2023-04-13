-- 2. Получить перечень и общее число водителей по предприятию, по
-- указанной автомашине.
select TableWithId.worker_id, firstname, surname, fathername,
       TableWithCount.driversCount
from (select count(worker_id) driversCount
        from "Drivers-Vehicles" DV left join "Drivers" D on D.worker_id = DV.driver_id
                left join "Humans" H on human_id = worker_id
        where vehicle_id = :vehicle_id) as TableWithCount,
     (select worker_id,
             firstname,
             surname,
             fathername
        from "Drivers-Vehicles" DV left join "Drivers" D on D.worker_id = DV.driver_id
                left join "Humans" H on human_id = worker_id
        where vehicle_id = :vehicle_id) as TableWithId;
