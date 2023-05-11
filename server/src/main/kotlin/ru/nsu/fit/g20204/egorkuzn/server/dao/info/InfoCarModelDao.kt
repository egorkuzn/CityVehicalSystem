package ru.nsu.fit.g20204.egorkuzn.server.dao.info

import org.springframework.stereotype.Repository
import ru.nsu.fit.g20204.egorkuzn.server.config.JdbcConfig
import ru.nsu.fit.g20204.egorkuzn.server.dao.AbstractQueryRunner
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.info.PassengersModelEntity
import java.sql.ResultSet

@Repository
class InfoCarModelDao(jdbcConfig: JdbcConfig) : AbstractQueryRunner<PassengersModelEntity>(jdbcConfig) {
    override fun returnEntity(resultSet: ResultSet) = with(resultSet) {
        PassengersModelEntity(
            getString("model_name"),
            getInt("passengers_capacity"),
            getLong("model_id")
        )
    }

    fun runQuery() = sqlRun(
        """
            select CM.model_name,
                   PM.model_id,
                   PM.passengers_capacity
            from "Cars models" as CM left join "Passenger transport models" as PM
            on CM.car_model_id = PM.model_id
        """.trimIndent()
    )
}