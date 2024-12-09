package com.ffreitas.gamestoreserver.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
@RequiredArgsConstructor
public class SecurityConfiguration {

    @Value("${spring.security.cors.allowed-origins}")
    private List<String> allowedOrigins;

    @Value("${spring.security.cors.allowed-methods}")
    private List<String> allowedMethods;

    @Value("${spring.security.cors.allowed-headers}")
    private List<String> allowedHeaders;

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedHeaders(allowedHeaders);
        config.setAllowedMethods(allowedMethods);
        config.setAllowedOrigins(allowedOrigins);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}
