package com.testubuntu.mypoc.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "oscar_movie")
@Data
public class OscarMovie {
    
    @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;
  @Column(name = "i_index")
  private String index;
  @Column(name = "i_year")
  private String year;
  @Column(name = "i_age")
  private String age;
  @Column(name = "i_name")
  private String name;
  @Column(name = "i_movie")
  private String movie;

  @Column(name = "i_created_date")
  private Date createdDate;
  
  public OscarMovie(String index, String year, String age, String name, String movie, Date createdDate) {
    this.index = index;
    this.year = year;
    this.age = age;
    this.name = name;
    this.movie = movie;
    this.createdDate=createdDate;
  }

    public OscarMovie(){
  }
 
 
}
