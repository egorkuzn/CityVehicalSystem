package ru.nsu.fit.g20204.egorkuzn.server.service

import ru.nsu.fit.g20204.egorkuzn.server.model.dto.CargoTripPeriodDto
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.CargoVolumeStatEntity

interface ClientService {
//    fun getMileageInfo(): Any
//    fun getPassengerToRootsDistro(): Any
//    fun getRepairsStat(): Any
//    fun getVehicleAddArchive(): Any
//    fun getVehicleDriversAndCount(): Any
//    fun getVehicleToCompanyDistribution(): Any
//    fun getWorkersHierarchyInfo(): Any
    fun getCargoVolumeStat(vehicleId: Long, dateFrom: String, dateTo: String): List<CargoVolumeStatEntity>
    fun getDriversCarDistribution(): Any
    fun getGarageEconomyInfo(): Any
    fun getInfoAboutAutopark(): Any
}
