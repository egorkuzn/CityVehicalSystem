package ru.nsu.fit.g20204.egorkuzn.server.controller.editor

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.editor.add.models.AuxiliaryModelEntity
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.editor.add.models.TruckModelEntity
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.editor.add.models.PassengersModelEntity
import ru.nsu.fit.g20204.egorkuzn.server.service.editor.AddEditorService

@RestController
@Tag(name = "Модификация таблицы")
@RequestMapping("api/v1/city-vehicle-system/editor")
class AddEditorController(@Autowired val addEditorService: AddEditorService) {
    @Operation(summary = "Добавление новой модели спец транспорта")
    @PostMapping("model/auxiliary")
    fun addAuxiliaryModel(
        @RequestBody value: AuxiliaryModelEntity
    ) = addEditorService.addAuxiliaryModel(value)

    @Operation(summary = "Добавление новой модели грузовика")
    @PostMapping("model/truck")
    fun addTruckModel(
        @RequestBody value: TruckModelEntity
    ) = addEditorService.addTruckModel(value)

    @Operation(summary = "Добавление новой модели авто")
    @PostMapping("model/car")
    fun addCarModel(
        @RequestBody value: PassengersModelEntity
    ) = addEditorService.addCarModel(value)

    @Operation(summary = "Добавление новой модели маршрутного такси")
    @PostMapping("model/shuttle")
    fun addShuttleModel(
        @RequestBody value: PassengersModelEntity
    ) = addEditorService.addShuttleModel(value)

    @Operation(summary = "Добавление новой модели автобуса")
    @PostMapping("model/bus")
    fun addBusModel(
        @RequestBody value: PassengersModelEntity
    ) = addEditorService.addBusModel(value)
}