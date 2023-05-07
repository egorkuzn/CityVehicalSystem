package ru.nsu.fit.g20204.egorkuzn.client.view.screens.viewer.impl.ready.param

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import kotlinx.coroutines.runBlocking
import ru.nsu.fit.g20204.egorkuzn.client.controller.RetrofitBuilder
import ru.nsu.fit.g20204.egorkuzn.client.view.screens.viewer.AbstractParamQueryScreen
import ru.nsu.fit.g20204.egorkuzn.client.view.util.menu.MileageParamInputer

object MileageInfoQuery : AbstractParamQueryScreen(
    description = "Получение информации о пробеге"
) {
    @Composable
    override fun inputContent() {
        MileageParamInputer.paramTypeChooser(paramType)
        MileageParamInputer.paramInputer(param, paramType)
    }

    private val paramType = mutableStateOf("")
    private val param = mutableStateOf("")
    private val periodType = mutableStateOf("")
    private val day = mutableStateOf("")
    private val month = mutableStateOf("")
    private val year = mutableStateOf("")

    override fun getHead() = listOf(
        "Транспорт",
        "Пробег"
    )

    override fun getData() = runBlocking {
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