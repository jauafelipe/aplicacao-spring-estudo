package com.example.app.estudo_spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ConfigRoutes {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorizeRequests ->
                authorizeRequests.requestMatchers("/usuarios","/usuarios/all-users")
                .permitAll())
            .csrf(csrf -> csrf.disable()).formLogin(f -> f.disable())
            .httpBasic(b -> b.disable());
        return http.build();
    }
}
