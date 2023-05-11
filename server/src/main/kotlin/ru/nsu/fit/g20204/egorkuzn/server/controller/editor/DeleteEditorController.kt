package ru.nsu.fit.g20204.egorkuzn.server.controller.editor

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.editor.add.models.AuxiliaryModelEntity
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.editor.add.models.PassengersModelEntity
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.editor.add.models.TruckModelEntity
import ru.nsu.fit.g20204.egorkuzn.server.service.editor.DeleteEditorService

@RestController
@Tag(name = "Модификация таблицы")
@RequestMapping("api/v1/city-vehicle-system/editor")
class DeleteEditorController(@Autowired val deleteEditorService: DeleteEditorService) {
    @Operation(summary = "Добавление новой модели спец транспорта")
    @DeleteMapping("model/auxiliary")
    fun addAuxiliaryModel(
        @RequestBody value: AuxiliaryModelEntity
    ) = deleteEditorService.deleteAuxiliaryModel(value)

    @Operation(summary = "Добавление новой модели грузовика")
    @DeleteMapping("model/truck")
    fun addTruckModel(
        @RequestBody value: TruckModelEntity
    ) = deleteEditorService.deleteTruckModel(value)

    @Operation(summary = "Добавление новой модели авто")
    @DeleteMapping("model/car")
    fun addCarModel(
        @RequestBody value: PassengersModelEntity
    ) = deleteEditorService.deleteCarModel(value)

    @Operation(summary = "Добавление новой модели маршрутного такси")
    @DeleteMapping("model/shuttle")
    fun addShuttleModel(
        @RequestBody value: PassengersModelEntity
    ) = deleteEditorService.deleteShuttleModel(value)

    @Operation(summary = "Добавление новой модели автобуса")
    @DeleteMapping("model/bus")
    fun addBusModel(
        @RequestBody value: PassengersModelEntity
    ) = deleteEditorService.deleteBusModel(value)
}