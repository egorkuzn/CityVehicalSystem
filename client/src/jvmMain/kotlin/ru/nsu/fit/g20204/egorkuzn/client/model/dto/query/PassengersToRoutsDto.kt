package ru.nsu.fit.g20204.egorkuzn.client.model.dto.query

data class PassengersToRoutsDto(
    val routeId: Long,
    val routName: String,
    val transportCount: Int
)