package ru.nsu.fit.g20204.egorkuzn.server.model.entity.query

import ru.nsu.fit.g20204.egorkuzn.server.model.entity.BaseEntity

data class DriversCarDistributionEntity(
    val vehicleId: Long,
    val driversCountToCar: Int
): BaseEntity