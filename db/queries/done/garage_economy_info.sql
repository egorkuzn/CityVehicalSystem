-- 8. Получить сведения о наличии гаражного хозяйства в целом и по каждой
-- категории транспорта.
select WITH_NULL.garage_economy_id as "garage_economy_id",
    'ул. ' || street_name || ', д. '|| house_number
    || case
        when after_fraction is null then ''
        else '/' || after_fraction
    end
    || case
        when letter is null then ''
        else letter
    end as "Garage address",
    case when NO_NULL."Vehicle count" isnull 0
        else NO_NULL."Vehicle count"
    end as "Vehicle count",
    NO_NULL."Taxi",
    NO_NULL."Truck",
    NO_NULL."Car",
    NO_NULL."Shuttle",
    NO_NULL."Bus",
    NO_NULL."Auxiliary"
from "Garages economy" WITH_NULL left join (select GE.garage_economy_id,
        VG."Vehicle count",
        VGTaxi."Taxi",
        VGTruck."Truck",
        VGCar."Car",
        VGShuttle."Shuttle",
        VGBus."Bus",
        VGAuxilliary."Auxiliary"
 from "Garages economy" as GE
          join (select V.garage_id as garage_id,
                       count(*)    as "Vehicle count"
                from "Vehicle" as V
                group by V.garage_id) as VG on garage_economy_id = garage_id,
      (select garage_economy_id,
              count(*) as "Taxi"
       from "Garages economy"
                left join
            ("Vehicle-Taxi model" VTM left join
                "Vehicle" V on VTM.vehicle_id = V.vehicle_id) on garage_id = garage_economy_id
       group by garage_economy_id) as VGTaxi,
      (select garage_economy_id,
              count(*) as "Truck"
       from "Garages economy"
                left join
            ("Vehicle-Truck model" VTM left join
                "Vehicle" V on VTM.vehicle_id = V.vehicle_id) on garage_id = garage_economy_id
       group by garage_economy_id) as VGTruck,
      (select garage_economy_id,
              count(*) as "Bus"
       from "Garages economy"
                left join
            ("Vehicle-Bus model" VTM left join
                "Vehicle" V on VTM.vehicle_id = V.vehicle_id) on garage_id = garage_economy_id
       group by garage_economy_id) as VGBus,
      (select garage_economy_id,
              count(*) as "Car"
       from "Garages economy"
                left join
            ("Vehicle-Car model" VTM left join
                "Vehicle" V on VTM.vehicle_id = V.vehicle_id) on garage_id = garage_economy_id
       group by garage_economy_id) as VGCar,
      (select garage_economy_id,
              count(*) as "Auxiliary"
       from "Garages economy"
                left join
            ("Vehicle-Auxiliary model" VTM left join
                "Vehicle" V on VTM.vehicle_id = V.vehicle_id) on garage_id = garage_economy_id
       group by garage_economy_id) as VGAuxilliary,
      (select garage_economy_id,
              count(*) as "Shuttle"
       from "Garages economy"
                left join
            ("Vehicle-Shuttle model" VTM left join
                "Vehicle" V on VTM.vehicle_id = V.vehicle_id) on garage_id = garage_economy_id
       group by garage_economy_id) as VGShuttle
 where GE.garage_economy_id = VGTaxi.garage_economy_id
   and GE.garage_economy_id = VGTruck.garage_economy_id
   and GE.garage_economy_id = VGAuxilliary.garage_economy_id
   and GE.garage_economy_id = VGBus.garage_economy_id
   and GE.garage_economy_id = VGShuttle.garage_economy_id
   and GE.garage_economy_id = VGCar.garage_economy_id) NO_NULL on WITH_NULL.garage_economy_id = NO_NULL.garage_economy_id
