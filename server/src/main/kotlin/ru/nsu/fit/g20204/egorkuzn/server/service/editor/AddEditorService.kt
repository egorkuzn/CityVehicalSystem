package ru.nsu.fit.g20204.egorkuzn.server.service.editor

import ru.nsu.fit.g20204.egorkuzn.server.model.entity.editor.add.models.AddAuxiliaryModelEntity
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.editor.add.models.AddPassengersModelEntity
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.editor.add.models.AddTruckModelEntity

interface AddEditorService {
    fun addAuxiliaryModel(value: AddAuxiliaryModelEntity): Boolean

    fun addTruckModel(value: AddTruckModelEntity): Boolean

    fun addCarModel(value: AddPassengersModelEntity): Boolean

    fun addShuttleModel(value: AddPassengersModelEntity): Boolean

    fun addBusModel(value: AddPassengersModelEntity): Boolean
}