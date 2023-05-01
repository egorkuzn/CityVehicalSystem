package ru.nsu.fit.g20204.egorkuzn.server.dao

import ru.nsu.fit.g20204.egorkuzn.server.config.JdbcConfig
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.BaseEntity
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement

abstract class BaseDao<T : BaseEntity>(jdbcConfig: JdbcConfig) {
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

    private companion object {
        lateinit var connection: Connection
        var isInitialised = false
    }

    fun sqlRun(sqlQuery: String): List<T> {
        val result = ArrayList<T>()

        try {
            val statement: Statement = connection.createStatement() ?: return result
            val resultSet: ResultSet = statement.executeQuery(sqlQuery)

            while (resultSet.next()) {
                result.add(returnEntity(resultSet))
            }
        } catch (throwable: SQLException) {
            throwable.printStackTrace()
        }

        return result
    }

    abstract fun returnEntity(resultSet: ResultSet): T
}