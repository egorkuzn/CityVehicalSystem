package ru.nsu.fit.g20204.egorkuzn.client.controller

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    val baseUrl = "http://localhost:8080/api/v1/city-vehicle-system/"

    fun getInstance() = Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}