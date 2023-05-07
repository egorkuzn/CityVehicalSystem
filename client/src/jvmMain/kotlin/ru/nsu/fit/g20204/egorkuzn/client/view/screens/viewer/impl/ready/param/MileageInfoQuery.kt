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
            val coroutineScope = rememberCoroutineScope()
            MileageParamInputer.paramTypeChooser(paramType)

            LaunchedEffect(vehicleMap.isEmpty()) {
                coroutineScope.launch {
                    vehicleMap = RetrofitBuilder
                        .apiImpl()
                        .getInfoAboutAutopark()
                        .map {
                            Pair(it.modelName, it.modelName.substring(it.modelName.indexOf("|") + 1))
                        }
                }
            }

            MileageParamInputer.paramInputer(param, paramType)
        }
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