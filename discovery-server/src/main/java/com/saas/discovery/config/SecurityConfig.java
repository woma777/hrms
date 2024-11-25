// package com.saas.discovery.config;
//
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
// import org.springframework.security.crypto.factory.PasswordEncoderFactories;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;
//
// import static org.springframework.security.config.Customizer.withDefaults;
//
// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {
//
//    @Value("${eureka.username}")
//    private String username;
//
//    @Value("${eureka.password}")
//    private String password;
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//        return new InMemoryUserDetailsManager(
//                User.withUsername(username)
//                        .password(encoder.encode(password))
//                        .roles("USER")
//                        .build()
//        );
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(auth -> auth
//                        .anyRequest().authenticated())
//                .httpBasic(withDefaults());
//        return http.build();
//    }
// }
