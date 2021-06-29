package com.lsy.wordcheck.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CustomOpenAPIConfig {
    @Bean
    fun customOpenAPI(
        @Value("\${info.build.version}") appVersion: String?,
        @Value("\${info.build.name}") title: String?,
        @Value("\${info.build.description}") description: String?
    ): OpenAPI {
        return OpenAPI()
            .info(
                Info().title(title)
                    .description(description)
                    .version(appVersion)
            )
    }
}