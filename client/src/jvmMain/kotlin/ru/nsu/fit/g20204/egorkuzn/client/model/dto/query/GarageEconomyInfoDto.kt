package ru.nsu.fit.g20204.egorkuzn.client.model.dto.query

data class GarageEconomyInfoDto(
    val garageEconomyId: Long,
    val garageAddress: String,
    val taxiCount: Int,
    val truckCount: Int,
    val carCount: Int,
    val shuttleCount: Int,
    val busCount: Int,
    val auxiliaryCount: Int
)