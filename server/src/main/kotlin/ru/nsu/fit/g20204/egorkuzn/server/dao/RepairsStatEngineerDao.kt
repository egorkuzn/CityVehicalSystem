package ru.nsu.fit.g20204.egorkuzn.server.dao

import org.springframework.stereotype.Repository
import ru.nsu.fit.g20204.egorkuzn.server.config.JdbcConfig
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.RepairsStatEngineerEntity
import java.sql.ResultSet

@Repository
class RepairsStatEngineerDao(jdbcConfig: JdbcConfig) : BaseDao<RepairsStatEngineerEntity>(jdbcConfig) {
    override fun returnEntity(resultSet: ResultSet) = with(resultSet) {
        RepairsStatEngineerEntity(
            getLong("repair_id"),
            getString("description")
        )
    }

    fun runQuery(
        vehicleId: Long,
        specialisation: String,
        fromDate: String,
        toDate: String
    ) = sqlRun(
        """
            select R.repair_id,
                   R.description
            from "Repairers" RS
                left join "Repairs" R on RS.repair_id = R.repair_id
                left join "Engineers" E on RS.engineer_id = E.engineer_id
                left join "Engineer specialisation" ES on E.specialisation_id = ES.specialisation_id
            where vehicle_id = $vehicleId
                and ES.description = '$specialisation'
                and R.when_started >= '$fromDate'
                and R.when_finished <= '$toDate'
        """.trimIndent()
    )
}