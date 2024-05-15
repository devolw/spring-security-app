package ru.popoff.spring.FirstSecurityApp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import ru.popoff.spring.FirstSecurityApp.services.PersonDetailsService;

import static org.springframework.security.config.Customizer.withDefaults;

// Главный класс с настройкой Spring Security
@Configuration
@EnableMethodSecurity(prePostEnabled = true) // Дает возможность использовать @PreAuthorize
public class SecurityConfig {

    private final PersonDetailsService personDetailsService;

    @Autowired
    public SecurityConfig(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }

    // Настраивает аутентификацию
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth ->
                        auth
                                // Для страниц login, registration, error получают доступ все роли
                                .requestMatchers("/auth/login", "/auth/registration", "/error").permitAll()
                                .anyRequest()
                                // К остальным страницам получают доступ USER, ADMIN
                                .hasAnyRole("USER", "ADMIN")
                )
                .formLogin(formLogin ->
                        formLogin
                                .loginPage("/auth/login")
                                .loginProcessingUrl("/process_login")
                                .defaultSuccessUrl("/hello", true)
                                .failureUrl("/auth/login?error")
                )

                .logout(logout ->
                        logout
                                .logoutUrl("/logout")
                                .logoutSuccessUrl("/auth/login")
                )

                .httpBasic(withDefaults())
                .userDetailsService(personDetailsService);

        return http.build();
    }

    // Используется для шифрования пароля
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}