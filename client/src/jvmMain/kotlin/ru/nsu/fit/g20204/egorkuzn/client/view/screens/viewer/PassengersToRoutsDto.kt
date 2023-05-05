package ru.nsu.fit.g20204.egorkuzn.client.view.screens.viewer

data class PassengersToRoutsDto(
    val routeId: Long,
    val routName: String,
    val transportCount: Int
)