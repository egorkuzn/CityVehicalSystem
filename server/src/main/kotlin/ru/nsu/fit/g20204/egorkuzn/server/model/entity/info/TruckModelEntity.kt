package ru.nsu.fit.g20204.egorkuzn.server.model.entity.info

import ru.nsu.fit.g20204.egorkuzn.server.model.entity.BaseEntity

data class TruckModelEntity(
    val modelName: String,
    val cargoCapacity: Int,
    val modelId: Long
): BaseEntity