package ru.nsu.fit.g20204.egorkuzn.server.dao.editor.model

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import ru.nsu.fit.g20204.egorkuzn.server.config.JdbcConfig
import ru.nsu.fit.g20204.egorkuzn.server.dao.AbstractOneTableInsertRunner
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.editor.add.models.TruckModelEntity

@Repository
class EditorTruckModelDao(@Autowired jdbcConfig: JdbcConfig) :
    AbstractOneTableInsertRunner<TruckModelEntity>(jdbcConfig) {
    override val tableName: String = "Trucks models"

    override fun delete(value: TruckModelEntity) = sqlUpdate(
        """
            delete from "Trucks models"
            where model_name = '${value.modelName}'
                and cargo_capacity = ${value.cargoCapacity} 
        """.trimIndent()
    )
}