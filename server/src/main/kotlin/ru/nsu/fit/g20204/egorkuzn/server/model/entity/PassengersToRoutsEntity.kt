package ru.nsu.fit.g20204.egorkuzn.server.model.entity

data class PassengersToRoutsEntity(
    val routeId: Long,
    val routName: String,
    val transportCount: Int
): BaseEntity