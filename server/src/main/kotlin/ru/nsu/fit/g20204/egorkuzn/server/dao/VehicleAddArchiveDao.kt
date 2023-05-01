package ru.nsu.fit.g20204.egorkuzn.server.dao

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import ru.nsu.fit.g20204.egorkuzn.server.config.JdbcConfig
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.VehicleAddArchiveEntity
import java.sql.ResultSet

@Repository
class VehicleAddArchiveDao(@Autowired jdbcConfig: JdbcConfig): BaseDao<VehicleAddArchiveEntity>(jdbcConfig) {
    override fun returnEntity(resultSet: ResultSet) = with(resultSet) {
        VehicleAddArchiveEntity(
            getLong("vehicle_id"),
            getString("Status")
        )
    }

    fun runQuery(fromYear: String, toYear: String) = sqlRun(
        """
            select vehicle_id,
                   case when ((V.archive_year >= $fromYear and V.archive_year <= $toYear)
                              and (V.add_year >= $fromYear and V.add_year <= $toYear)) then 'Archived and added'
                        when (V.archive_year >= $fromYear and V.archive_year <= $toYear) then 'Archived'
                   else 'Added' end as "Status"
            from "Vehicle" as V
            where (V.archive_year >= $fromYear and V.archive_year <= $toYear)
                or (V.add_year >= $fromYear and V.add_year <= $toYear)
        """.trimIndent()
    )
}