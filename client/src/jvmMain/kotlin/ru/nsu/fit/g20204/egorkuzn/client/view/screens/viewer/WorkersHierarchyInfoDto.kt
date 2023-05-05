package ru.nsu.fit.g20204.egorkuzn.client.view.screens.viewer

data class WorkersHierarchyInfoDto(
    val depHead: String,
    val depName: String,
    val disHead: String,
    val disName: String,
    val master: String,
    val brigadier: String,
    val brigade: String,
    val worker: String
)