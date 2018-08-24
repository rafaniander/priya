package com.example.demo;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableResourceServer
@EnableAuthorizationServer
@SpringBootApplication
public class SpringCloudSecurityOauthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudSecurityOauthServerApplication.class, args);
	}
	
	@RequestMapping("/user")
	Principal getUser(Principal user) {
		return user;
	}
}
