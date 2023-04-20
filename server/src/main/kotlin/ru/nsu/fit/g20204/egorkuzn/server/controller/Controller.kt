package ru.nsu.fit.g20204.egorkuzn.server.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@Tag(name = "")
@RequestMapping("api/v1/city-vehicle-system/")
class Controller(
    @Autowired

) {
    @Operation(summary = "Получение информации о грузоперевозках")
    @GetMapping("cargo-volume-stat")
    fun getCargoVolumeStat() = clientService.getCargoVolumeStat()

}