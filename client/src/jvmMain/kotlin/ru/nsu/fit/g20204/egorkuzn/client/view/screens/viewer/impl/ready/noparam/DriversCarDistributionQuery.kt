package ru.nsu.fit.g20204.egorkuzn.client.view.screens.viewer.impl.ready.noparam

import kotlinx.coroutines.runBlocking
import ru.nsu.fit.g20204.egorkuzn.client.controller.RetrofitBuilder
import ru.nsu.fit.g20204.egorkuzn.client.view.screens.viewer.AbstractNoParamQueryScreen

object DriversCarDistributionQuery: AbstractNoParamQueryScreen(
    description = "Получение распределения водителей по транспорту"
) {
    override fun getHead() = listOf(
        "Транспорт",
        "Число водителей"
    )

    override fun getData() = runBlocking {
        RetrofitBuilder
            .apiImpl()
            .getDriversCarDistribution()
            .map {
                listOf(
                    it.transport,
                    it.driversCountToCar.toString()
                )
            }
    }
}
