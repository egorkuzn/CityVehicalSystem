package ru.nsu.fit.g20204.egorkuzn.client.view.screens.viewer.impl.ready.param

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import ru.nsu.fit.g20204.egorkuzn.client.controller.RetrofitBuilder
import ru.nsu.fit.g20204.egorkuzn.client.view.screens.viewer.AbstractParamQueryScreen
import ru.nsu.fit.g20204.egorkuzn.client.view.util.menu.MileageParamInputer

object MileageInfoQuery : AbstractParamQueryScreen(
    description = "Получение информации о пробеге"
) {
    var vehicleMap: List<Pair<String, String>> by mutableStateOf(emptyList())

    @Composable
    override fun inputContent() {
        Column {
            MileageParamInputer.paramTypeChooser(paramType)
            MileageParamInputer.paramInputer(param, paramType)
            MileageParamInputer.periodTypeChooser(periodType)
            MileageParamInputer.periodInputer(periodType, year, month, day)
        }
    }

    private val paramType = mutableStateOf("0")
    private val param = mutableStateOf("0")
    private val periodType = mutableStateOf("0")
    private val day = mutableStateOf("0")
    private val month = mutableStateOf("0")
    private val year = mutableStateOf("0")

    override fun getHead() = listOf(
        "Транспорт",
        "Пробег"
    )

    override fun getData() = runBlocking {
        launch {
            vehicleMap = RetrofitBuilder
                .apiImpl()
                .getInfoAboutAutopark()
                .map {
                    Pair(it.modelName, it.modelName.substring(it.modelName.indexOf("|") + 1))
                }
        }

        RetrofitBuilder
            .apiImpl()
            .getMileageInfo(
                paramType.value,
                param.value,
                periodType.value,
                day.value,
                month.value,
                year.value
            ).map {
                listOf(
                    it.vehicleId.toString(),
                    it.mileage.toString()
                )
            }
    }
}