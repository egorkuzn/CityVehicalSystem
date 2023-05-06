package ru.nsu.fit.g20204.egorkuzn.server.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.nsu.fit.g20204.egorkuzn.server.service.ControllerService

@RestController
@Tag(name = "")
@RequestMapping("api/v1/city-vehicle-system/model/")
class Controller(@Autowired val controllerService: ControllerService) {
    @Operation(summary = "Получение карты по транспорту <{Название модели}_{номер}>:<{vehicle_id}>")
    @GetMapping("truck")
    fun getTruckToId() = controllerService.getTruckToId()
}