package ru.nsu.fit.g20204.egorkuzn.server.model.entity

data class GarageEconomyInfoEntity(
    val garageEconomyId: Long,
    val garageAddress: String,
    val taxiCount: Int,
    val truckCount: Int,
    val carCount: Int,
    val shuttleCount: Int,
    val busCount: Int,
    val auxiliaryCount: Int
): BaseEntity