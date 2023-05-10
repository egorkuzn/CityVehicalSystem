package ru.nsu.fit.g20204.egorkuzn.server.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.editor.add.models.AddAuxiliaryModelEntity
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.editor.add.models.AddTruckModelEntity
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.editor.add.models.AddPassengersModelEntity
import ru.nsu.fit.g20204.egorkuzn.server.service.AddEditorService

@RestController
@Tag(name = "Модификация таблицы")
@RequestMapping("api/v1/city-vehicle-system/editor/add")
class AddEditorController(@Autowired val addEditorService: AddEditorService) {
    @Operation(summary = "Добавление новой модели спец транспорта")
    @PostMapping("model/auxiliary")
    fun addAuxiliaryModel(
        @RequestBody value: AddAuxiliaryModelEntity
    ) = addEditorService.addAuxiliaryModel(value)

    @Operation(summary = "Добавление новой модели грузовика")
    @PostMapping("model/truck")
    fun addTruckModel(
        @RequestBody value: AddTruckModelEntity
    ) = addEditorService.addTruckModel(value)

    @Operation(summary = "Добавление новой модели авто")
    @PostMapping("model/car")
    fun addCarModel(
        @RequestBody value: AddPassengersModelEntity
    ) = addEditorService.addCarModel(value)

    @Operation(summary = "Добавление новой модели маршрутного такси")
    @PostMapping("model/shuttle")
    fun addShuttleModel(
        @RequestBody value: AddPassengersModelEntity
    ) = addEditorService.addShuttleModel(value)

    @Operation(summary = "Добавление новой модели автобуса")
    @PostMapping("model/bus")
    fun addBusModel(
        @RequestBody value: AddPassengersModelEntity
    ) = addEditorService.addBusModel(value)
}