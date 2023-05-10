package ru.nsu.fit.g20204.egorkuzn.server.dao.query

import org.springframework.stereotype.Repository
import ru.nsu.fit.g20204.egorkuzn.server.config.JdbcConfig
import ru.nsu.fit.g20204.egorkuzn.server.dao.AbstractQueryRunner
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.query.WorkersHierarchyInfoEntity
import java.sql.ResultSet

@Repository
class WorkersHierarchyInfoDao(jdbcConfig: JdbcConfig): AbstractQueryRunner<WorkersHierarchyInfoEntity>(jdbcConfig) {
    override fun returnEntity(resultSet: ResultSet) = with(resultSet) {
        WorkersHierarchyInfoEntity(
            getString("Начальник цеха"),
            getString("Цех"),
            getString("Начальник участка"),
            getString("Участок"),
            getString("Мастер"),
            getString("Бригадир"),
            getString("Бригада"),
            getString("Рабочий")
        )
    }

    fun runQuery() = sqlRun(
        """
            select DepH.firstname || ' '|| DepH.fathername || ' ' || DepH.surname as "Начальник цеха",
                   Dep.name as "Цех",
                   DisH.firstname || ' '|| DisH.fathername || ' '|| DisH.surname as "Начальник участка",
                   Dis.firstname as "Участок",
                   MH.firstname || ' '|| MH.fathername || ' '|| MH.surname as "Мастер",
                   BH.firstname || ' '|| BH.fathername || ' '|| BH.surname as "Бригадир",
                   Br.brigade_id as "Бригада",
                   WH.firstname || ' '|| WH.fathername || ' '|| WH.surname as "Рабочий"
            from "Department chief" DepC left join "Department" Dep on DepC.department_id = Dep.department_id
                                        left join "Humans" DepH on DepC.human_id = DepH.human_id
                                        left join "District chief" DisC on DepC.district_chef_id = DisC.human_id
                                        left join "Humans" DisH on DisC.human_id = DisH.human_id
                                        left join "District" Dis on DisC.district_id = Dis.district_id
                                        left join "Masters" M on DisC.master_id = M.human_id
                                        left join "Humans" MH on M.human_id = MH.human_id
                                        left join "Brigadier" B on M.brigadier_id = B.human_id
                                        left join "Humans" BH on BH.human_id = B.human_id
                                        left join "Brigades" Br on B.brigade_id = Br.brigade_id
                                        left join "Workers" W on W.brigade_id = B.brigade_id
                                        left join "Humans" WH on W.human_id = WH.human_id;
        """.trimIndent()
    )
}