package com.capgemini.java_adv.fw.hibernate_jpa.author_biography.entity;

import jakarta.persistence.*;

@Entity
public class Author {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;

 private String name;
 private String email;

 @OneToOne(cascade = CascadeType.ALL)
 private Biography biography;

 public int getId() {
  return id;
 }

 public void setId(int id) {
  this.id = id;
 }

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

 public String getEmail() {
  return email;
 }

 public void setEmail(String email) {
  this.email = email;
 }

 public Biography getBiography() {
  return biography;
 }

 public void setBiography(Biography biography) {
  this.biography = biography;
 }

}