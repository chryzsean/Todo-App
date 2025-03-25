package com.chrzsean.projects.Spring.Boot.Web.App.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {
        String encodedPassword = passwordEncoder().encode("chryzsean");
        System.out.println("Encoded password: " + encodedPassword);

        UserDetails userDetails = User.builder()
                .username("bry")
                .password(encodedPassword)
                .roles("USER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(userDetails);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    All URLs are protected
//    A login form is shown for unauthorized requests
//    CSRF disable
//    Frames

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
        http.formLogin(withDefaults()) // Spring default login page
                .logout(withDefaults()); // optional: adds logout support

        http.csrf().disable();
        http.headers().frameOptions().disable();

        return http.build();
    }

}
