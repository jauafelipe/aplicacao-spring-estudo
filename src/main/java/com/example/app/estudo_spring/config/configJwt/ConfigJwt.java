package com.example.app.estudo_spring.config.configJwt;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;

import com.nimbusds.jose.jwk.source.ImmutableSecret;

@Configuration
public class ConfigJwt {

    private static final String SECRET =
        "minha-chave-super-secreta-123456-min-32-bytes";

    @Bean
    JwtEncoder jwtEncoder() {
        SecretKey key = new SecretKeySpec(
            SECRET.getBytes(),
            "HmacSHA256"
        );
        return new NimbusJwtEncoder(new ImmutableSecret<>(key));
    }

    @Bean
    JwtDecoder jwtDecoder() {
        SecretKey key = new SecretKeySpec(
            SECRET.getBytes(),
            "HmacSHA256"
        );
        return NimbusJwtDecoder.withSecretKey(key).build();
    }
}
