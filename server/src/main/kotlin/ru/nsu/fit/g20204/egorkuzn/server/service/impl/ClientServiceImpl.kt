package ru.nsu.fit.g20204.egorkuzn.server.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.nsu.fit.g20204.egorkuzn.server.dao.*
import ru.nsu.fit.g20204.egorkuzn.server.service.ClientService

@Service
class ClientServiceImpl(
    @Autowired
    val cargoVolumeStatDao: CargoVolumeStatDao,
    @Autowired
    val driversCarDistributionDao: DriversCarDistributionDao,
    @Autowired
    val garageEconomyInfoDao: GarageEconomyInfoDao,
    @Autowired
    val infoAboutAutoparkDao: InfoAboutAutoparkDao,
    @Autowired
    val mileageInfoDao: MileageInfoDao,
    @Autowired
    val passengersToRoatsDistrDao: PassengersToRoutsDistrDao,
    @Autowired
    val repairsStatTransportDao: RepairsStatTransportDao,
    @Autowired
    val repairsStatNodeDao: RepairsStatNodeDao,
    @Autowired
    val repairsStatEngineerDao: RepairsStatEngineerDao
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

    override fun getInfoAboutAutopark() = infoAboutAutoparkDao.runQuery()

    override fun getMileageInfo(
        paramType: String,
        param: String,
        periodType: String,
        day: String,
        month: String,
        year: String
    ) = mileageInfoDao.runQuery(
        paramType,
        param,
        periodType,
        day,
        month,
        year
    )

    override fun getPassengerToRootsDistro() = passengersToRoatsDistrDao.runQuery()

    override fun getRepairsStatTransport(
        paramType: String,
        param: String,
        fromDate: String,
        toDate: String
    ) = repairsStatTransportDao.runQuery(
        paramType,
        param,
        fromDate,
        toDate
    )

    override fun getRepairsStatNode(
        paramType: String,
        param: String,
        fromDate: String,
        toDate: String
    ) = repairsStatNodeDao.runQuery(
        paramType,
        param,
        fromDate,
        toDate
    )

    override fun getRepairsStatEngineer(
        vehicleId: Long,
        specialisation: String,
        fromDate: String,
        toDate: String
    ) = repairsStatEngineerDao.runQuery(
        vehicleId,
        specialisation,
        fromDate,
        toDate
    )
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