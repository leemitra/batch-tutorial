package com.testubuntu.mypoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testubuntu.mypoc.model.OscarMovie;

public interface OscarMovieRepository extends JpaRepository<OscarMovie, Long> {
    
}
