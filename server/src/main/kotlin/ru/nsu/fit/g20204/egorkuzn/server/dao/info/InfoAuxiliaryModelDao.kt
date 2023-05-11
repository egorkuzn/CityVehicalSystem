package ru.nsu.fit.g20204.egorkuzn.server.dao.info

import org.springframework.stereotype.Repository
import ru.nsu.fit.g20204.egorkuzn.server.config.JdbcConfig
import ru.nsu.fit.g20204.egorkuzn.server.dao.AbstractQueryRunner
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.info.AuxiliaryModelEntity
import java.sql.ResultSet

@Repository
class InfoAuxiliaryModelDao(jdbcConfig: JdbcConfig) : AbstractQueryRunner<AuxiliaryModelEntity>(jdbcConfig) {
    override fun returnEntity(resultSet: ResultSet) = with(resultSet) {
        AuxiliaryModelEntity(
            resultSet.getLong("model_id"),
            resultSet.getString("model_name"),
            resultSet.getString("description")
        )
    }

    fun runQuery() = sqlRun(
        """
            select *
            from "Auxiliary models"
        """.trimIndent()
    )
}