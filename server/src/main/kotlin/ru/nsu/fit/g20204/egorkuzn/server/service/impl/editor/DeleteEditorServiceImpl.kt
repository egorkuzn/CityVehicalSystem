package ru.nsu.fit.g20204.egorkuzn.server.service.impl.editor

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.nsu.fit.g20204.egorkuzn.server.dao.editor.model.EditorAuxiliaryModelDao
import ru.nsu.fit.g20204.egorkuzn.server.dao.editor.model.EditorPassengersTransportDao
import ru.nsu.fit.g20204.egorkuzn.server.dao.editor.model.EditorTruckModelDao
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.editor.add.models.AuxiliaryModelEntity
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.editor.add.models.PassengersModelEntity
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.editor.add.models.TruckModelEntity
import ru.nsu.fit.g20204.egorkuzn.server.service.editor.DeleteEditorService

@Service
class DeleteEditorServiceImpl(
    @Autowired val auxiliaryModelDao: EditorAuxiliaryModelDao,
    @Autowired val truckModelDao: EditorTruckModelDao,
    @Autowired val passengersModelDao: EditorPassengersTransportDao
): DeleteEditorService{
    override fun deleteAuxiliaryModel(value: AuxiliaryModelEntity) = auxiliaryModelDao.delete(value)

    override fun deleteTruckModel(value: TruckModelEntity) = truckModelDao.delete(value)

    override fun deleteCarModel(value: PassengersModelEntity) = passengersModelDao.delete(
        "Cars models",
        "car",
        value
    )

    override fun deleteShuttleModel(value: PassengersModelEntity) = passengersModelDao.delete(
        "Shuttles models",
        "shuttle",
        value
    )

    override fun deleteBusModel(value: PassengersModelEntity) = passengersModelDao.delete(
        "Buses models",
        "bus",
        value
    )
}