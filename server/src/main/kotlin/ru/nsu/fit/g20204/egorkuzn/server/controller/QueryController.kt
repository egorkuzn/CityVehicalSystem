package ru.nsu.fit.g20204.egorkuzn.server.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.nsu.fit.g20204.egorkuzn.server.service.QueryService

@RestController
@Tag(name = "Запросы")
@RequestMapping("api/v1/city-vehicle-system/query")
class QueryController(@Autowired val queryService: QueryService) {
    @Operation(summary = "Получение информации о грузоперевозках")
    @GetMapping("cargo-volume-stat")
    fun getCargoVolumeStat(
        @RequestParam vehicleId: Long,
        @RequestParam dateFrom: String,
        @RequestParam dateTo: String
    ) = queryService.getCargoVolumeStat(
        vehicleId,
        dateFrom,
        dateTo
    )

    @Operation(summary = "Получение распределения водителей по автотранспорту")
    @GetMapping("drivers-to-car-distribution")
    fun getDriversCarDistribution() = queryService.getDriversCarDistribution()

    @Operation(summary = "Получение информации о гаражном хозяйстве")
    @GetMapping("garage-economy-info")
    fun gatGarageEconomyInfo() = queryService.getGarageEconomyInfo()

    @Operation(summary = "Получение информации о автопарке")
    @GetMapping("info_about_autopark")
    fun getInfoAboutAutopark() = queryService.getInfoAboutAutopark()

    @Operation(summary = "Получение информации о пробеге")
    @GetMapping("mileage_info")
    fun getMileageInfo(
        @RequestParam paramType: String,
        @RequestParam param: String,
        @RequestParam periodType: String,
        @RequestParam day: String,
        @RequestParam month: String,
        @RequestParam year: String
    ) = queryService.getMileageInfo(
        paramType,
        param,
        periodType,
        day,
        month,
        year
    )

    @Operation(summary = "Получение информации о распределении пассажиров по маршрутам")
    @GetMapping("passangers_to_roats_distr")
    fun getPassengerToRootsDistro() = queryService.getPassengerToRootsDistro()

    @Operation(summary = """Получить данные о числе ремонтов и их стоимости для автотранспорта
                            определенной категории, отдельной марки автотранспорта или указанной
                            автомашины за указанный период.""")
    @GetMapping("repairs_stat_transport")
    fun getRepairsStatTransport(
        @RequestParam paramType: String,
        @RequestParam param: String,
        @RequestParam fromDate: String,
        @RequestParam toDate: String
    ) = queryService.getRepairsStatTransport(
        paramType,
        param,
        fromDate,
        toDate
    )

    @Operation(summary = """Получить данные о числе использованных для ремонта указанных узлов и
                            агрегатов для транспорта определенной категории, отдельной марки
                            автотранспорта или конкретной автомашины за указанный период.""")
    @GetMapping("repairs_stat_node")
    fun getRepairsStatNode(
        @RequestParam paramType: String,
        @RequestParam param: String,
        @RequestParam fromDate: String,
        @RequestParam toDate: String
    ) = queryService.getRepairsStatNode(
        paramType,
        param,
        fromDate,
        toDate
    )

    @Operation(summary = """Получить данные о работах, выполненных указанным специалистом
                            (сварщиком, слесарем и т.д.) за обозначенный период в целом и по
                            конкретной автомашине.""")
    @GetMapping("repairs_stat_engineer")
    fun getRepairsStatEngineer(
        @RequestParam vehicleId: Long,
        @RequestParam specialisation: String,
        @RequestParam fromDate: String,
        @RequestParam toDate: String
    ) = queryService.getRepairsStatEngineer(
        vehicleId,
        specialisation,
        fromDate,
        toDate
    )

    @Operation(summary = "Получить сведения о полученной и списанной автотехники за указанный период")
    @GetMapping("vehicle_add_archive")
    fun getVehicleAddArchive(
        @RequestParam fromYear: String,
        @RequestParam toYear: String
    ) = queryService.getVehicleAddArchive(
        fromYear,
        toYear
    )

    @Operation(summary = "Получить перечень и общее число водителей по предприятию, по указанной автомашине.")
    @GetMapping("vehicle_drivers_and_count")
    fun getVehicleDriversAndCount(
        @RequestParam vehicleId: Long
    ) = queryService.getVehicleDriversAndCount(vehicleId)

    @Operation(summary = "Получить данные о распределении автотранспорта на предприятии.")
    @GetMapping("vehicle_to_company_distribution")
    fun getVehicleToCompanyDistribution() = queryService.getVehicleToCompanyDistribution()

    @Operation(summary = "Получить данные о подчиненности персонала: рабочие -бригадиры мастера - начальники участков и цехов.")
    @GetMapping("workers_hierarchy_info_all")
    fun getWorkersHierarchyInfo() = queryService.getWorkersHierarchyInfo()

    @Operation(summary = """Получить состав подчиненных указанного бригадира,
                            мастера и пр.""")
    @GetMapping("workers_hierarchy_info_manager")
    fun getWorkersHierarchyInfoManager(
        @RequestParam managerId: Long
    ) = queryService.getWorkersHierarchyInfoManager(managerId)
}