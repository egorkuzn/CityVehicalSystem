-- 3. Получить распределение водителей по автомобилям.

select V.vehicle_id,
    count(DV.vehicle_id) as "Drivers to car distribution"
from "Vehicle" V left join "Drivers-Vehicles" DV on V.vehicle_id = DV.vehicle_id
group by V.vehicle_id
order by count(DV.vehicle_id) desc, V.vehicle_id;