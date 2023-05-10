package ru.nsu.fit.g20204.egorkuzn.server.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.nsu.fit.g20204.egorkuzn.server.dao.info.*
import ru.nsu.fit.g20204.egorkuzn.server.service.InfoService

@Service
class InfoServiceImpl(
    @Autowired val truckToIdDao: TruckToIdDao,
    @Autowired val auxiliaryModelDao: AuxiliaryModelDao,
    @Autowired val busModelDao: BusModelDao,
    @Autowired val autoModelDao: AutoModelDao,
    @Autowired val shuttleModelDao: ShuttleModelDao,
    @Autowired val truckModelDao: TruckModelDao
): InfoService {
    override fun getTruckToId() =  truckToIdDao.runQuery()

    override fun getAuxiliaryModel() = auxiliaryModelDao.runQuery()

    override fun getBusModel() = busModelDao.runQuery()

    override fun getAutoModel() = autoModelDao.runQuery()

    override fun getShuttleModel() = shuttleModelDao.runQuery()

    override fun getTruckModel() = truckModelDao.runQuery()
}