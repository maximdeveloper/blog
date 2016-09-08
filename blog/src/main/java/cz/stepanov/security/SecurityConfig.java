/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.stepanov.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Max
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

   @Autowired
   private UserDetailsService userDetailsService;

   @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.userDetailsService(userDetailsService)
              .passwordEncoder(new BCryptPasswordEncoder());
   }

   @Override
   @Bean
   protected AuthenticationManager authenticationManager() throws Exception {
      return super.authenticationManager();
   }

   @Override
   protected void configure(HttpSecurity http) throws Exception {
      http.sessionManagement()
               .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
              .and()
               .authorizeRequests()
               .antMatchers("/h2-console/*").permitAll()
               .antMatchers("/api/journals/**").authenticated()
              .and()
               .httpBasic()
               .realmName("Blog")
               .and()
              .csrf()
               .disable();
   }
}
