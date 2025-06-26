/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MamoiTube.MamoiTube.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 *
 * @author mr587
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtFiltrer jwtAuthFilter;
    
    public SecurityConfig(JwtFiltrer jwtAuthFilter) {
        this.jwtAuthFilter = jwtAuthFilter;
    }


    @Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    return http
        .cors()  // Habilita CORS con la configuración que pongas en el bean CorsConfigurationSource
        .and()
        .csrf(AbstractHttpConfigurer::disable)
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authorizeHttpRequests(auth -> auth
            .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()  // Permite el preflight sin token
            .requestMatchers("/Usuarios/**").permitAll()
            .requestMatchers("/imagenes/**").permitAll()// Endpoints públicos (login, registro, etc.)
            .anyRequest().authenticated() // Todo lo demás requiere JWT válido
        )
        .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
        .build();
}


    @Bean
    public AuthenticationManager authManager(HttpSecurity http, PasswordEncoder encoder, UserDetailsService uds)
            throws Exception {
        return http
                .getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(uds)
                .passwordEncoder(encoder)
                .and()
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
}