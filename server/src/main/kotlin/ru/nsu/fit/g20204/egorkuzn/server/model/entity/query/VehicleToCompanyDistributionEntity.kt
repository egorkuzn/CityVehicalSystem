package ru.nsu.fit.g20204.egorkuzn.server.model.entity.query

import ru.nsu.fit.g20204.egorkuzn.server.model.entity.BaseEntity

data class VehicleToCompanyDistributionEntity(
    val truckDistribution: Int,
    val taxiDistribution: Int,
    val busDistribution: Int,
    val shuttleDistribution: Int,
    val carDistribution: Int,
    val auxilliaryDistribution: Int
): BaseEntity
