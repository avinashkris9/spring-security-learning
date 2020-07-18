package com.github.avinashkris9.oauth.authorization.server;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

  @Autowired
  PasswordEncoder passwordEncoder;

  @Autowired
  private final AuthenticationManager authenticationManager;

  @Autowired
  private TokenStore tokenStore;


  public AuthorizationServerConfig(AuthenticationConfiguration authenticationConfiguration
       ) throws Exception {

    this.authenticationManager = authenticationConfiguration.getAuthenticationManager();

  }
  public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {

    security.checkTokenAccess("isAuthenticated()");
  }

  @Override
  public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

    //authenticationManager to validate the password.
    endpoints.authenticationManager(this.authenticationManager)
        //
    .accessTokenConverter(accessTokenConverter())
    .tokenStore(tokenStore());
  }




  /*
  Cleint Details service

   */
  @Override
  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

    //defining clients who can  access.
    clients.inMemory().withClient("first").secret(passwordEncoder.encode("secret")).scopes("Read").authorizedGrantTypes("password").accessTokenValiditySeconds(60).and().
        withClient("second").secret(passwordEncoder.encode("secret")).scopes("READ").authorizedGrantTypes("password").accessTokenValiditySeconds(60);
  }

/*
By default token store bean is not available so instantiate the bean
 */

@Bean
  public TokenStore tokenStore()
{
  return new  JwtTokenStore(accessTokenConverter());
}

  @Bean
  JwtAccessTokenConverter accessTokenConverter() {
    JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
    converter.setSigningKey("key");

//    converter.setVerifierKey(publicKey);
    return converter;
  }

  // Token services. Needed for JWT
  @Bean
  @Primary
  public DefaultTokenServices tokenServices() {
    DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
    defaultTokenServices.setTokenStore(tokenStore());
    return defaultTokenServices;
  }
}
