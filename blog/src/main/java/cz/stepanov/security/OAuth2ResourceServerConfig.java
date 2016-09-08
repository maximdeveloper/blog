/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.stepanov.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 *
 * @author Max
 */
@Configuration
@EnableResourceServer
public class OAuth2ResourceServerConfig extends ResourceServerConfigurerAdapter {

   @Override
   public void configure(ResourceServerSecurityConfigurer resources) {
      resources.resourceId("Blog_Resources");
   }

   @Override
   public void configure(HttpSecurity http) throws Exception {
      http
              .requestMatchers().antMatchers("/api/journals/**")
              .and()
              .authorizeRequests().antMatchers("/api/journals/**").authenticated();
   }
}
