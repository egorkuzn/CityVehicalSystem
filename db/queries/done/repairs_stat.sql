-- 6. Получить данные о числе ремонтов и их стоимости для автотранспорта
-- определенной категории, отдельной марки автотранспорта или указанной
-- автомашины за указанный период.
select param_name,
       count(repair_id),
       sum(price)
from (select  R.repair_id,
              R.price,
        case
            when :param_type = 'модель' then :param
            when :param_type = 'категория' then :param
            when :param_type = 'id' then :param
        end as param_name
        from "Repairs" R left join "Vehicle" V on R.vehicle_id = V.vehicle_id
    --bus
         left join "Vehicle-Bus model" VBM on V.vehicle_id = VBM.vehicle_id
         left join "Buses models" BM on VBM.bus_model_id = BM.bus_model_id
    --shuttle
         left join "Vehicle-Shuttle model" VSM on V.vehicle_id = VSM.vehicle_id
         left join "Shuttles models" SM on VSM.shuttle_model_id = SM.shuttle_model_id
    --taxi
         left join "Vehicle-Taxi model" VTM on V.vehicle_id = VTM.vehicle_id
         left join "Cars models" TM on VTM.taxi_model_id = TM.car_model_id
    --car
         left join "Vehicle-Car model" VCM on V.vehicle_id = VCM.vehicle_id
         left join "Cars models" CM on VCM.car_model_id = CM.car_model_id
    --aux
         left join "Vehicle-Auxiliary model" VAM on V.vehicle_id = VAM.vehicle_id
         left join "Auxiliary models" AM on VAM.auxiliary_id = AM.model_id
    --truck
         left join "Vehicle-Truck model" VTruckM on V.vehicle_id = VTruckM.vehicle_id
         left join "Trucks models" TruckM on VTruckM.truck_id = TruckM.truck_model_id
        where R.when_started >= :from_date
              and R.when_finished <= :to_date
              and case
                  when :param_type = 'id' then
                      case
                      when VBM.vehicle_id::text = :param then true
                      when VSM.vehicle_id::text = :param then true
                      when VTM.vehicle_id::text = :param then true
                      when VCM.vehicle_id::text = :param then true
                      when VAM.vehicle_id::text = :param then true
                      when VTruckM.vehicle_id::text = :param then true
                  end
                  when :param_type = 'категория' then
                      case
                          when :param = 'Bus' then true
                          when :param = 'Shuttle' then true
                          when :param = 'Taxi' then true
                          when :param = 'Car' then true
                          when :param = 'Auxiliary' then true
                          when :param = 'Truck' then true
                      end
                  when :param_type = 'модель' then
                      case
                          when BM.model_name = :param then true
                          when SM.model_name = :param then true
                          when TM.model_name = :param then true
                          when CM.model_name = :param then true
                          when AM.model_name = :param then true
                          when TruckM.model_name = :param then true
                      end
                end
        ) RepairModel
group by param_name;


-- 11. Получить данные о числе использованных для ремонта указанных узлов и
-- агрегатов для транспорта определенной категории, отдельной марки
-- автотранспорта или конкретной автомашины за указанный период.
select D.description,
       count(RepairModel.repair_id)
from "Details" D
    left join "Repairers" RS on D.detail_id = RS.detail_id
    left join (select  R.repair_id,
              R.price,
              case
                  when :param_type = 'модель' then :param
                  when :param_type = 'категория' then :param
                  when :param_type = 'id' then :param
                  end as model_name
      from "Repairs" R left join "Vehicle" V on R.vehicle_id = V.vehicle_id
          --bus
                       left join "Vehicle-Bus model" VBM on V.vehicle_id = VBM.vehicle_id
                       left join "Buses models" BM on VBM.bus_model_id = BM.bus_model_id
          --shuttle
                       left join "Vehicle-Shuttle model" VSM on V.vehicle_id = VSM.vehicle_id
                       left join "Shuttles models" SM on VSM.shuttle_model_id = SM.shuttle_model_id
          --taxi
                       left join "Vehicle-Taxi model" VTM on V.vehicle_id = VTM.vehicle_id
                       left join "Cars models" TM on VTM.taxi_model_id = TM.car_model_id
          --car
                       left join "Vehicle-Car model" VCM on V.vehicle_id = VCM.vehicle_id
                       left join "Cars models" CM on VCM.car_model_id = CM.car_model_id
          --aux
                       left join "Vehicle-Auxiliary model" VAM on V.vehicle_id = VAM.vehicle_id
                       left join "Auxiliary models" AM on VAM.auxiliary_id = AM.model_id
          --truck
                       left join "Vehicle-Truck model" VTruckM on V.vehicle_id = VTruckM.vehicle_id
                       left join "Trucks models" TruckM on VTruckM.truck_id = TruckM.truck_model_id
      where R.when_started >= :from_date
        and R.when_finished <= :to_date
        and case
                when :param_type = 'id' then
                    case
                        when VBM.vehicle_id::text = :param then true
                        when VSM.vehicle_id::text = :param then true
                        when VTM.vehicle_id::text = :param then true
                        when VCM.vehicle_id::text = :param then true
                        when VAM.vehicle_id::text = :param then true
                        when VTruckM.vehicle_id::text = :param then true
                        end
                when :param_type = 'категория' then
                    case
                        when :param = 'Bus' then true
                        when :param = 'Shuttle' then true
                        when :param = 'Taxi' then true
                        when :param = 'Car' then true
                        when :param = 'Auxiliary' then true
                        when :param = 'Truck' then true
                        end
                when :param_type = 'модель' then
                    case
                        when BM.model_name = :param then true
                        when SM.model_name = :param then true
                        when TM.model_name = :param then true
                        when CM.model_name = :param then true
                        when AM.model_name = :param then true
                        when TruckM.model_name = :param then true
                        end
          end
     ) RepairModel on RepairModel.repair_id = RS.repair_id
group by D.detail_id;


-- 14. Получить данные о работах, выполненных указанным специалистом
-- (сварщиком, слесарем и т.д.) за обозначенный период в целом и по
-- конкретной автомашине.
select R.repair_id,
       R.description
from "Repairers" RS
    left join "Repairs" R on RS.repair_id = R.repair_id
    left join "Engineers" E on RS.engineer_id = E.engineer_id
    left join "Engineer specialisation" ES on E.specialisation_id = ES.specialisation_id
where vehicle_id = :vehicle_id
    and ES.description = :specialisation
    and R.when_started >= :from_date
    and R.when_finished <= :to_date