package ru.nsu.fit.g20204.egorkuzn.server.model.entity.editor.add.models

import ru.nsu.fit.g20204.egorkuzn.server.model.entity.SqlInsertable

data class TruckModelEntity(
    val modelName: String,
    val cargoCapacity: Int
) : SqlInsertable {
    override fun toSqlValue() = "(DEFAULT, '$modelName', $cargoCapacity)"
}