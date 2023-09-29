package com.testubuntu.mypoc.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity(name = "my_books")
@Data
@RequiredArgsConstructor
public class Book {
    
    @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String title;
  private BigDecimal price;
  private LocalDate publishDate;

  public Book(String title, BigDecimal price, LocalDate publishDate) {
    this.title = title;
    this.price = price;
    this.publishDate = publishDate;
}
}
