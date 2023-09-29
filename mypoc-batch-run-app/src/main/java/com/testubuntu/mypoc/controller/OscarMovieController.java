package com.testubuntu.mypoc.controller;

import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testubuntu.mypoc.model.OscarMovie;
import com.testubuntu.mypoc.service.OscarMovieService;

@RestController
public class OscarMovieController {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job jobA;

    @Autowired
    private OscarMovieService oscarMovieService;

    @GetMapping("runBatch")
    public String runBatchAgain() {
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis())
                .toJobParameters();

        try {
            jobLauncher.run(jobA, jobParameters);
        } catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
                | JobParametersInvalidException e) {

            e.printStackTrace();
        }
        return "success";
    }

    @GetMapping("/allMovies")
    public List<OscarMovie> getAllMovies() {

        return oscarMovieService.getAllOscarMovies();
    }
}
