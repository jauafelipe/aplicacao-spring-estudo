package com.example.app.estudo_spring.config.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ConfigRoutes {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .formLogin(form -> form.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(HttpMethod.GET, "/usuarios").authenticated()
                .requestMatchers(HttpMethod.GET, "/usuarios/all-users").permitAll()
                .requestMatchers(HttpMethod.GET, "/usuarios/procurar-cpf/**").permitAll()
                .requestMatchers(HttpMethod.POST, "/usuarios/criar-usuario/**").permitAll()
                .anyRequest().authenticated()
            );

        return http.build();
    }

    @Bean
    public UserDetailsService detailsService() {
        UserDetails user = User.withUsername("admin")
            .password("{noop}fefo123")
            .roles("ADMIN")
            .build();

        return new InMemoryUserDetailsManager(user);
    }
}
