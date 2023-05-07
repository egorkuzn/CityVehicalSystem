package ru.nsu.fit.g20204.egorkuzn.client.view.screens.viewer.impl.ready.noparam

import kotlinx.coroutines.runBlocking
import ru.nsu.fit.g20204.egorkuzn.client.controller.RetrofitBuilder
import ru.nsu.fit.g20204.egorkuzn.client.view.screens.viewer.AbstractNoParamQueryScreen

object InfoAboutAutoparkQuery: AbstractNoParamQueryScreen(
    description = "Получение информации об автопарке предприятия"
) {

    override fun getHead() = listOf(
        "Транспорт"
    )

    override fun getData() = runBlocking {
        RetrofitBuilder
            .apiImpl()
            .getInfoAboutAutopark()
            .map{
                listOf(it.modelName)
            }
    }
}