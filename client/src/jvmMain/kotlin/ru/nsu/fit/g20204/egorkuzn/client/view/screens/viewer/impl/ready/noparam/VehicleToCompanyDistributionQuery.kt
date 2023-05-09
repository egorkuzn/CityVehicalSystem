package ru.nsu.fit.g20204.egorkuzn.client.view.screens.viewer.impl.ready.noparam

import kotlinx.coroutines.runBlocking
import ru.nsu.fit.g20204.egorkuzn.client.controller.RetrofitBuilder
import ru.nsu.fit.g20204.egorkuzn.client.view.screens.viewer.AbstractNoParamQueryScreen

object VehicleToCompanyDistributionQuery: AbstractNoParamQueryScreen(
    description = "Получить данные о распределении автотранспорта на предприятии"
) {

    override fun getHead() = listOf(
        "Грузовик",
        "Такси",
        "Автобус",
        "Маршрутка",
        "Авто",
        "Спец транспорт"
    )

    override fun getData() = runBlocking {
        RetrofitBuilder
            .apiImpl()
            .getVehicleToCompanyDistribution()
            .map {
                with(it) {
                         listOf(
                             truckDistribution.toString(),
                             taxiDistribution.toString(),
                             busDistribution.toString(),
                             shuttleDistribution.toString(),
                             carDistribution.toString(),
                             auxilliaryDistribution.toString()
                         )
                }
            }
    }

}
