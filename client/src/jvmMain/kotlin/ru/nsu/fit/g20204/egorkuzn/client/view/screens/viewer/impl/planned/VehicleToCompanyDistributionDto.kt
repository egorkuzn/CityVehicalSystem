package ru.nsu.fit.g20204.egorkuzn.client.view.screens.viewer.impl.planned

data class VehicleToCompanyDistributionDto(
    val truckDistribution: Int,
    val taxiDistribution: Int,
    val busDistribution: Int,
    val shuttleDistribution: Int,
    val carDistribution: Int,
    val auxilliaryDistribution: Int
)
