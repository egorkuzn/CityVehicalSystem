-- 9. Получить данные о распределении автотранспорта на предприятии.
select "Truck distribution".volume,
       "Taxi distribution".volume,
       "Bus distribution".volume,
       "Shuttle distribution".volume,
       "Car distribution".volume,
       "Auxilliary distribution".volume
from (select count(*) as volume
      from "Vehicle-Truck model" as A) "Truck distribution",
     (select count(*) as volume
      from "Vehicle-Taxi model" as A) "Taxi distribution",
     (select count(*) as volume
      from "Vehicle-Bus model" as A) "Bus distribution",
     (select count(*) as volume
      from "Vehicle-Shuttle model" as A) "Shuttle distribution",
     (select count(*) as volume
      from "Vehicle-Car model" as A) "Car distribution",
     (select count(*) as volume
      from "Vehicle-Auxiliary model" as A) "Auxilliary distribution";
