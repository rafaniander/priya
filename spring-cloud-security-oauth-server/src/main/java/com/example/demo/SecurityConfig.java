package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;

@Configuration
public class SecurityConfig extends GlobalAuthenticationConfigurerAdapter {
	
	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("allen").password("{noop}pass").roles("USER")
		.and()
		.withUser("ben").password("{noop}pass1").roles("USER", "ADMI");
	}
}
