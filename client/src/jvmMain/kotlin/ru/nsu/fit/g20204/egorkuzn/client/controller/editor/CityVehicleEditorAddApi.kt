package ru.nsu.fit.g20204.egorkuzn.client.controller.editor

import retrofit2.http.Body
import retrofit2.http.POST
import ru.nsu.fit.g20204.egorkuzn.client.model.dto.editor.add.*

interface CityVehicleEditorAddApi {
    @POST("model/auxiliary")
    suspend fun addModelAuxiliary(@Body body: AuxiliaryModelDto): Boolean

    @POST("model/truck")
    suspend fun addModelTruck(@Body body: TruckModelDto): Boolean

    @POST("model/car")
    suspend fun addModelCar(@Body body: PassengersModelDto): Boolean

    @POST("model/shuttle")
    suspend fun addModelShuttle(@Body body: PassengersModelDto): Boolean

    @POST("model/bus")
    suspend fun addModelBus(@Body body: PassengersModelDto): Boolean
}