package ru.nsu.fit.g20204.egorkuzn.server.controller.editor

import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RestController

@RestController
@Tag(name = "Модификация таблицы")
class DeleteEditorController(@Autowired val deleteEditorService: DeleteEditorService) {

}