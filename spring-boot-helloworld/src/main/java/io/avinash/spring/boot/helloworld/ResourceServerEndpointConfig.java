package io.avinash.spring.boot.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

@Configuration
@EnableResourceServer
public class ResourceServerEndpointConfig  extends ResourceServerConfigurerAdapter {

  private static final String RESOURCE_ID = "resource_ids";

  @Autowired
  PasswordEncoder passwordEncoder;

//  @Bean
//  public ResourceServerTokenServices tokenServices(){
//
//    RemoteTokenServices tokenServices = new RemoteTokenServices();
//    tokenServices.setClientId("second");
//    tokenServices.setClientSecret("secret");
//    tokenServices.setCheckTokenEndpointUrl("http://localhost:8080/oauth/check_token");
//    return tokenServices;
//  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  public void configure(ResourceServerSecurityConfigurer resources) {
    resources.resourceId(RESOURCE_ID).stateless(false);
  }
//  @Override
//  public void configure(HttpSecurity http) throws Exception {
//    http.
//        anonymous().disable()
//        .authorizeRequests()
//        .antMatchers("/test/**").access("hasRole('ADMIN')")
//        .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
//  }
}
