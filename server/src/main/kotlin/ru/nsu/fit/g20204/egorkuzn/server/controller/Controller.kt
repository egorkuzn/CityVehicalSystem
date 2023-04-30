package ru.nsu.fit.g20204.egorkuzn.server.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.nsu.fit.g20204.egorkuzn.server.service.ClientService

@RestController
@Tag(name = "")
@RequestMapping("api/v1/city-vehicle-system/")
class Controller(@Autowired val clientService: ClientService) {
    @Operation(summary = "Получение информации о грузоперевозках")
    @GetMapping("cargo-volume-stat")
    fun getCargoVolumeStat(
        @RequestParam vehicleId: Long,
        @RequestParam dateFrom: String,
        @RequestParam dateTo: String
    ) = clientService.getCargoVolumeStat(
        vehicleId,
        dateFrom,
        dateTo
    )

    @Operation(summary = "Получение распределения водителей по автотранспорту")
    @GetMapping("drivers-to-car-distribution")
    fun getDriversCarDistribution() = clientService.getDriversCarDistribution()

    @Operation(summary = "Получение информации о гаражном хозяйстве")
    @GetMapping("garage-economy-info")
    fun gatGarageEconomyInfo() = clientService.getGarageEconomyInfo()

    @Operation(summary = "Получение информации о автопарке")
    @GetMapping("info_about_autopark")
    fun getInfoAboutAutopark() = clientService.getInfoAboutAutopark()
//
//    @Operation(summary = "Получение информации о пробеге")
//    @GetMapping("mileage_info")
//    fun getMileageInfo() = clientService.getMileageInfo()
//
//    @Operation(summary = "Получение информации о распределении пассажиров по маршрутам")
//    @GetMapping("passangers_to_roats_distr")
//    fun getPassengerToRootsDistro() = clientService.getPassengerToRootsDistro()
//
//    @Operation(summary = "Получение информации о ремонтах")
//    @GetMapping("repairs_stat")
//    fun getRepairsStat() = clientService.getRepairsStat()
//
//    @Operation(summary = "Получить сведения о полученной и списанной автотехники за указанный период")
//    @GetMapping("vehicle_add_archive")
//    fun getVehicleAddArchive() = clientService.getVehicleAddArchive()
//
//    @Operation(summary = "Получить перечень и общее число водителей по предприятию, по указанной автомашине.")
//    @GetMapping("vehicle_drivers_and_count")
//    fun getVehicleDriversAndCount() = clientService.getVehicleDriversAndCount()
//
//    @Operation(summary = "Получить данные о распределении автотранспорта на предприятии.")
//    @GetMapping("vehicle_to_company_distribution")
//    fun getVehicleToCompanyDistribution() = clientService.getVehicleToCompanyDistribution()
//
//    @Operation(summary = "Получить данные о подчиненности персонала: рабочие -бригадиры мастера - начальники участков и цехов.")
//    @GetMapping("workers_hierarchy_info")
//    fun getWorkersHierarchyInfo() = clientService.getWorkersHierarchyInfo()
}