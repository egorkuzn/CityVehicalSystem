package ru.nsu.fit.g20204.egorkuzn.server.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.nsu.fit.g20204.egorkuzn.server.service.ClientService

@RestController
@Tag(name = "")
@RequestMapping("api/v1/city-vehicle-system/")
class Controller(@Autowired val clientService: ClientService) {
    @Operation(summary = "Получение информации о грузоперевозках")
    @GetMapping("cargo-volume-stat")
    fun getCargoVolumeStat() = clientService.getCargoVolumeStat()

    @Operation(summary = "Получение распределения водителей по автотранспорту")
    @GetMapping("drivers-to-car-distribution")
    fun getDriversCarDistribution() = clientService.getDriversCarDistribution()

    @Operation(summary = "Получение информации о гаражном хозяйстве")
    @GetMapping("garage-economy-info")
    fun gatGarageEconomyInfo = clientService.getGarageEconomyInfo()
}