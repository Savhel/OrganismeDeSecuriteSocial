package com.fivet.organismedesecuritesocial.Security;

import com.fivet.organismedesecuritesocial.Services.PersonneConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private PersonneConfig personneService;

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        System.out.println("=== SECURITY CONFIG LOADING ===");

        http
                .csrf(csrf -> {
                    System.out.println("Disabling CSRF");
                    csrf.disable();
                })
                .authorizeHttpRequests(auth -> {
                    System.out.println("Configuring authorization rules");
                    auth
                            .requestMatchers("/api/public/**").permitAll()
                            .requestMatchers("/api/assure/**").hasRole("ASSURE")
                            .requestMatchers("/api/medecin/**").hasRole("MEDECIN")
                            .requestMatchers("/api/personne/**").permitAll()
                            .requestMatchers("/api/feuille-maladie/**").permitAll()
                            .anyRequest().authenticated();
                })
                .sessionManagement(sess -> {
                    System.out.println("Setting session management to STATELESS");
                    sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                })
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .httpBasic(AbstractHttpConfigurer::disable);

        System.out.println("=== SECURITY CONFIG COMPLETED ===");
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration config) throws Exception {
        System.out.println("Creating AuthenticationManager bean");
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        System.out.println("Creating PasswordEncoder bean");
        return new BCryptPasswordEncoder();
    }
}