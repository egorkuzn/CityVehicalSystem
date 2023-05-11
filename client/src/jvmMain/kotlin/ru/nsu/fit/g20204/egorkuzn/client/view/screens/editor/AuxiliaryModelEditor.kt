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
import ru.nsu.fit.g20204.egorkuzn.client.model.dto.editor.add.AddAuxiliaryModelDto
import ru.nsu.fit.g20204.egorkuzn.client.view.util.field.StringField

object AuxiliaryModelEditor : AbstractEditorScreen("Модели специализированного транспорта") {
    @Composable
    override fun updateContent() {
    }

    @Composable
    override fun deleteContent() {
    }

    private val modelName = mutableStateOf("")
    private val modelDescription = mutableStateOf("")

    @Composable
    override fun addContent() {
        val adderErrorFlag = remember { mutableStateOf(false) }
        val scope = rememberCoroutineScope()

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                StringField.render("Название модели", modelName, adderErrorFlag)
                StringField.render("Описание", modelDescription, adderErrorFlag)
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
                            .addModelAuxiliary(
                                AddAuxiliaryModelDto(
                                    modelName.value,
                                    modelDescription.value
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

    override fun getHead() = listOf(
        "Название модели",
        "Описание"
    )

    override fun getData() = runBlocking {
        RetrofitBuilder
            .infoApi()
            .getAuxiliaryModel()
            .map {
                listOf(
                    it.modelName,
                    it.description
                )
            }
    }
}