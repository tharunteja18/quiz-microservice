package com.nerchuko.quizservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI customeOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Quiz Service API")
                        .version("1.0.0")
                        .description("Quiz Service API is for creating the quiz, get the quiz questions and calculating the score and getting the result"));

    }

}
