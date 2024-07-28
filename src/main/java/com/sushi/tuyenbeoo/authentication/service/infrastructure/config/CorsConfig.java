package com.sushi.tuyenbeoo.authentication.service.infrastructure.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
public class CorsConfig {

    @Value("${authen.config.cors.allow-credentials:true}")
    private boolean corsAlloweCredentials;

    @Value("${authen.config.cors.allowed-origins:*}")
    private String corsAllowedOrigins;

    @Value("${authen.config.cors.allowed-headers:*}")
    private String corsAllowedHeaders;

    @Value("${authen.config.cors.allowed-methods:*}")
    private String corsAllowedMethods;

    @Value("${authen.config.cors.allowed-origins-patterns:*}")
    private String corsAllowedOriginsPatterns;

    @Bean
    public CorsFilter customCorsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Arrays.asList(corsAllowedOrigins.split(",")));
        config.setAllowedMethods(Arrays.asList(corsAllowedMethods.split(",")));
        config.addAllowedHeader(corsAllowedHeaders);
        config.addAllowedOriginPattern(corsAllowedOriginsPatterns);
        source.registerCorsConfiguration("/api/**", config);
        return new CorsFilter(source);
    }

}
