package ru.nsu.fit.g20204.egorkuzn.server.model.Dto

data class VehicleDriversAndCountDto(
    val workerId: Long,
    val firstname: String,
    val surname: String,
    val fathername: String,
    val driversCount: Int
)
