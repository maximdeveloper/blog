/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.stepanov.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

/**
 *
 * @author Max
 */
@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

   @Autowired
   private AuthenticationManager authenticationManager;
   
   @Override
   public void configure(AuthorizationServerEndpointsConfigurer endpoints)
           throws Exception {
      endpoints.authenticationManager(this.authenticationManager);
   }

   @Override
   public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
      clients
              .inMemory()
              .withClient("blogClient")
              .secret("top_secret")
              .authorizedGrantTypes("password")
              .scopes("read", "write")
              .resourceIds("Blog_Resources")
              .accessTokenValiditySeconds(1800);
   }
}
