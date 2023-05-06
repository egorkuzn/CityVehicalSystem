package ru.nsu.fit.g20204.egorkuzn.server.dao.query

import org.springframework.stereotype.Repository
import ru.nsu.fit.g20204.egorkuzn.server.config.JdbcConfig
import ru.nsu.fit.g20204.egorkuzn.server.dao.BaseDao
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.query.WorkersHierarchyInfoManagerEntity
import java.sql.ResultSet

@Repository
class WorkersHierarchyInfoManagerDao(jdbcConfig: JdbcConfig): BaseDao<WorkersHierarchyInfoManagerEntity>(jdbcConfig) {
    override fun returnEntity(resultSet: ResultSet) = with(resultSet) {
        WorkersHierarchyInfoManagerEntity(
            getString("firstname"),
            getString("fathername"),
            getString("surname")
        )
    }

    fun runQuery(managerId: Long) = sqlRun(
        """
            select distinct firstname, fathername, surname
            from "Department chief" DepC,
                "District chief" DisC,
                "Masters" M,
                "Brigadier" B,
                "Workers" W,
                "Humans" H
            where case
                when DisC.human_id = $managerId then DisC.master_id = H.human_id
                when DepC.human_id = $managerId then DepC.district_chef_id = H.human_id
                when M.human_id = $managerId then M.brigadier_id = H.human_id
                when B.human_id = $managerId then B.brigade_id = W.brigade_id and H.human_id = W.human_id
                end;
        """.trimIndent()
    )
}