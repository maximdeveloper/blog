/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.stepanov.repository;

import cz.stepanov.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Max
 */
public interface UserRepository extends CrudRepository<User, Long>{
   public User findByUsername(String username);
}
