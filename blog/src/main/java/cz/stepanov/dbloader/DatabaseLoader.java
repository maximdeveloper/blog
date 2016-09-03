/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.stepanov.dbloader;

import cz.stepanov.domain.Journal;
import cz.stepanov.repository.JournalRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author Max
 */
@Component
public class DatabaseLoader implements CommandLineRunner {
     
   private final JournalRepository journalrepo;
   
   public DatabaseLoader(JournalRepository journalrepo) {
      this.journalrepo = journalrepo;
   }
   
   @Override
   public void run(String... strings) throws Exception {
      this.journalrepo.save(new Journal("First title", "First summary", "01/01/2016"));
      this.journalrepo.save(new Journal("Second title", "Second summary", "02/02/2016"));
   }
   
}
