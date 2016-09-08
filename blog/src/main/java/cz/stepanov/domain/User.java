/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.stepanov.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Max
 */

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name="USERS")
public class User extends AbstractBaseEntity{
   
   @JsonIgnore
   public static final String ROOT_NAME = "user";
   
   private String username;
   
   @JsonIgnore
   private String password;
   
   private String firstname;
   
   private String lastname;
   
   @Column(name="ADMIN", columnDefinition="char(3)")
   private boolean admin;
   
// GETTERS AND SETTES WILL BE CREATE BY LOMBOK ;)
}
