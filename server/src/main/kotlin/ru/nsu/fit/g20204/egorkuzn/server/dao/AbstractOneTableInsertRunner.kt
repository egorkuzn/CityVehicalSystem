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
    ) = sqlUpdate(
        """
            insert into "$tableName"
            values ${value.toSqlValue()}              
        """.trimIndent()
    )

    abstract fun delete(value: T): Boolean
}