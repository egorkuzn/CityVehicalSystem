package ru.nsu.fit.g20204.egorkuzn.client.controller

import retrofit2.http.GET
import retrofit2.http.Query

interface CityVehicleSystemApi {
    @GET("cargo-volume-stat")
    fun getCargoVolumeStat(
        @Query("vehicleId") vehicleId: Long,
        @Query("dateFrom") dateFrom: String,
        @Query("dateTo") dateTo: String
    ): List<>

    @GET("drivers-to-car-distribution")
    fun getDriversCarDistribution(): List<>

    @GET("garage-economy-info")
    fun gatGarageEconomyInfo(): List<>

    @GET("info_about_autopark")
    fun getInfoAboutAutopark(): List<>

    @GET("mileage_info")
    fun getMileageInfo(
        @Query("paramType") paramType: String,
        @Query("param") param: String,
        @Query("periodType") periodType: String,
        @Query("day") day: String,
        @Query("month") month: String,
        @Query("year") year: String
    ): List<>

    @GET("passangers_to_roats_distr")
    fun getPassengerToRootsDistro(): List<>

    @GET("repairs_stat_transport")
    fun getRepairsStatTransport(
        @Query("paramType") paramType: String,
        @Query("param") param: String,
        @Query("fromDate") fromDate: String,
        @Query("toDate") toDate: String
    ): List<>

    @GET("repairs_stat_node")
    fun getRepairsStatNode(
        @Query("paramType") paramType: String,
        @Query("param") param: String,
        @Query("fromDate") fromDate: String,
        @Query("toDate") toDate: String
    ): List<>

    @GET("repairs_stat_engineer")
    fun getRepairsStatEngineer(
        @Query("vehicleId") vehicleId: Long,
        @Query("specialisation") specialisation: String,
        @Query("fromDate") fromDate: String,
        @Query("toDate") toDate: String
    ): List<>

    @GET("vehicle_add_archive")
    fun getVehicleAddArchive(
        @Query("fromYear") fromYear: String,
        @Query("toYear") toYear: String
    ): List<>

    @GET("vehicle_drivers_and_count")
    fun getVehicleDriversAndCount(
        @Query("vehicleId") vehicleId: Long
    ): List<>

    @GET("vehicle_to_company_distribution")
    fun getVehicleToCompanyDistribution(): List<>

    @GET("workers_hierarchy_info_all")
    fun getWorkersHierarchyInfo(): List<>

    @GET("workers_hierarchy_info_manager")
    fun getWorkersHierarchyInfoManager(
        @Query("managerId") managerId: Long
    ): List<>
}