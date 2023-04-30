package ru.nsu.fit.g20204.egorkuzn.server.model.dto

data class CargoTripPeriodDto (
    val vehicleId: Long,
    val dateFrom: String,
    val dateTo: String
)