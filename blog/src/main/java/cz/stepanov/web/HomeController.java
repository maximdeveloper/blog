package cz.stepanov.web;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import cz.stepanov.domain.Journal;
import cz.stepanov.repository.JournalRepository;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Max
 */
@RestController
public class HomeController {
   private static final Logger log = Logger.getLogger(HomeController.class);
   
   @Autowired
   private JournalRepository repo;

   @RequestMapping(value = "/api/journals",
                     method = RequestMethod.GET,
                        produces = MediaType.APPLICATION_JSON_VALUE)
   public Map findAll() {
      Map jsonModel = new ConcurrentHashMap<>();
      
      jsonModel.put(Journal.ROOT_NAME, repo.findAll());
      return jsonModel;
   }
   
   @RequestMapping(value = "/api/journals/{id}",
                     method = RequestMethod.GET,
                        produces = MediaType.APPLICATION_JSON_VALUE)
   public Map findJournalById(@PathVariable Long id) {
      Map jsonModel = new ConcurrentHashMap<>();
      
      jsonModel.put(Journal.ROOT_NAME, repo.findOne(id));
      return jsonModel;
   }
   
   @ResponseStatus(value = HttpStatus.CREATED)
   @RequestMapping(value = "/api/journals",
                     method = RequestMethod.POST)
   public Map createJournal(@RequestBody Map<String, Journal> json) {
      log.debug("### ### ### " + json);
      json.forEach((key,value) -> {
         log.debug("Key: " + key);
         repo.save(value);
      });
      
      return json;
   }
  
   @RequestMapping(value = "/api/journals/{id}",
                     method = RequestMethod.DELETE,
                        produces = MediaType.APPLICATION_JSON_VALUE)
   @PreAuthorize("hasAuthority('ROLE_ADMIN')")
   public Map deleteJournalById(@PathVariable Long id) {
      repo.delete(id);
      
      Map jsonModel = new ConcurrentHashMap<>();
      
      jsonModel.put(Journal.ROOT_NAME, repo.findAll());
      return jsonModel;
   }
}
