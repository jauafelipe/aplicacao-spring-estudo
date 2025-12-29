package com.example.app.estudo_spring.config.ConfigEnv;

import org.springframework.context.annotation.Configuration;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.annotation.PostConstruct;

@Configuration
public class ConfigDotEnv {
    @PostConstruct
    public void loadEnv() {
        Dotenv env = Dotenv.configure()
            .ignoreIfMissing()
            .load();

            env.entries().forEach(e-> 
                System.setProperty(e.getKey(), e.getValue())
            );
    }
}
