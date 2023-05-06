package ru.nsu.fit.g20204.egorkuzn.server.model.entity.query

import ru.nsu.fit.g20204.egorkuzn.server.model.entity.BaseEntity

data class VehicleDriversAndCountEntity(
    val workerId: Long,
    val firstname: String,
    val surname: String,
    val fathername: String,
    val driversCount: Int
): BaseEntity
