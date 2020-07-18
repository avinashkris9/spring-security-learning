package com.github.avinashkris9.oauthresourceapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

@SpringBootApplication

public class OauthResourceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OauthResourceApiApplication.class, args);
	}

}
