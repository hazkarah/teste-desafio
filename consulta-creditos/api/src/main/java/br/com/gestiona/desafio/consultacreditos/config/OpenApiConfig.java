package br.com.gestiona.desafio.consultacreditos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Consulta de Créditos ISSQN")
                        .version("v1")
                        .description("API para consulta de créditos ISSQN"));
    }
}