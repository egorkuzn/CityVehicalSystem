package ru.nsu.fit.g20204.egorkuzn.server.dao

import ru.nsu.fit.g20204.egorkuzn.server.config.JdbcConfig
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.BaseEntity
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement

abstract class BaseDao<T : BaseEntity>(jdbcConfig: JdbcConfig) {

    val connection = DriverManager.getConnection(
        jdbcConfig.url,
        jdbcConfig.username,
        jdbcConfig.password
    )

    fun sqlRun(sqlQuery: String): List<T> {
        val result = ArrayList<T>()

        try {
            val statement: Statement = connection.createStatement()
            val SQL = sqlQuery
            val resultSet: ResultSet = statement.executeQuery(SQL)

            while (resultSet.next()) {
                result.add(returnEntity(resultSet))
            }
        } catch (throwables: SQLException) {
            throwables.printStackTrace()
        }
        return result
    }

    abstract fun returnEntity(resultSet: ResultSet): T
}