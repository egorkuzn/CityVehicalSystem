package ru.nsu.fit.g20204.egorkuzn.server.dao.editor.model

import org.springframework.stereotype.Repository
import ru.nsu.fit.g20204.egorkuzn.server.config.JdbcConfig
import ru.nsu.fit.g20204.egorkuzn.server.dao.BaseDao
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.editor.add.models.PassengersModelEntity

@Repository
class EditorPassengersTransportDao(
    jdbcConfig: JdbcConfig,
) : BaseDao(jdbcConfig) {

    fun add(
        tableName: String,
        newPassengerModel: PassengersModelEntity
    ) = sqlUpdate(
        """
            with new_order as (
                insert into "Passenger transport models" values (DEFAULT, ${newPassengerModel.passengersCapacity})
                returning model_id
            )
            insert into "$tableName"
            values ('${newPassengerModel.modelName}', (select model_id from new_order))
        """.trimIndent()
    )

    /**
     *  type нам известен: либо 'car', либо 'shuttle', либо 'bus'
     */
    fun delete(
        tableName: String,
        type: String,
        deletePassengerModel: PassengersModelEntity
    ) = sqlUpdate(
        """
            with new_order as (
                delete from "$tableName"
                where model_name = '${deletePassengerModel.modelName}'
                returning ${type}_model_id as model_id
            )
            delete from "Passenger transport models"
            where model_id = (select model_id from new_order)
        """.trimIndent()
    )
}