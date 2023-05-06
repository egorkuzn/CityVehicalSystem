package ru.nsu.fit.g20204.egorkuzn.server.model.entity.query

import ru.nsu.fit.g20204.egorkuzn.server.model.entity.BaseEntity

data class WorkersHierarchyInfoEntity(
    val depHead: String,
    val depName: String,
    val disHead: String,
    val disName: String,
    val master: String,
    val brigadier: String,
    val brigade: String,
    val worker: String
): BaseEntity