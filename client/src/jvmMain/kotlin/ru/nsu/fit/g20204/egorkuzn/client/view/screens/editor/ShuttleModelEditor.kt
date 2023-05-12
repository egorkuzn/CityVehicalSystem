package ru.nsu.fit.g20204.egorkuzn.client.view.screens.editor

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.HttpException
import ru.nsu.fit.g20204.egorkuzn.client.controller.RetrofitBuilder
import ru.nsu.fit.g20204.egorkuzn.client.model.dto.editor.add.PassengersModelDto
import ru.nsu.fit.g20204.egorkuzn.client.view.util.field.IntField
import ru.nsu.fit.g20204.egorkuzn.client.view.util.field.StringField

object ShuttleModelEditor : AbstractEditorScreen("Модели маршруток") {
    @Composable
    override fun updateContent() {
    }

    @Composable
    override fun deleteContent() {
        val deleterErrorFlag = remember { mutableStateOf(false) }
        val scope = rememberCoroutineScope()

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                StringField.render("Название модели", modelName, deleterErrorFlag)
                IntField.render("Описание", modelCapacity, deleterErrorFlag)
            }

            addSendButton(scope, deleterErrorFlag)
        }
    }

    private val modelName = mutableStateOf("")
    private val modelCapacity = mutableStateOf(0)

    @Composable
    override fun addContent() {
        val adderErrorFlag = remember { mutableStateOf(false) }
        val scope = rememberCoroutineScope()

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                StringField.render("Название модели", modelName, adderErrorFlag)
                IntField.render("Вместимость", modelCapacity, adderErrorFlag)
            }

            sendButton(scope, adderErrorFlag)
        }
    }

    @Composable
    fun sendButton(scope: CoroutineScope, adderErrorFlag: MutableState<Boolean>) {


        IconButton(
            onClick = {
                scope.launch {
                    try {
                        adderErrorFlag.value = !RetrofitBuilder
                            .editorAddApi()
                            .addModelShuttle(
                                PassengersModelDto(
                                    modelName.value,
                                    modelCapacity.value
                                )
                            )
                    } catch (e: HttpException) {
                        println(e.response())
                        adderErrorFlag.value = true
                    }
                }
            },
            content = { Icon(imageVector = Icons.Filled.Send, contentDescription = " ") }
        )
    }

    @Composable
    fun addSendButton(scope: CoroutineScope, deleterErrorFlag: MutableState<Boolean>) {
        IconButton(
            onClick = {
                scope.launch {
                    try {
                        deleterErrorFlag.value = !RetrofitBuilder
                            .editorDeleteApi()
                            .deleteModelShuttle(
                                PassengersModelDto(
                                    modelName.value,
                                    modelCapacity.value
                                )
                            )
                    } catch (e: HttpException) {
                        println(e.response())
                        deleterErrorFlag.value = true
                    }
                }
            },
            content = { Icon(imageVector = Icons.Filled.Send, contentDescription = " ") }
        )
    }

    override fun getHead() = listOf(
        "Название модели",
        "Число пассажиров"
    )

    override fun getData() = runBlocking {
        RetrofitBuilder
            .infoApi()
            .getShuttleModel()
            .map {
                listOf(
                    it.modelName,
                    it.capacity.toString()
                )
            }
    }
}