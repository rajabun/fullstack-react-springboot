package com.eazybytes.eazystore.security;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity //optional because it's already on configuration, to improve readibility
public class EazyStoreSecurityConfig {

    @Bean
    @Order(SecurityProperties.BASIC_AUTH_ORDER)
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests((requests) ->
                requests.requestMatchers(HttpMethod.GET).permitAll()
                        .requestMatchers("/api/v1/products/**", "/api/v1/contacts/**").permitAll()
                        .requestMatchers("/api/v1/dummy/**").authenticated()
                        .anyRequest().authenticated())
                .formLogin(withDefaults())
                .httpBasic(withDefaults()).build();
    }

}
