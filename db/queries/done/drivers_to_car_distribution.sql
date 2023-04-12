--Получить распределение водителей по автомобилям.

select vehicle_id,
    count(vehicle_id) as "Drivers to car distribution"
from "Drivers-Vehicles" as DV
group by vehicle_id
order by count(vehicle_id) desc, vehicle_id;