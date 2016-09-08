/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.stepanov.security;

import cz.stepanov.domain.User;
import cz.stepanov.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 *
 * @author Max
 */
@Component
public class BlogUserDetailsService implements UserDetailsService {
   @Autowired
   private UserRepository userRepo;
   
   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      
      User user = userRepo.findByUsername(username);
      
      if(user == null) {
         throw new UsernameNotFoundException(String.format("User with theusername %s doesn't exist", username));
      }
      
      List<GrantedAuthority> authorities = new ArrayList<>();
      
      if(user.isAdmin()) {
         authorities = AuthorityUtils.createAuthorityList("ROLE_ADMIN");
      }
      
      UserDetails userDetails = 
              new org.springframework.security.core.userdetails.User(user.getUsername(), 
                                                                     user.getPassword(), 
                                                                     authorities);
      
      return userDetails;
   }
   
}
