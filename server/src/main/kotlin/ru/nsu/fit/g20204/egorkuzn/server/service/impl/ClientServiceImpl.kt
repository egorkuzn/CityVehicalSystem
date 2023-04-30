package ru.nsu.fit.g20204.egorkuzn.server.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.nsu.fit.g20204.egorkuzn.server.dao.CargoVolumeStatDao
import ru.nsu.fit.g20204.egorkuzn.server.dao.DriversCarDistributionDao
import ru.nsu.fit.g20204.egorkuzn.server.dao.GarageEconomyInfoDao
import ru.nsu.fit.g20204.egorkuzn.server.service.ClientService

@Service
class ClientServiceImpl(
    @Autowired
    val cargoVolumeStatDao: CargoVolumeStatDao,
    @Autowired
    val driversCarDistributionDao: DriversCarDistributionDao,
    @Autowired
    val garageEconomyInfoDao: GarageEconomyInfoDao
) : ClientService {
    override fun getCargoVolumeStat(
        vehicleId: Long,
        dateFrom: String,
        dateTo: String
    ) = cargoVolumeStatDao.runQuery(
        vehicleId,
        dateFrom,
        dateTo
    )

    override fun getDriversCarDistribution() = driversCarDistributionDao.runQuery()

    override fun getGarageEconomyInfo() = garageEconomyInfoDao.runQuery()

    override fun getInfoAboutAutopark(): Any {
        TODO("Not yet implemented")
    }
//
//    override fun getMileageInfo(): Any {
//        TODO("Not yet implemented")
//    }
//
//    override fun getPassengerToRootsDistro(): Any {
//        TODO("Not yet implemented")
//    }
//
//    override fun getRepairsStat(): Any {
//        TODO("Not yet implemented")
//    }
//
//    override fun getVehicleAddArchive(): Any {
//        TODO("Not yet implemented")
//    }
//
//    override fun getVehicleDriversAndCount(): Any {
//        TODO("Not yet implemented")
//    }
//
//    override fun getVehicleToCompanyDistribution(): Any {
//        TODO("Not yet implemented")
//    }
//
//    override fun getWorkersHierarchyInfo(): Any {
//        TODO("Not yet implemented")
//    }
}