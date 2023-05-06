package ru.nsu.fit.g20204.egorkuzn.server.model.entity.query

import ru.nsu.fit.g20204.egorkuzn.server.model.entity.BaseEntity

data class RepairsStatTransportEntity (
    val paramName: String,
    val count: Int,
    val sum: Int
): BaseEntity