package com.testubuntu.mypoc.batchprocess;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.testubuntu.mypoc.model.OscarMovie;
import com.testubuntu.mypoc.repository.OscarMovieRepository;

public class OscarMovieWritter implements ItemWriter<OscarMovie> {

    @Autowired
    private OscarMovieRepository movieRepository;

    @Override
    public void write(Chunk<? extends OscarMovie> chunk) throws Exception {
        movieRepository.saveAll(chunk);
        // throw new UnsupportedOperationException("Unimplemented method 'write'");
    }

}
