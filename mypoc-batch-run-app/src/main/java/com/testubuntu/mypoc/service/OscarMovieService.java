package com.testubuntu.mypoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testubuntu.mypoc.model.OscarMovie;
import com.testubuntu.mypoc.repository.OscarMovieRepository;

@Service
public class OscarMovieService {

    @Autowired
    private OscarMovieRepository oscarMovieRepository;

    public OscarMovie save(OscarMovie oscarMovie) {

        return oscarMovieRepository.save(oscarMovie);
    }

    public List<OscarMovie> getAllOscarMovies() {

        return oscarMovieRepository.findAll();
    }
}
