package ru.nsu.fit.g20204.egorkuzn.server.dao.info

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import ru.nsu.fit.g20204.egorkuzn.server.config.JdbcConfig
import ru.nsu.fit.g20204.egorkuzn.server.dao.AbstractQueryRunner
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.info.TruckToIdEntity
import java.sql.ResultSet

@Repository
class TruckToIdDao(@Autowired jdbcConfig: JdbcConfig): AbstractQueryRunner<TruckToIdEntity>(jdbcConfig) {
    override fun returnEntity(resultSet: ResultSet) = with(resultSet) {
        TruckToIdEntity(
            resultSet.getString("model_name"),
            resultSet.getLong("vehicle_id")
        )
    }

    fun runQuery() = sqlRun(
        """
            select VTM.vehicle_id::text || '|'|| TM.model_name as model_name,
                   VTM.vehicle_id
            from "Trucks models" as TM
                 left join "Vehicle-Truck model" as VTM
                     on TM.truck_model_id = VTM.truck_id
            where vehicle_id notnull
        """.trimIndent()
    )
}