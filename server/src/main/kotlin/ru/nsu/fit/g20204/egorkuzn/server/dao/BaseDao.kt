package ru.nsu.fit.g20204.egorkuzn.server.dao

import ru.nsu.fit.g20204.egorkuzn.server.config.JdbcConfig
import java.sql.Connection
import java.sql.DriverManager

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
}