package ru.nsu.fit.g20204.egorkuzn.server.dao.query

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import ru.nsu.fit.g20204.egorkuzn.server.config.JdbcConfig
import ru.nsu.fit.g20204.egorkuzn.server.dao.BaseDao
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.query.DriversCarDistributionEntity
import java.sql.ResultSet

@Repository
class DriversCarDistributionDao(@Autowired jdbcConfig: JdbcConfig) : BaseDao<DriversCarDistributionEntity>(jdbcConfig) {
    override fun returnEntity(resultSet: ResultSet) = with(resultSet) {
        DriversCarDistributionEntity(
            getLong("vehicle_id"),
            getInt("Drivers to car distribution")
        )
    }

    fun runQuery() = sqlRun(
        """
            select V.vehicle_id,
                count(DV.vehicle_id) as "Drivers to car distribution"
            from "Vehicle" V left join "Drivers-Vehicles" DV on V.vehicle_id = DV.vehicle_id
            group by V.vehicle_id
            order by count(DV.vehicle_id) desc, V.vehicle_id;
        """.trimIndent()
    )
}