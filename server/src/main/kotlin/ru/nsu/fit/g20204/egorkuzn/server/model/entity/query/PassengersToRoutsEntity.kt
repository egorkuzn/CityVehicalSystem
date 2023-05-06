package ru.nsu.fit.g20204.egorkuzn.server.model.entity.query

import ru.nsu.fit.g20204.egorkuzn.server.model.entity.BaseEntity

data class PassengersToRoutsEntity(
    val routeId: Long,
    val routName: String,
    val transportCount: Int
): BaseEntity