package ru.nsu.fit.g20204.egorkuzn.server.model.Dto

data class PassengersToRoutsDto(
    val routeId: Long,
    val routName: String,
    val transportCount: Int
)