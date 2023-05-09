package ru.nsu.fit.g20204.egorkuzn.client.view.screens.viewer.impl.ready.noparam

import kotlinx.coroutines.runBlocking
import ru.nsu.fit.g20204.egorkuzn.client.controller.RetrofitBuilder
import ru.nsu.fit.g20204.egorkuzn.client.view.screens.viewer.AbstractNoParamQueryScreen

object PassengersToRoutsQuery: AbstractNoParamQueryScreen(
    description = "Получение информации о распределении пассажирского транспорта по маршрутам"
){
    override fun getHead() = listOf(
        "Название маршрута",
        "Количество транспорта"
    )

    override fun getData() = runBlocking {
        RetrofitBuilder
            .apiImpl()
            .getPassengerToRoutsDistro()
            .map {
                listOf(
                    it.routName,
                    it.transportCount.toString()
                )
            }
    }
}