package ru.nsu.fit.g20204.egorkuzn.server.model.entity.query

import ru.nsu.fit.g20204.egorkuzn.server.model.entity.BaseEntity

data class VehicleAddArchiveEntity(
    val vehicleId: Long,
    val status: String
): BaseEntity