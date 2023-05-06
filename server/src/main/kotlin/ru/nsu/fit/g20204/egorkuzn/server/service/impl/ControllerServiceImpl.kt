package ru.nsu.fit.g20204.egorkuzn.server.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.nsu.fit.g20204.egorkuzn.server.dao.map.TruckToIdDao
import ru.nsu.fit.g20204.egorkuzn.server.service.ControllerService

@Service
class ControllerServiceImpl(
    @Autowired val truckToIdDao: TruckToIdDao
): ControllerService {
    override fun getTruckToId() =  truckToIdDao.runQuery()
}