package com.shopcart.api.config;

import com.shopcart.security.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final AccessHandlerConfig accessHandlerConfig;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests(auth -> auth
                        .antMatchers("/api/videogame/findCatalog").permitAll()
                        .antMatchers("/api/videogame/findById/*").permitAll()
                        .antMatchers("/api/user/create").permitAll()
                        .antMatchers("/api/user/update").permitAll()
                        .antMatchers("/api/user/findById/*").permitAll()
                        .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                        .antMatchers("/api/auth/**").permitAll()
                        .antMatchers("/api/videogame/**").hasRole("EMPLEADO")
                        .antMatchers("/api/console/**").hasRole("EMPLEADO")
                        .antMatchers("/api/promo/**").hasRole("EMPLEADO")
                        .antMatchers("/api/category/**").hasRole("EMPLEADO")
                        .antMatchers("/api/admin/**").hasRole("ADMINISTRADOR")
                        .antMatchers("/api/employee/**").hasRole("EMPLEADO")
                        .antMatchers("/api/client/**").hasRole("CLIENTE")
                        .anyRequest().authenticated()
                )
                .exceptionHandling(e -> e.accessDeniedHandler(accessHandlerConfig))
                .httpBasic();
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance(); // ⚠️ Solo para desarrollo
    }

    @Bean
    public CorsConfigurationSource corsConfig() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
        config.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }

}
