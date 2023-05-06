package ru.nsu.fit.g20204.egorkuzn.server.model.entity.map

import ru.nsu.fit.g20204.egorkuzn.server.model.entity.BaseEntity

data class TruckToIdEntity(
    val modelName: String,
    val vehicleId: Long
): BaseEntity