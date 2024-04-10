package com.ulisses;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("123qwe!@#")
                .roles("ADMIN", "USER")
                .and()
                .withUser("user")
                .password("123qwe123")
                .roles("USER");
    }

    @Bean
    public PasswordEncoder getPasswordencoder(){
        return NoOpPasswordEncoder.getInstance();    
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable()
        .authorizeRequests()
        .antMatchers("/user/**").hasRole("ADMIN").anyRequest().fullyAuthenticated()
        .antMatchers(HttpMethod.GET, "/user/**").hasRole("USER").anyRequest().fullyAuthenticated()
        .and().httpBasic();
    }
}

