package com.cloudnative.webapi.config;


import com.cloudnative.webapi.config.auth.BasicAuthEntryPoint;
import com.cloudnative.webapi.config.auth.BasicAuthFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//    private final BasicAuthFilter basicAuthFilter;
    private final BasicAuthEntryPoint basicAuthEntryPoint;

    public SecurityConfig(/*BasicAuthFilter basicAuthFilter,*/ BasicAuthEntryPoint basicAuthEntryPoint) {
//        this.basicAuthFilter = basicAuthFilter;
        this.basicAuthEntryPoint = basicAuthEntryPoint;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(new String[]{
                                "/healthz",
                                "/v1/user"
                        }).permitAll()
                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .httpBasic(httpBasic -> httpBasic
                        .authenticationEntryPoint(basicAuthEntryPoint)
                );
//                .addFilterBefore(basicAuthFilter, UsernamePasswordAuthenticationFilter.class)
//                .exceptionHandling(handler -> handler
//                        .authenticationEntryPoint(basicAuthEntryPoint)
                //);
        return http.build();
    }
}