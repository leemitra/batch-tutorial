package com.testubuntu.mypoc.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testubuntu.mypoc.model.Book;
import com.testubuntu.mypoc.service.BookService;

@RestController
public class BookController {
    
    @Autowired
    private BookService bookService;

    @GetMapping("/home")
    public List<Book>  getResponse(){

       Book b1 = new Book("Java 21 Complete", BigDecimal.valueOf(45.69), LocalDate.of(2016, 8, 31));
          Book b2 = new Book("Spring in Action", BigDecimal.valueOf(59.95), LocalDate.of(2020, 7, 31));
          Book b3 = new Book("Open Book Theory", BigDecimal.valueOf(38.21), LocalDate.of(2021, 6, 10));
          Book b4 = new Book("Mind Games", BigDecimal.valueOf(76.32), LocalDate.of(2022, 5, 5));
          bookService.save(b1);
          bookService.save(b2);
          bookService.save(b3);
          bookService.save(b4);
        List<Book> books= bookService.findAll();

        return books;
    }

}
