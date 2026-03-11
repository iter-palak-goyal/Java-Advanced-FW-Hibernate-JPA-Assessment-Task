package com.capgemini.java_adv.fw.hibernate_jpa.author_biography.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Biography {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;

 private String summary;
 private String birthPlace;
 private LocalDate birthDate;

 public int getId() {
  return id;
 }

 public void setId(int id) {
  this.id = id;
 }

 public String getSummary() {
  return summary;
 }

 public void setSummary(String summary) {
  this.summary = summary;
 }

 public String getBirthPlace() {
  return birthPlace;
 }

 public void setBirthPlace(String birthPlace) {
  this.birthPlace = birthPlace;
 }

 public LocalDate getBirthDate() {
  return birthDate;
 }

 public void setBirthDate(LocalDate birthDate) {
  this.birthDate = birthDate;
 }

}