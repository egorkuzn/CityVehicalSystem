package ru.nsu.fit.g20204.egorkuzn.client.model.dto.query

data class VehicleDriversAndCountDto(
    val workerId: Long,
    val firstname: String,
    val surname: String,
    val fathername: String,
    val driversCount: Int
)
