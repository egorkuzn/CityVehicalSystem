package ru.nsu.fit.g20204.egorkuzn.server.service.impl.editor

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.nsu.fit.g20204.egorkuzn.server.dao.editor.add.model.AuxiliaryModelDao
import ru.nsu.fit.g20204.egorkuzn.server.dao.editor.add.model.PassengersTransportDao
import ru.nsu.fit.g20204.egorkuzn.server.dao.editor.add.model.TruckModelDao
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.editor.add.models.AddAuxiliaryModelEntity
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.editor.add.models.AddPassengersModelEntity
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.editor.add.models.AddTruckModelEntity
import ru.nsu.fit.g20204.egorkuzn.server.service.editor.AddEditorService

@Service
class AddEditorServiceImpl(
    @Autowired val auxiliaryModelDao: AuxiliaryModelDao,
    @Autowired val truckModelDao: TruckModelDao,
    @Autowired val passengersModelDao: PassengersTransportDao
) : AddEditorService {
    override fun addAuxiliaryModel(value: AddAuxiliaryModelEntity) = auxiliaryModelDao.add(value)

    override fun addTruckModel(value: AddTruckModelEntity) = truckModelDao.add(value)

    override fun addCarModel(value: AddPassengersModelEntity) = passengersModelDao.add("Cars models", value)

    override fun addShuttleModel(value: AddPassengersModelEntity)= passengersModelDao.add("Shuttles models", value)

    override fun addBusModel(value: AddPassengersModelEntity)= passengersModelDao.add("Buses models", value)
}