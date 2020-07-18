package com.github.avinashkris9.oauthresourceapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")

public class AppRestController {

  @GetMapping
  public String test()
  {
    return "Hello World!";
  }
  @Autowired
  private OAuth2RestTemplate oAuth2RestTemplate;


  @Bean
  public OAuth2RestTemplate oauth2RestTemplate(OAuth2ClientContext oauth2ClientContext,
      OAuth2ProtectedResourceDetails details) {
    return new OAuth2RestTemplate(details, oauth2ClientContext);
  }

  @GetMapping("rest")
  public String output()
  {  ResponseEntity<String> response =
      oAuth2RestTemplate.getForEntity("http://localhost:8085/test", String.class);
    return "Success! (" + response.getBody() + ")";

  }
}
