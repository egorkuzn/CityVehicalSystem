package ru.nsu.fit.g20204.egorkuzn.server.dao

import org.springframework.stereotype.Repository
import ru.nsu.fit.g20204.egorkuzn.server.config.JdbcConfig
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.RepairsStatNodeEntity
import java.sql.ResultSet

@Repository
class RepairsStatNodeDao(jdbcConfig: JdbcConfig) : BaseDao<RepairsStatNodeEntity>(jdbcConfig) {
    override fun returnEntity(resultSet: ResultSet) = with(resultSet) {
        RepairsStatNodeEntity(
            getString("description"),
            getInt("count")
        )
    }

    fun runQuery(
        paramType: String,
        param: String,
        fromDate: String,
        toDate: String
    ) = sqlRun(
        """
            select D.description,
                   count(RepairModel.repair_id)
            from "Details" D
                left join "Repairers" RS on D.detail_id = RS.detail_id
                left join (select  R.repair_id,
                          R.price,
                          case
                              when '$paramType' = 'модель' then '$param'
                              when '$paramType' = 'категория' then '$param'
                              when '$paramType' = 'id' then '$param'
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
                  where R.when_started >= '$fromDate'
                    and R.when_finished <= '$toDate'
                    and case
                            when '$paramType' = 'id' then
                                case
                                    when VBM.vehicle_id::text = '$param' then true
                                    when VSM.vehicle_id::text = '$param' then true
                                    when VTM.vehicle_id::text = '$param' then true
                                    when VCM.vehicle_id::text = '$param' then true
                                    when VAM.vehicle_id::text = '$param' then true
                                    when VTruckM.vehicle_id::text = '$param' then true
                                    end
                            when '$paramType' = 'категория' then
                                case
                                    when '$param' = 'Bus' then true
                                    when '$param' = 'Shuttle' then true
                                    when '$param' = 'Taxi' then true
                                    when '$param' = 'Car' then true
                                    when '$param' = 'Auxiliary' then true
                                    when '$param' = 'Truck' then true
                                    end
                            when '$paramType' = 'модель' then
                                case
                                    when BM.model_name = '$param' then true
                                    when SM.model_name = '$param' then true
                                    when TM.model_name = '$param' then true
                                    when CM.model_name = '$param' then true
                                    when AM.model_name = '$param' then true
                                    when TruckM.model_name = '$param' then true
                                    end
                      end
                 ) RepairModel on RepairModel.repair_id = RS.repair_id
            group by D.detail_id;
        """.trimIndent()
    )
}