package ru.nsu.fit.g20204.egorkuzn.server.dao

import ru.nsu.fit.g20204.egorkuzn.server.config.JdbcConfig
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import java.sql.Statement

abstract class BaseDao(jdbcConfig: JdbcConfig) {
    // Ленивая инициализация соединения с базой данных
    init {
        if (!isInitialised) {
            connection = DriverManager.getConnection(
                jdbcConfig.url,
                jdbcConfig.username,
                jdbcConfig.password
            )

            isInitialised = true
        }
    }

    protected companion object {
        lateinit var connection: Connection
        var isInitialised = false
    }

    fun sqlUpdate(updateRequest: String): Boolean {
        val statement: Statement = connection.createStatement() ?: return false

        try {
            statement.executeUpdate(updateRequest)
        } catch (e: SQLException) {
            println(updateRequest)
            println(e.message)
            return false
        }

        return true
    }
}