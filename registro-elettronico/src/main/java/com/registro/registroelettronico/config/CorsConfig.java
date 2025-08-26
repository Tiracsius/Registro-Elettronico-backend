package com.registro.registroelettronico.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

/**
 * Global CORS configuration for the application.
 * <p>
 * This configuration allows the frontend running on http://localhost:5173 to
 * access the API endpoints exposed by this backend. It allows common HTTP
 * methods and headers and enables credentials so that cookies or authorization
 * headers can be sent along with requests.
 */
@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        // Allow requests from the frontend dev server
        config.setAllowedOrigins(List.of("http://localhost:5173"));
        // Permit typical HTTP methods used in REST APIs
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        // Allow all headers
        config.setAllowedHeaders(List.of("*"));
        // Enable credentials so that cookies/authorization headers are sent
        config.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}