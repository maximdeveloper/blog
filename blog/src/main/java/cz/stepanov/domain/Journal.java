/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.stepanov.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Transient;

/**
 *
 * @author Max
 */
@Entity
public class Journal extends AbstractBaseEntity {

   @JsonIgnore
   public static final String ROOT_NAME = "journal";

   private String title;

   private Date created;
   private String summary;

   @Transient
   private SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

   public Journal(String title, String summary, String date) throws ParseException {
      this.title = title;
      this.summary = summary;
      this.created = format.parse(date);
   }

   public Journal() {
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public void setCreated(String date) throws ParseException {
      this.created = format.parse(date);
   }

   public void setSummary(String summary) {
      this.summary = summary;
   }

   public String getTitle() {
      return title;
   }

//   public Date getCreatedAsLong() {
//      return created;
//   }
   public String getSummary() {
      return summary;
   }

   public String getCreated() {
      return format.format(created);
   }

   public String toString() {
      StringBuilder value = new StringBuilder("JournalEntry(");
      value.append(",Title: ");
      value.append(title);
      value.append(",Summary: ");
      value.append(summary);
      value.append(",Created: ");
      value.append(getCreated());
      value.append(")");
      return value.toString();
   }
}
