-- 10. Получить сведения о грузоперевозках, выполненных указанной
-- автомашиной за обозначенный период.

select vehicle_id,
    trip_date as "Date",
    cargo_volume as "Cargo volume transported",
    distance as "Distance"
from "Trip-Cargo volume" TCV join "Trips" T on TCV.trip_id = T.trip_id
where T.vehicle_id = :vehicle_id
    and T.trip_date >= :from_one_date
    and T.trip_date <= :to_another_date;

select VV.vehicle_id::text || '|' || VV."Model name" as "Transport",
       count(DV.vehicle_id) as "Drivers to car distribution"
from (select distinct V.vehicle_id,
                      case when V.vehicle_id = VSM.vehicle_id then SM.model_name
                           when V.vehicle_id = VAM.vehicle_id then AM.model_name
                           when V.vehicle_id = VCM.vehicle_id then CM.model_name
                           when V.vehicle_id = VTruckM.vehicle_id then TruckM.model_name
                           when V.vehicle_id = VTaxiM.vehicle_id then TaxiM.model_name
                           when V.vehicle_id = VBM.vehicle_id then BM.model_name
                          end as "Model name"
      from "Vehicle" as V,
           "Vehicle-Shuttle model" VSM left join "Shuttles models" SM on VSM.shuttle_model_id = SM.shuttle_model_id,
           "Vehicle-Auxiliary model" VAM left join "Auxiliary models" AM on VAM.auxiliary_id = AM.model_id,
           "Vehicle-Car model" VCM left join "Cars models" CM on VCM.car_model_id = CM.car_model_id,
           "Vehicle-Truck model" VTruckM left join "Trucks models" TruckM on VTruckM.truck_id = TruckM.truck_model_id,
           "Vehicle-Taxi model" VTaxiM left join "Cars models" TaxiM on VTaxiM.taxi_model_id = TaxiM.car_model_id,
           "Vehicle-Bus model" VBM left join "Buses models" BM on VBM.bus_model_id = BM.bus_model_id
      where V.vehicle_id in (VSM.vehicle_id,
                             VAM.vehicle_id,
                             VCM.vehicle_id,
                             VTruckM.vehicle_id,
                             VTaxiM.vehicle_id,
                             VBM.vehicle_id)
      order by V.vehicle_id) VV left join "Drivers-Vehicles" DV on VV.vehicle_id = DV.vehicle_id
group by "Transport"
order by count(DV.vehicle_id) desc, "Transport";


