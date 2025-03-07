package com.c3.Ameri.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

        @Bean
        public OpenAPI customOpenAPI() {
                return new OpenAPI()
                        .info(new Info()
                                .title("Ameri API Documentation")
                                .description("API documentation for the Ameri social network project.")
                                .version("1.0.0")
                                .contact(new Contact()
                                        .name("Support Team")
                                        .email("support@ameri.com")
                                )
                        )
                        .servers(List.of(new Server().url("http://localhost:8090").description("Local Server")));
        }
}
