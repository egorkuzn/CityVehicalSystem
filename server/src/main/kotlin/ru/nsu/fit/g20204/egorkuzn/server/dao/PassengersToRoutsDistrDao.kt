package ru.nsu.fit.g20204.egorkuzn.server.dao

import org.springframework.stereotype.Service
import ru.nsu.fit.g20204.egorkuzn.server.config.JdbcConfig
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.PassengersToRoutsEntity
import java.sql.ResultSet

@Service
class PassengersToRoutsDistrDao(jdbcConfig: JdbcConfig): BaseDao<PassengersToRoutsEntity>(jdbcConfig){
    override fun returnEntity(resultSet: ResultSet) = with(resultSet) {
        PassengersToRoutsEntity(
            getLong("route_id"),
            getString("route_name"),
            getInt("Transport count")
        )
    }

    fun runQuery() = sqlRun(
        """
            
        """.trimIndent()
    )
}