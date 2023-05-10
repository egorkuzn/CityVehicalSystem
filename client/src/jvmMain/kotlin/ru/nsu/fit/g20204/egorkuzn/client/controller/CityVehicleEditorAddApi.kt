package ru.nsu.fit.g20204.egorkuzn.client.controller

import retrofit2.http.Body
import retrofit2.http.POST
import ru.nsu.fit.g20204.egorkuzn.client.model.dto.editor.add.*

interface CityVehicleEditorAddApi {
    @POST("model/auxiliary")
    suspend fun addModelAuxiliary(@Body body: AddAuxiliaryModelDto): Boolean

    @POST("model/truck")
    suspend fun addModelTruck(@Body body: AddTruckModelDto): Boolean

    @POST("model/car")
    suspend fun addModelCar(@Body body: AddPassengersModelDto): Boolean

    @POST("model/shuttle")
    suspend fun addModelShuttle(@Body body: AddPassengersModelDto): Boolean

    @POST("model/bus")
    suspend fun addModelBus(@Body body: AddPassengersModelDto): Boolean
}