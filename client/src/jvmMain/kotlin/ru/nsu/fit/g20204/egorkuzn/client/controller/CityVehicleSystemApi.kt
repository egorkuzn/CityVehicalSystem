package ru.nsu.fit.g20204.egorkuzn.client.controller

import retrofit2.http.GET
import retrofit2.http.Query
import ru.nsu.fit.g20204.egorkuzn.client.model.dto.map.TruckToIdDto
import ru.nsu.fit.g20204.egorkuzn.client.model.dto.query.*

interface CityVehicleSystemApi {
    @GET("cargo-volume-stat")
    suspend fun getCargoVolumeStat(
        @Query("vehicleId") vehicleId: Long,
        @Query("dateFrom") dateFrom: String,
        @Query("dateTo") dateTo: String
    ): List<CargoVolumeStatDto>

    @GET("drivers-to-car-distribution")
    suspend fun getDriversCarDistribution(): List<DriversCarDistributionDto>

    @GET("garage-economy-info")
    suspend fun gatGarageEconomyInfo(): List<GarageEconomyInfoDto>

    @GET("info_about_autopark")
    suspend fun getInfoAboutAutopark(): List<InfoAboutAutoparkDto>

    @GET("mileage_info")
    suspend fun getMileageInfo(
        @Query("paramType") paramType: String,
        @Query("param") param: String,
        @Query("periodType") periodType: String,
        @Query("day") day: String,
        @Query("month") month: String,
        @Query("year") year: String
    ): List<MileageInfoDto>

    @GET("passangers_to_roats_distr")
    suspend fun getPassengerToRootsDistro(): List<PassengersToRoutsDto>

    @GET("repairs_stat_transport")
    suspend fun getRepairsStatTransport(
        @Query("paramType") paramType: String,
        @Query("param") param: String,
        @Query("fromDate") fromDate: String,
        @Query("toDate") toDate: String
    ): List<RepairsStatTransportDto>

    @GET("repairs_stat_node")
    suspend fun getRepairsStatNode(
        @Query("paramType") paramType: String,
        @Query("param") param: String,
        @Query("fromDate") fromDate: String,
        @Query("toDate") toDate: String
    ): List<RepairsStatNodeDto>

    @GET("repairs_stat_engineer")
    suspend fun getRepairsStatEngineer(
        @Query("vehicleId") vehicleId: Long,
        @Query("specialisation") specialisation: String,
        @Query("fromDate") fromDate: String,
        @Query("toDate") toDate: String
    ): List<RepairsStatEngineerDto>

    @GET("vehicle_add_archive")
    suspend fun getVehicleAddArchive(
        @Query("fromYear") fromYear: String,
        @Query("toYear") toYear: String
    ): List<VehicleAddArchiveDto>

    @GET("vehicle_drivers_and_count")
    suspend fun getVehicleDriversAndCount(
        @Query("vehicleId") vehicleId: Long
    ): List<VehicleDriversAndCountDto>

    @GET("vehicle_to_company_distribution")
    suspend fun getVehicleToCompanyDistribution(): List<VehicleToCompanyDistributionDto>

    @GET("workers_hierarchy_info_all")
    suspend fun getWorkersHierarchyInfo(): List<WorkersHierarchyInfoDto>

    @GET("workers_hierarchy_info_manager")
    suspend fun getWorkersHierarchyInfoManager(
        @Query("managerId") managerId: Long
    ): List<WorkersHierarchyInfoManagerDto>

    @GET("model/truck")
    suspend fun getTruckToVehicleId(): List<TruckToIdDto>
}