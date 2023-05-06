package ru.nsu.fit.g20204.egorkuzn.server.model.entity.query

import ru.nsu.fit.g20204.egorkuzn.server.model.entity.BaseEntity

data class WorkersHierarchyInfoManagerEntity(
    val firstname: String,
    val fathername: String,
    val surname: String
): BaseEntity