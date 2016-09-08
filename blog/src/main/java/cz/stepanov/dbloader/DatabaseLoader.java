/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.stepanov.dbloader;

import cz.stepanov.domain.Journal;
import cz.stepanov.domain.User;
import cz.stepanov.repository.JournalRepository;
import cz.stepanov.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 *
 * @author Max
 */
@Component
public class DatabaseLoader implements CommandLineRunner {
     
   private final JournalRepository journalRepo;
   
   private final UserRepository userRepo;
   
   @Autowired
   private PasswordEncoder passwordEncoder;
   
   public DatabaseLoader(JournalRepository journalRepo, UserRepository userRepo) {
      this.journalRepo = journalRepo;
      this.userRepo = userRepo;
   }
   
   @Override
   public void run(String... strings) throws Exception {
      this.journalRepo.save(new Journal("First title", "First summary", "01/01/2016"));
      this.journalRepo.save(new Journal("Second title", "Second summary", "02/02/2016"));
      this.userRepo.save(new User("admin", passwordEncoder.encode("admin"), "Max", "Stepanov", true));
      this.userRepo.save(new User("guest", passwordEncoder.encode("guest"), "Guest", "Guest", false));
   }
   
}
