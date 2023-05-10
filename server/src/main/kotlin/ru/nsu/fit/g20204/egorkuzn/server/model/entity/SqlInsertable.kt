package ru.nsu.fit.g20204.egorkuzn.server.model.entity

interface SqlInsertable {
    fun toSqlValue(): String
}