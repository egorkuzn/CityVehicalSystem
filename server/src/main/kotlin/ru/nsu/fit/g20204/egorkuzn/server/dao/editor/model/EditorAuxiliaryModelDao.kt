package ru.nsu.fit.g20204.egorkuzn.server.dao.editor.model

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import ru.nsu.fit.g20204.egorkuzn.server.config.JdbcConfig
import ru.nsu.fit.g20204.egorkuzn.server.dao.AbstractOneTableInsertRunner
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.editor.add.models.AuxiliaryModelEntity

@Repository
class EditorAuxiliaryModelDao(@Autowired jdbcConfig: JdbcConfig): AbstractOneTableInsertRunner<AuxiliaryModelEntity> (jdbcConfig) {
    override val tableName: String = "Auxiliary models"

    override fun delete(value: AuxiliaryModelEntity) = sqlUpdate(
        """
            delete from "$tableName"
            where model_name = '${value.modelName}'
             and description = '${value.description}'
        """.trimIndent()
    )
}