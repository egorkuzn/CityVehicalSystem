package ru.nsu.fit.g20204.egorkuzn.server.service.editor

import ru.nsu.fit.g20204.egorkuzn.server.model.entity.editor.add.models.AuxiliaryModelEntity
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.editor.add.models.PassengersModelEntity
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.editor.add.models.TruckModelEntity

interface AddEditorService {
    fun addAuxiliaryModel(value: AuxiliaryModelEntity): Boolean

    fun addTruckModel(value: TruckModelEntity): Boolean

    fun addCarModel(value: PassengersModelEntity): Boolean

    fun addShuttleModel(value: PassengersModelEntity): Boolean

    fun addBusModel(value: PassengersModelEntity): Boolean
}