package ru.nsu.fit.g20204.egorkuzn.server.dao.query

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import ru.nsu.fit.g20204.egorkuzn.server.config.JdbcConfig
import ru.nsu.fit.g20204.egorkuzn.server.dao.AbstractQueryRunner
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.query.CargoVolumeStatEntity
import java.sql.ResultSet

@Repository
class CargoVolumeStatDao(@Autowired jdbcConfig: JdbcConfig) : AbstractQueryRunner<CargoVolumeStatEntity>(jdbcConfig) {
    override fun returnEntity(resultSet: ResultSet) = with(resultSet) {
        CargoVolumeStatEntity(
            getLong("vehicle_id"),
            getDate("trip_date"),
            getShort("cargo_volume"),
            getShort("distance")
        )
    }


    fun runQuery(
        vehicleId: Long,
        dateFrom: String,
        dateTo: String
    ) = sqlRun(
        """
            select vehicle_id,
                trip_date,
                cargo_volume,
                distance
            from "Trip-Cargo volume" TCV join "Trips" T on TCV.trip_id = T.trip_id
            where T.vehicle_id = $vehicleId
                and T.trip_date >= '$dateFrom'
                and T.trip_date <= '$dateTo'
        """.trimIndent()
    )
}