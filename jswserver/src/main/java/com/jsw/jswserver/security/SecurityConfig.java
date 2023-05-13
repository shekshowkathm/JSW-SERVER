package com.jsw.jswserver.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.jsw.jswserver.jwt.JWTAuthenticationFilter;

/**
 * @author Samson Effes
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private static final String[] SECURED_URLs = {
    		"/register/findall"
    		};

    private static final String[] UN_SECURED_URLs = {
            "/register/save",
            "/register/findbyid/{rid}",
            "/register/delete/{rid}",
            "/register/put/{rid}",
            "/authenticate/login",
            "/register/updatepasswordbyemail/{email}",
            "/register/retrieveregisterbyemailforpassword/{email}"
            
    };

    @Autowired
    private JWTAuthenticationFilter authenticationFilter;

    @Autowired
    private UserDetailsService userDetailsService;



    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        var authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
       return authenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .authorizeHttpRequests()
                .antMatchers(UN_SECURED_URLs).permitAll().and()
                .authorizeHttpRequests().antMatchers(SECURED_URLs)
                .hasAuthority("ADMIN").anyRequest().authenticated()
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

}

