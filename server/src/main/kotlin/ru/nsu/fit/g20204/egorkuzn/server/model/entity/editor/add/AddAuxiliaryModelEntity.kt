package ru.nsu.fit.g20204.egorkuzn.server.model.entity.editor.add

import ru.nsu.fit.g20204.egorkuzn.server.model.entity.SqlInsertable

data class AddAuxiliaryModelEntity(
    val modelName: String,
    val description: String
) : SqlInsertable {
    override fun toSqlValue() = "(DEFAULT, '$modelName', '$description')"
}