package ru.nsu.fit.g20204.egorkuzn.server.dao

import org.springframework.stereotype.Repository
import ru.nsu.fit.g20204.egorkuzn.server.config.JdbcConfig
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.VehicleToCompanyDistributionEntity
import java.sql.ResultSet

@Repository
class VehicleToCompanyDistributionDao(jdbcConfig: JdbcConfig): BaseDao<VehicleToCompanyDistributionEntity>(jdbcConfig) {
    override fun returnEntity(resultSet: ResultSet) = with(resultSet) {
        VehicleToCompanyDistributionEntity(
            getInt("DTruck"),
            getInt("DTaxi"),
            getInt("DBus"),
            getInt("DShuttle"),
            getInt("DCar"),
            getInt("DA")
        )
    }

    fun runQuery() = sqlRun(
        """
            select "Truck distribution".volume as DTruck,
                   "Taxi distribution".volume as DTaxi,
                   "Bus distribution".volume as DBus,
                   "Shuttle distribution".volume as DShuttle,
                   "Car distribution".volume as DCar,
                   "Auxilliary distribution".volume as DA
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
        """.trimIndent()
    )
}