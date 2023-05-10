package ru.nsu.fit.g20204.egorkuzn.client.view.screens.viewer.impl.ready.noparam

import kotlinx.coroutines.runBlocking
import ru.nsu.fit.g20204.egorkuzn.client.controller.RetrofitBuilder
import ru.nsu.fit.g20204.egorkuzn.client.view.screens.viewer.AbstractNoParamQueryScreen

object GarageEconomyInfoQuery: AbstractNoParamQueryScreen(
    description = "Получение информации о гаражном хозяйстве"
) {

    override fun getHead() = listOf(
        "Адрес",
        "Такси",
        "Грузовики",
        "Легковые автомобили",
        "Маршрутки",
        "Автобусы",
        "Специализированный транспорт"
    )

    override fun getData() = runBlocking {
        RetrofitBuilder
            .queryApi()
            .getGarageEconomyInfo()
            .map {
                listOf(
                    it.garageAddress,
                    it.taxiCount.toString(),
                    it.truckCount.toString(),
                    it.carCount.toString(),
                    it.shuttleCount.toString(),
                    it.busCount.toString(),
                    it.auxiliaryCount.toString()
                )
            }
    }
}