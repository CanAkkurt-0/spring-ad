package com.java.azurestarterad;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Collection;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final RoleMapping roleMapping;

    public SecurityConfig(RoleMapping roleMapping) {
        this.roleMapping = roleMapping;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {


        return http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/home").permitAll()
                        .requestMatchers("/admin").hasRole("JAVA")
                        .requestMatchers("/user/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .oauth2Login(oauth2 -> oauth2
                        .defaultSuccessUrl("/home", true)
                        .userInfoEndpoint(ep -> ep
                                .userAuthoritiesMapper(this::mapGroupsToAuthorities))

                )
                .csrf(AbstractHttpConfigurer::disable)
                .build();
    }

    private Collection<? extends GrantedAuthority> mapGroupsToAuthorities(Collection<? extends GrantedAuthority> authorities) {
        Authentication authentication = org.springframework.security.core.context.SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof OidcUser) {
            return roleMapping.mapAuthorities(authorities);
        }
        return authorities;
    }
}
