package ru.nsu.fit.g20204.egorkuzn.server.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.nsu.fit.g20204.egorkuzn.server.dao.editor.add.model.AddAuxiliaryModelDao
import ru.nsu.fit.g20204.egorkuzn.server.dao.editor.add.model.AddPassengersTransportDao
import ru.nsu.fit.g20204.egorkuzn.server.dao.editor.add.model.AddTruckModelDao
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.editor.add.models.AddAuxiliaryModelEntity
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.editor.add.models.AddPassengersModelEntity
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.editor.add.models.AddTruckModelEntity
import ru.nsu.fit.g20204.egorkuzn.server.service.AddEditorService

@Service
class AddEditorServiceImpl(
    @Autowired val addAuxiliaryModelDao: AddAuxiliaryModelDao,
    @Autowired val addTruckModelDao: AddTruckModelDao,
    @Autowired val addPassengersModelDao: AddPassengersTransportDao
) : AddEditorService {
    override fun addAuxiliaryModel(value: AddAuxiliaryModelEntity) = addAuxiliaryModelDao.sqlRun(value)

    override fun addTruckModel(value: AddTruckModelEntity) = addTruckModelDao.sqlRun(value)

    override fun addCarModel(value: AddPassengersModelEntity) = addPassengersModelDao.sqlRun("Cars models", value)

    override fun addShuttleModel(value: AddPassengersModelEntity)= addPassengersModelDao.sqlRun("Shuttles models", value)

    override fun addBusModel(value: AddPassengersModelEntity)= addPassengersModelDao.sqlRun("Buses models", value)
}