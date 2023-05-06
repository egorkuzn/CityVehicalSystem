package ru.nsu.fit.g20204.egorkuzn.server.model.entity.query

import ru.nsu.fit.g20204.egorkuzn.server.model.entity.BaseEntity

data class RepairsStatNodeEntity(
    val description: String,
    val count: Int
): BaseEntity