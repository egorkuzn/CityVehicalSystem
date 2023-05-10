package ru.nsu.fit.g20204.egorkuzn.server.dao.editor.add.model

import org.springframework.stereotype.Repository
import ru.nsu.fit.g20204.egorkuzn.server.config.JdbcConfig
import ru.nsu.fit.g20204.egorkuzn.server.dao.BaseDao
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.editor.add.models.AddPassengersModelEntity
import java.sql.SQLException
import java.sql.Statement

@Repository
class AddPassengersTransportDao (
    jdbcConfig: JdbcConfig
): BaseDao(jdbcConfig) {
    fun sqlRun(
        tableName: String,
        newPassengerModel: AddPassengersModelEntity
    ): Boolean {
        val statement: Statement = connection.createStatement() ?: return false

        val updateRequest = """
            with new_order as (
                insert into "Passenger transport models" values (DEFAULT, ${newPassengerModel.passengersCapacity})
                returning model_id
            )
            insert into "$tableName"
            values ('${newPassengerModel.modelName}', (select model_id from new_order))
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