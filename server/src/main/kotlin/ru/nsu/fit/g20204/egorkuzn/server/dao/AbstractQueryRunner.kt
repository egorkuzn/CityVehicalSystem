package ru.nsu.fit.g20204.egorkuzn.server.dao

import ru.nsu.fit.g20204.egorkuzn.server.config.JdbcConfig
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.BaseEntity
import java.sql.*

abstract class AbstractQueryRunner<T : BaseEntity>(jdbcConfig: JdbcConfig): BaseDao(jdbcConfig) {


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