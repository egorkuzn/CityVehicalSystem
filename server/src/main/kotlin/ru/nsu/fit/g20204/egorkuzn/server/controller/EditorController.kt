package ru.nsu.fit.g20204.egorkuzn.server.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.editor.add.AddAuxiliaryModelEntity
import ru.nsu.fit.g20204.egorkuzn.server.service.AddEditorService

@RestController
@Tag(name = "Модификация таблицы")
@RequestMapping("api/v1/city-vehicle-system/editor/add")
class EditorController(@Autowired val addEditorService: AddEditorService) {
    @Operation(summary = "Добавление новой модели спец транспорта")
    @PostMapping("model/auxiliary")
    fun addAuxiliaryModel(
        @RequestBody values: List<AddAuxiliaryModelEntity>
    ) = addEditorService.addAuxiliaryModel(values)
}