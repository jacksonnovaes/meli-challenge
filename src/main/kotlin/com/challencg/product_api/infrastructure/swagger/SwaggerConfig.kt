package com.aurora.webapi.modules.config.swagger

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {

    @Bean
    fun customOpenAPI(): OpenAPI{
        return OpenAPI()
            .info(
                Info()
                    .title("product API web")
                    .version("1.0.0")
                    .description("api de detalhes de produto")
            )
    }
}