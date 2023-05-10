package ru.nsu.fit.g20204.egorkuzn.server.model.entity.info

import ru.nsu.fit.g20204.egorkuzn.server.model.entity.BaseEntity

data class AuxiliaryModelEntity(
    val modelId: Long,
    val modelName: String,
    val description: String
): BaseEntity