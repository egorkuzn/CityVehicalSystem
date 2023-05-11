package ru.nsu.fit.g20204.egorkuzn.server.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.nsu.fit.g20204.egorkuzn.server.service.InfoService

@RestController
@Tag(name = "Дополнительная информация")
@RequestMapping("api/v1/city-vehicle-system/info/")
class InfoController(@Autowired val controllerService: InfoService) {
    @Operation(summary = "Получение карты по грузовому транспорту <{Название модели}_{номер}>:<{vehicle_id}>")
    @GetMapping("model/truck-vehicle")
    fun getTruckToId() = controllerService.getTruckToId()

    @Operation(summary = "Получение моделей специального транспорта")
    @GetMapping("model/auxiliary")
    fun getAuxiliary() = controllerService.getAuxiliaryModel()

    @Operation(summary = "Получение моделей автобусов")
    @GetMapping("model/bus")
    fun getBus() = controllerService.getBusModel()

    @Operation(summary = "Получение моделей авто")
    @GetMapping("model/car")
    fun getAuto() = controllerService.getCarModel()

    @Operation(summary = "Получение моделей маршрутного такси")
    @GetMapping("model/shuttle")
    fun getShuttle() = controllerService.getShuttleModel()

    @Operation(summary = "Получение моделей грузовиков")
    @GetMapping("model/truck")
    fun getTruck() = controllerService.getTruckModel()
}