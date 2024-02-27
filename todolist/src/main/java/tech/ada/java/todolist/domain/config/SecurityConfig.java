package tech.ada.java.todolist.domain.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // Indicate that this class is a Spring configuration
@EnableWebSecurity // Enable web security based in Spring Security, mandatory on the Spring Security configuration class
public class SecurityConfig {

    @Bean // Indicate that this method is a bean managed by Spring
    // Define security filter and its configuration
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // Disable frame options, allowing H2 console visualization
                .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))

                // Disable csrf protection, allowing POST methods without token
                .csrf(AbstractHttpConfigurer::disable)

                // Configure authorization rules for HTTP requisitions
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers(HttpMethod.GET, "/aluno").permitAll(); // Allows GET for the given endpoint without auth
                    auth.anyRequest().authenticated(); // Require auth for all other routes
                })

                // Configure default options for basic auth: name and password
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
