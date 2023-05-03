package ru.nsu.fit.g20204.egorkuzn.server.model.entity

data class DriversCarDistributionEntity(
    val vehicleId: Long,
    val driversCountToCar: Int
): BaseEntity