package ru.nsu.fit.g20204.egorkuzn.server.dao.editor.add

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import ru.nsu.fit.g20204.egorkuzn.server.config.JdbcConfig
import ru.nsu.fit.g20204.egorkuzn.server.dao.AbstractUpdateRunner
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.editor.add.AddAuxiliaryModelEntity

@Repository
class AddAuxiliaryModelDao(@Autowired jdbcConfig: JdbcConfig): AbstractUpdateRunner<AddAuxiliaryModelEntity> (jdbcConfig) {
    override val tableName: String = "Auxiliary models"
}