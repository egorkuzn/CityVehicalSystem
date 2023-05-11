package ru.nsu.fit.g20204.egorkuzn.server.dao

import ru.nsu.fit.g20204.egorkuzn.server.config.JdbcConfig
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.SqlInsertable
import java.sql.SQLException
import java.sql.Statement

abstract class AbstractOneTableInsertRunner<T : SqlInsertable>(
    jdbcConfig: JdbcConfig
): BaseDao(jdbcConfig) {
    abstract val tableName: String

    fun add(
        value: T
    ): Boolean {
        val statement: Statement = connection.createStatement() ?: return false
        val updateRequest = """
                    insert into "$tableName"
                    values ${value.toSqlValue()}              
                """.trimIndent()

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