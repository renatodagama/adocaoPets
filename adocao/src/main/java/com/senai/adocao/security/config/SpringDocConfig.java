package com.senai.adocao.security.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("API de Doação de PETs SENAI SIG")
                .version("1.0.0")
                .description("API REST desenvolvida para doação responsável de animais[cite: 1, 3]."
                    + " Permite cadastro de pets, adotantes e registro de adoções[cite: 4, 10, 11]."));
    }
}