package ru.nsu.fit.g20204.egorkuzn.server.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.nsu.fit.g20204.egorkuzn.server.dao.info.*
import ru.nsu.fit.g20204.egorkuzn.server.service.InfoService

@Service
class InfoServiceImpl(
    @Autowired val truckToIdDao: InfoTruckToIdDao,
    @Autowired val auxiliaryModelDao: InfoAuxiliaryModelDao,
    @Autowired val busModelDao: InfoBusModelDao,
    @Autowired val carModelDao: InfoCarModelDao,
    @Autowired val shuttleModelDao: InfoShuttleModelDao,
    @Autowired val truckModelDao: InfoTruckModelDao
): InfoService {
    override fun getTruckToId() =  truckToIdDao.runQuery()

    override fun getAuxiliaryModel() = auxiliaryModelDao.runQuery()

    override fun getBusModel() = busModelDao.runQuery()

    override fun getCarModel() = carModelDao.runQuery()

    override fun getShuttleModel() = shuttleModelDao.runQuery()

    override fun getTruckModel() = truckModelDao.runQuery()
}