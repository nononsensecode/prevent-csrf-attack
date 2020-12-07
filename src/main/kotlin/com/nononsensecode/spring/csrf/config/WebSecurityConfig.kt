package com.nononsensecode.spring.csrf.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager

@Configuration
@EnableWebSecurity
class WebSecurityConfig: WebSecurityConfigurerAdapter() {

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder()
    }

    @Bean
    fun userService(passwordEncoder: PasswordEncoder): UserDetailsService {
        val user1 = User
            .withUsername("user1")
            .password(passwordEncoder.encode("user1password"))
            .roles("ADMIN")
            .build()
        val user2 = User
            .withUsername("user2")
            .password(passwordEncoder.encode("user2password"))
            .roles("USER")
            .build()
        return InMemoryUserDetailsManager(user1, user2)
    }

    override fun configure(http: HttpSecurity?) {
        http
            ?.authorizeRequests()
            ?.antMatchers("/hello-world")
                ?.permitAll()
            ?.antMatchers("/another-hello-world")
                ?.hasRole("ADMIN")
            ?.anyRequest()
                ?.authenticated()
            ?.and()
            ?.formLogin()
    }

}