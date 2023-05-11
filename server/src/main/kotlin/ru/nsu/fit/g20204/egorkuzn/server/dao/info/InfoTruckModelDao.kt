package ru.nsu.fit.g20204.egorkuzn.server.dao.info

import org.springframework.stereotype.Repository
import ru.nsu.fit.g20204.egorkuzn.server.config.JdbcConfig
import ru.nsu.fit.g20204.egorkuzn.server.dao.AbstractQueryRunner
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.info.TruckModelEntity
import java.sql.ResultSet

@Repository
class InfoTruckModelDao(jdbcConfig: JdbcConfig) : AbstractQueryRunner<TruckModelEntity>(jdbcConfig) {
    override fun returnEntity(resultSet: ResultSet) = with(resultSet) {
        TruckModelEntity(
            resultSet.getString("model_name"),
            resultSet.getInt("cargo_capacity"),
            resultSet.getLong("truck_model_id")
        )
    }

    fun runQuery() = sqlRun(
        """
            select truck_model_id,
                   model_name,
                   cargo_capacity
            from "Trucks models"
        """.trimIndent()
    )
}