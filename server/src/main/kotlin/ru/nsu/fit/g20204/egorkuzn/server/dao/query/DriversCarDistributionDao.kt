package ru.nsu.fit.g20204.egorkuzn.server.dao.query

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import ru.nsu.fit.g20204.egorkuzn.server.config.JdbcConfig
import ru.nsu.fit.g20204.egorkuzn.server.dao.AbstractQueryRunner
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.query.DriversCarDistributionEntity
import java.sql.ResultSet

@Repository
class DriversCarDistributionDao(@Autowired jdbcConfig: JdbcConfig) : AbstractQueryRunner<DriversCarDistributionEntity>(jdbcConfig) {
    override fun returnEntity(resultSet: ResultSet) = with(resultSet) {
        DriversCarDistributionEntity(
            getString("Transport"),
            getInt("Drivers to car distribution")
        )
    }

    fun runQuery() = sqlRun(
        """
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
        """.trimIndent()
    )
}