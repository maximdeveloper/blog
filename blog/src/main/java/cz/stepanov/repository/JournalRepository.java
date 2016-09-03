package cz.stepanov.repository;

import cz.stepanov.domain.Journal;
import org.springframework.data.repository.CrudRepository;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Max
 */
public interface JournalRepository extends CrudRepository<Journal, Long> { }
