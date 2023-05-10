package ru.nsu.fit.g20204.egorkuzn.client.controller

import retrofit2.http.GET
import ru.nsu.fit.g20204.egorkuzn.client.model.dto.info.*

interface CityVehicleInfoApi {
    @GET("model/truck-vehicle")
    suspend fun getTruckToVehicleId(): List<TruckToIdDto>

    @GET("model/auxiliary")
    suspend fun getAuxiliaryModel(): List<AuxiliaryModelDto>

    @GET("model/bus")
    suspend fun getBusModel(): List<PassengersDto>

    @GET("model/car")
    suspend fun getCarModel(): List<PassengersDto>

    @GET("model/shuttle")
    suspend fun getShuttleModel(): List<PassengersDto>

    @GET("model/truck")
    suspend fun getTruckModel(): List<TruckModelDto>
}