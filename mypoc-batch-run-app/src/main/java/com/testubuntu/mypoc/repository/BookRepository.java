package com.testubuntu.mypoc.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testubuntu.mypoc.model.Book;

// Spring Data JPA creates CRUD implementation at runtime automatically.
public interface BookRepository extends JpaRepository<Book, Long> {

  // it works if it matches the book field name
  List<Book> findByTitle(String title);

 

}