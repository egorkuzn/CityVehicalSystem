package ru.nsu.fit.g20204.egorkuzn.client.controller.editor

import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.HTTP
import ru.nsu.fit.g20204.egorkuzn.client.model.dto.editor.add.AuxiliaryModelDto
import ru.nsu.fit.g20204.egorkuzn.client.model.dto.editor.add.PassengersModelDto
import ru.nsu.fit.g20204.egorkuzn.client.model.dto.editor.add.TruckModelDto

interface CityVehicleEditorDeleteApi {
    @HTTP(method = "DELETE", path = "model/auxiliary", hasBody = true)
    suspend fun deleteModelAuxiliary(@Body body: AuxiliaryModelDto): Boolean

    @HTTP(method = "DELETE", path = "model/truck", hasBody = true)
    suspend fun deleteModelTruck(@Body body: TruckModelDto): Boolean

    @HTTP(method = "DELETE", path = "model/car", hasBody = true)
    suspend fun deleteModelCar(@Body body: PassengersModelDto): Boolean

    @HTTP(method = "DELETE", path = "model/shuttle", hasBody = true)
    suspend fun deleteModelShuttle(@Body body: PassengersModelDto): Boolean

    @HTTP(method = "DELETE", path = "model/bus", hasBody = true)
    suspend fun deleteModelBus(@Body body: PassengersModelDto): Boolean
}