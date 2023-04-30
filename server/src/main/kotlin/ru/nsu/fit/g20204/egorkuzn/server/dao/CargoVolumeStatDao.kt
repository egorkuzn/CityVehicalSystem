package ru.nsu.fit.g20204.egorkuzn.server.dao

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.nsu.fit.g20204.egorkuzn.server.config.JdbcConfig
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.CargoVolumeStatEntity
import java.sql.ResultSet

@Service
class CargoVolumeStatDao(@Autowired jdbcConfig: JdbcConfig): BaseDao<CargoVolumeStatEntity>(jdbcConfig) {
    override fun returnEntity(resultSet: ResultSet) = with(resultSet) {
        CargoVolumeStatEntity(
            getLong("vehicle_id"),
            getDate("trip_date"),
            getShort("cargo_volume"),
            getShort("distance")
        )
    }


    override fun runQuery(): List<CargoVolumeStatEntity> {
        TODO("Not yet implemented")
    }
}