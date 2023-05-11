package ru.nsu.fit.g20204.egorkuzn.server.service.impl.editor

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.nsu.fit.g20204.egorkuzn.server.dao.editor.model.EditorAuxiliaryModelDao
import ru.nsu.fit.g20204.egorkuzn.server.dao.editor.model.EditorPassengersTransportDao
import ru.nsu.fit.g20204.egorkuzn.server.dao.editor.model.EditorTruckModelDao
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.editor.add.models.AuxiliaryModelEntity
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.editor.add.models.PassengersModelEntity
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.editor.add.models.TruckModelEntity
import ru.nsu.fit.g20204.egorkuzn.server.service.editor.AddEditorService

@Service
class AddEditorServiceImpl(
    @Autowired val auxiliaryModelDao: EditorAuxiliaryModelDao,
    @Autowired val truckModelDao: EditorTruckModelDao,
    @Autowired val passengersModelDao: EditorPassengersTransportDao
) : AddEditorService {
    override fun addAuxiliaryModel(value: AuxiliaryModelEntity) = auxiliaryModelDao.add(value)

    override fun addTruckModel(value: TruckModelEntity) = truckModelDao.add(value)

    override fun addCarModel(value: PassengersModelEntity) = passengersModelDao.add("Cars models", value)

    override fun addShuttleModel(value: PassengersModelEntity)= passengersModelDao.add("Shuttles models", value)

    override fun addBusModel(value: PassengersModelEntity)= passengersModelDao.add("Buses models", value)
}