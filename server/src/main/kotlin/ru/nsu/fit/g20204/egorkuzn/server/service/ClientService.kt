package ru.nsu.fit.g20204.egorkuzn.server.service

interface ClientService {
    fun getCargoVolumeStat(): Any
    fun getDriversCarDistribution(): Any
    fun getGarageEconomyInfo(): Any
}