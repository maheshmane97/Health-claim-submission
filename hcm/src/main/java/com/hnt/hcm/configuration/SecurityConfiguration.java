package com.hnt.hcm.configuration;

import com.hnt.hcm.serviceImpl.MemberDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {
    @Bean
    public UserDetailsService userDetails() {
//        UserDetails details1= User.withUsername("Mahesh")
//                .password(passwordEncoder.encode("Mahesh"))
//                .roles("ADMIN")
//                .build();
//        UserDetails details2= User.withUsername("Yogesh")
//                .password(passwordEncoder.encode("Yogesh"))
//                .roles("MEMBER")
//                .build();
//        return new InMemoryUserDetailsManager(details1,details2);
        return new MemberDetailsService();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetails());
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
        return security.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/hcm/member").permitAll().
                and().
                authorizeHttpRequests()
                .requestMatchers("/hcm/abc").authenticated()
                .and().formLogin()
                .and().build();
    }


}
