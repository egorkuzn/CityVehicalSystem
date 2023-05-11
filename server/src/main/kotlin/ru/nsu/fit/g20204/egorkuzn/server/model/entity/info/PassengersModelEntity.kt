package ru.nsu.fit.g20204.egorkuzn.server.model.entity.info

import ru.nsu.fit.g20204.egorkuzn.server.model.entity.BaseEntity

data class PassengersModelEntity(
    val modelName: String,
    val capacity: Int,
    val modelId: Long
): BaseEntity
