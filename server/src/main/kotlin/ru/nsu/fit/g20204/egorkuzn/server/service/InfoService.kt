package ru.nsu.fit.g20204.egorkuzn.server.service

interface InfoService {
    fun getTruckToId(): Any

    fun getAuxiliaryModel(): Any

    fun getBusModel(): Any

    fun getAutoModel(): Any

    fun getShuttleModel(): Any

    fun getTruckModel(): Any
}