package ru.nsu.fit.g20204.egorkuzn.client.controller

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    val baseUrl = "http://localhost:8080/api/v1/city-vehicle-system/"

    val queryBaseUrl = baseUrl + "query/"
    val editorAddBaseUrl = baseUrl + "editor/add/"
    val infoBaseUrl = baseUrl + "info/"

    fun queryApi() = Retrofit
        .Builder()
        .baseUrl(queryBaseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CityVehicleQueryApi::class.java)

    fun editorAddApi() = Retrofit
        .Builder()
        .baseUrl(editorAddBaseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CityVehicleEditorAddApi::class.java)

    fun infoApi() = Retrofit
        .Builder()
        .baseUrl(infoBaseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CityVehicleInfoApi::class.java)
}