package ru.nsu.fit.g20204.egorkuzn.server.service.editor

import ru.nsu.fit.g20204.egorkuzn.server.model.entity.editor.add.models.AuxiliaryModelEntity
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.editor.add.models.PassengersModelEntity
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.editor.add.models.TruckModelEntity

interface DeleteEditorService {
    fun deleteAuxiliaryModel(value: AuxiliaryModelEntity): Boolean

    fun deleteTruckModel(value: TruckModelEntity): Boolean
    
    fun deleteCarModel(value: PassengersModelEntity): Boolean
    
    fun deleteShuttleModel(value: PassengersModelEntity): Boolean
    
    fun deleteBusModel(value: PassengersModelEntity): Boolean
}