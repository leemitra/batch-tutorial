package com.testubuntu.mypoc.model;

import lombok.Data;

@Data
public class MovieData {
    
  private String index;
  private String year;
  private String age;
  private String name;
   
  private String movie;
  public MovieData(String index, String year, String age, String name, String movie) {
    this.index = index;
    this.year = year;
    this.age = age;
    this.name = name;
    this.movie = movie;
  }

    public MovieData(){
  }
 
}
