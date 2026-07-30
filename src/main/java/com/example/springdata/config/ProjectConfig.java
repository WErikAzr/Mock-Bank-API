package com.example.springdata.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableFeignClients (basePackages =  "com.example.springdata.proxy")
public class ProjectConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) {
        // @formatter:off
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/login").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((form) ->
                        form
                                .loginPage("/login")
                                .permitAll()
                )
                .logout(LogoutConfigurer::permitAll);
        // @formatter:on

        return http.build();
    }



    // Adding in memory users
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        UserDetails standardUser = User.builder()
                .username("brian")
                .password(encoder.encode("password123"))
                .roles("USER")
                .build();

        UserDetails adminUser = User.builder()
                .username("admin")
                .password(encoder.encode("admin123"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(standardUser, adminUser);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}