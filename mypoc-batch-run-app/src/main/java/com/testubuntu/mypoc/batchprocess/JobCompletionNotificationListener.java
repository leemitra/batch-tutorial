package com.testubuntu.mypoc.batchprocess;

import java.util.List;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.testubuntu.mypoc.model.OscarMovie;
import com.testubuntu.mypoc.service.OscarMovieService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JobCompletionNotificationListener implements JobExecutionListener{
    
    @Autowired
    private OscarMovieService movieService;
  
    @Override
  public void afterJob(JobExecution jobExecution) {
   
    if(jobExecution.getStatus() == BatchStatus.COMPLETED) {

      log.info("!!! JOB FINISHED! Time to verify the results");

      List<OscarMovie> list= movieService.getAllOscarMovies();
      for (OscarMovie oscarMovie : list) {
        log.info(oscarMovie.toString());
      } 
    }
  }
}
