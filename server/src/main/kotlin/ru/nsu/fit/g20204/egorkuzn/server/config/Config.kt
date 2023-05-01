package ru.nsu.fit.g20204.egorkuzn.server.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Config (
    @Value("\${spring.datasource.url}") val url: String,
    @Value("\${spring.datasource.username}") val username: String,
    @Value("\${spring.datasource.password}") val password: String
) {
    @Bean
    fun jdbcConfigs() = JdbcConfig(
        url,
        username,
        password
    )
}