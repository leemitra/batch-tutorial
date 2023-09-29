package com.testubuntu.mypoc.batchprocess;

import java.util.Date;
import java.util.UUID;

import org.springframework.batch.item.ItemProcessor;

import com.testubuntu.mypoc.model.OscarMovie;

public class OscarMovieProcessor implements ItemProcessor<OscarMovie, OscarMovie> {

    @Override
    public OscarMovie process(OscarMovie movie) throws Exception {
       if(movie.getIndex() ==null || movie.getIndex()==""){

        return null;
       }else{
        
        final OscarMovie oscarMovie= new OscarMovie();
        oscarMovie.setId( UUID.randomUUID().toString());
        oscarMovie.setAge(movie.getAge());
        oscarMovie.setIndex(movie.getIndex());
        oscarMovie.setMovie(movie.getMovie());
        oscarMovie.setName(movie.getName());
        oscarMovie.setYear(movie.getYear());
        oscarMovie.setCreatedDate(new Date());
        return oscarMovie;
       }
       
        
    }
    
}
