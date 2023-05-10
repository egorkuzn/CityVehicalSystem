package ru.nsu.fit.g20204.egorkuzn.server.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.nsu.fit.g20204.egorkuzn.server.dao.info.AuxiliaryModelDao
import ru.nsu.fit.g20204.egorkuzn.server.dao.info.TruckToIdDao
import ru.nsu.fit.g20204.egorkuzn.server.service.InfoService

@Service
class InfoServiceImpl(
    @Autowired val truckToIdDao: TruckToIdDao,
    @Autowired val auxiliaryModel: AuxiliaryModelDao
): InfoService {
    override fun getTruckToId() =  truckToIdDao.runQuery()

    override fun getAuxiliaryModel() = auxiliaryModel.runQuery()
}