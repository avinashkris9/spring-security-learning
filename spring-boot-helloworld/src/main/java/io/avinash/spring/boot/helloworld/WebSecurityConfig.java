package io.avinash.spring.boot.helloworld;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .csrf().disable().sessionManagement().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
        .anonymous().disable()
        .authorizeRequests();

    http .oauth2Login();
  }

}
