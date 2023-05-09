package ru.nsu.fit.g20204.egorkuzn.client.view.screens.viewer.impl.ready.noparam

import kotlinx.coroutines.runBlocking
import ru.nsu.fit.g20204.egorkuzn.client.controller.RetrofitBuilder
import ru.nsu.fit.g20204.egorkuzn.client.view.screens.viewer.AbstractNoParamQueryScreen

object WorkersHierarchyInfoQuery: AbstractNoParamQueryScreen(
    description = "Получить данные о подчиненности персонала: рабочие, бригадиры, мастера, начальники участков и цехов"
) {

    override fun getHead() = listOf(
        "Работник",
        "Бригада",
        "Брагадир",
        "Мастер",
        "Название цеха",
        "Начальник цеха",
        "Название участка",
        "Начальник участка"
    )

    override fun getData() = runBlocking {
        RetrofitBuilder
            .apiImpl()
            .getWorkersHierarchyInfo()
            .map {
                listOf(
                    it.worker,
                    it.brigade,
                    it.brigadier,
                    it.master,
                    it.disName,
                    it.disHead,
                    it.depName,
                    it.depHead
                )
            }
    }
}