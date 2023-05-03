package ru.nsu.fit.g20204.egorkuzn.server.model.entity

data class RepairsStatTransportEntity (
    val paramName: String,
    val count: Int,
    val sum: Int
): BaseEntity