package com.java.oauth2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, RoleMapping roleMapping) throws Exception {

        return http
                .authorizeHttpRequests(auth -> auth

                        .requestMatchers("/java-gilde").hasRole("JAVA")
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/home").permitAll()
                        .anyRequest().authenticated()
                )
                .oauth2Login(oauth2 -> oauth2
                        .defaultSuccessUrl("/home", true)
                        .userInfoEndpoint(userInfo -> userInfo
                                .userAuthoritiesMapper(roleMapping::mapAuthorities)
                        )
                )
                .csrf(AbstractHttpConfigurer::disable)
                .build();
    }
}










