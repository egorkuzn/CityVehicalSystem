package ru.nsu.fit.g20204.egorkuzn.client.controller

import retrofit2.http.GET
import ru.nsu.fit.g20204.egorkuzn.client.model.dto.info.*

interface CityVehicleInfoApi {
    @GET("model/truck")
    suspend fun getTruckToVehicleId(): List<TruckToIdDto>

    @GET("model/auxiliary")
    suspend fun getAuxiliaryModel(): List<AuxiliaryModelDto>
}