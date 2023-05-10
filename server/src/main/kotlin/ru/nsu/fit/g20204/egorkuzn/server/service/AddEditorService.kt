package ru.nsu.fit.g20204.egorkuzn.server.service

import ru.nsu.fit.g20204.egorkuzn.server.model.entity.editor.add.AddAuxiliaryModelEntity

interface AddEditorService {
     fun addAuxiliaryModel(list: List<AddAuxiliaryModelEntity>): Boolean
}