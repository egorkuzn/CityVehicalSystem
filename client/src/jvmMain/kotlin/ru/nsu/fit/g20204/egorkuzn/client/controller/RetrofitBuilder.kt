package ru.nsu.fit.g20204.egorkuzn.client.controller

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.nsu.fit.g20204.egorkuzn.client.controller.editor.CityVehicleEditorAddApi
import ru.nsu.fit.g20204.egorkuzn.client.controller.editor.CityVehicleEditorDeleteApi
import ru.nsu.fit.g20204.egorkuzn.client.controller.editor.CityVehicleEditorUpdateApi

object RetrofitBuilder {
    val baseUrl = "http://localhost:8080/api/v1/city-vehicle-system/"

    private val editorBaseUrl = baseUrl + "editor/"
    private val queryBaseUrl = baseUrl + "query/"
    private val infoBaseUrl = baseUrl + "info/"

    fun queryApi() = Retrofit
        .Builder()
        .baseUrl(queryBaseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CityVehicleQueryApi::class.java)

    fun infoApi() = Retrofit
        .Builder()
        .baseUrl(infoBaseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CityVehicleInfoApi::class.java)

    fun editorAddApi() = Retrofit
        .Builder()
        .baseUrl(editorBaseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CityVehicleEditorAddApi::class.java)

    fun editorDeleteApi() = Retrofit
        .Builder()
        .baseUrl(editorBaseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CityVehicleEditorDeleteApi::class.java)

    fun editorUpdateApi() = Retrofit
        .Builder()
        .baseUrl(editorBaseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CityVehicleEditorUpdateApi::class.java)
}