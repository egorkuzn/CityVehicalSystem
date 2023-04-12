-- Получить сведения о пробеге автотранспорта определенной категории
-- или конкретной автомашины за указанный день, месяц, год.
select V.vehicle_id as "Vehicle id",
    sum(T.distance) as "Mileage"
from "Vehicle" V left join "Vehicle-Bus model" on V.vehicle_id = "Vehicle-Bus model".vehicle_id
        left join "Vehicle-Taxi model" on V.vehicle_id="Vehicle-Taxi model".vehicle_id
        left join "Vehicle-Truck model" on V.vehicle_id = "Vehicle-Truck model".vehicle_id
        left join "Vehicle-Auxiliary model" on V.vehicle_id = "Vehicle-Auxiliary model".vehicle_id
        left join "Vehicle-Car model" on V.vehicle_id = "Vehicle-Car model".vehicle_id
        left join "Vehicle-Shuttle model" on V.vehicle_id = "Vehicle-Shuttle model".vehicle_id,
     "Trips" as T
where case
        when :param_type = 'категория' then
            case
            when :param = 'Taxi' then V.vehicle_id = "Vehicle-Taxi model".vehicle_id
            when :param = 'Truck' then V.vehicle_id = "Vehicle-Truck model".vehicle_id
            when :param = 'Car' then V.vehicle_id = "Vehicle-Car model".vehicle_id
            when :param = 'Shuttle' then V.vehicle_id = "Vehicle-Shuttle model".vehicle_id
            when :param = 'Auxiliary' then V.vehicle_id = "Vehicle-Auxiliary model".vehicle_id
            when :param = 'Bus' then V.vehicle_id = "Vehicle-Bus model".vehicle_id
                else true
            end
        when :param_type = 'id' then V.vehicle_id::text = :param
    end
  and T.vehicle_id = V.vehicle_id
    and case
            when :period_type = 'день' then extract(day from T.trip_date) = :period
            when :period_type = 'месяц' then extract(month from T.trip_date) = :period
            when :period_type = 'год' then extract(year from T.trip_date) = :period
        end
group by V.vehicle_id;