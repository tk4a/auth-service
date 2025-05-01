package ru.resume.app.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class WebClientConfig {
    @Bean
    fun userWebClient(builder: WebClient.Builder) = builder.baseUrl("http://localhost:8081/create")
}