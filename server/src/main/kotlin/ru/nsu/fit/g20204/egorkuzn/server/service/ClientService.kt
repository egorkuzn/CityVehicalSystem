package ru.nsu.fit.g20204.egorkuzn.server.service

import ru.nsu.fit.g20204.egorkuzn.server.model.entity.CargoVolumeStatEntity

interface ClientService {
//    fun getVehicleDriversAndCount(): Any
//    fun getVehicleToCompanyDistribution(): Any
//    fun getWorkersHierarchyInfo(): Any
    fun getCargoVolumeStat(vehicleId: Long, dateFrom: String, dateTo: String): List<CargoVolumeStatEntity>
    fun getDriversCarDistribution(): Any

    fun getGarageEconomyInfo(): Any

    fun getInfoAboutAutopark(): Any

    fun getMileageInfo(
        paramType: String,
        param: String,
        periodType: String,
        day: String,
        month: String,
        year: String
    ): Any

    fun getPassengerToRootsDistro(): Any

    fun getRepairsStatTransport(
        paramType: String,
        param: String,
        fromDate: String,
        toDate: String
    ): Any

    fun getRepairsStatNode(
        paramType: String,
        param: String,
        fromDate: String,
        toDate: String
    ): Any

    fun getRepairsStatEngineer(
        vehicleId: Long,
        specialisation: String,
        fromDate: String,
        toDate: String
    ): Any

    fun getVehicleAddArchive(
        fromYear: String,
        toYear: String
    ): Any
}
