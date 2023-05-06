package ru.nsu.fit.g20204.egorkuzn.server.dao.query

import org.springframework.stereotype.Repository
import ru.nsu.fit.g20204.egorkuzn.server.config.JdbcConfig
import ru.nsu.fit.g20204.egorkuzn.server.dao.BaseDao
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.query.VehicleDriversAndCountEntity
import java.sql.ResultSet

@Repository
class VehicleDriversAndCountDao(jdbcConfig: JdbcConfig): BaseDao<VehicleDriversAndCountEntity>(jdbcConfig) {
    override fun returnEntity(resultSet: ResultSet) = with(resultSet) {
        VehicleDriversAndCountEntity(
            getLong("worker_id"),
            getString("firstname"),
            getString("surname"),
            getString("fathername"),
            getInt("driversCount")
        )
    }

    fun runQuery(vehicleId: Long) = sqlRun(
        """
            select TableWithId.worker_id, firstname, surname, fathername,
                   TableWithCount.driversCount
            from (select count(worker_id) driversCount
                    from "Drivers-Vehicles" DV left join "Drivers" D on D.worker_id = DV.driver_id
                            left join "Humans" H on human_id = worker_id
                    where vehicle_id = $vehicleId) as TableWithCount,
                 (select worker_id,
                         firstname,
                         surname,
                         fathername
                    from "Drivers-Vehicles" DV left join "Drivers" D on D.worker_id = DV.driver_id
                            left join "Humans" H on human_id = worker_id
                    where vehicle_id = $vehicleId) as TableWithId;
        """.trimIndent()
    )
}
