package ru.nsu.fit.g20204.egorkuzn.server.dao.query

import org.springframework.stereotype.Repository
import ru.nsu.fit.g20204.egorkuzn.server.config.JdbcConfig
import ru.nsu.fit.g20204.egorkuzn.server.dao.BaseDao
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.query.PassengersToRoutsEntity
import java.sql.ResultSet

@Repository
class PassengersToRoutsDistrDao(jdbcConfig: JdbcConfig) : BaseDao<PassengersToRoutsEntity>(jdbcConfig) {
    override fun returnEntity(resultSet: ResultSet) = with(resultSet) {
        PassengersToRoutsEntity(
            getLong("route_id"),
            getString("route_name"),
            getInt("Transport count")
        )
    }

    fun runQuery() = sqlRun(
        """
            select A.route_id,
                   A.route_name,
                   case when B."Transport count" isnull then 0
                       else B."Transport count"
                   end
                   + case when C."Transport count" isnull then 0
                         else C."Transport count"
                   end as "Transport count"
            from "Routes" A left join (
                select R.route_id,
                       count(*) as "Transport count"
                from "Routes" as R,
                     "Vehicle-Bus model" as VBM
                where (VBM.route_id = R.route_id)
                group by R.route_id
                ) B on A.route_id = B.route_id
                left join (
                select R.route_id,
                       count(*) as "Transport count"
                from "Routes" as R,
                     "Vehicle-Shuttle model" as VSM
                where (VSM.route_id = R.route_id)
                group by R.route_id
                ) C on A.route_id = C.route_id;
        """.trimIndent()
    )
}