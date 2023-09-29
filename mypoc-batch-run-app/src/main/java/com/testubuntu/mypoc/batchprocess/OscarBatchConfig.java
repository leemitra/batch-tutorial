package com.testubuntu.mypoc.batchprocess;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.testubuntu.mypoc.model.OscarMovie;

@Configuration
public class OscarBatchConfig {

    @Bean
    public FlatFileItemReader<OscarMovie> reader() {

        return new FlatFileItemReaderBuilder<OscarMovie>()
                .name("oscarMovieReader")
                .resource(new ClassPathResource("oscar_age_male.csv"))
                .delimited()
                
                .names(new String[] { "Index", "Year", "Age", "Name", "Movie" })
                .fieldSetMapper(new BeanWrapperFieldSetMapper<OscarMovie>() {
                    {
                        setTargetType(OscarMovie.class);
                    }
                }).recordSeparatorPolicy(new BlankLineRecordSeparatorPolicy()).linesToSkip(1)
                .build();
    }

    @Bean
    public OscarMovieProcessor processor() {
        return new OscarMovieProcessor();
    }

    @Bean
    public OscarMovieWritter writer() {
        return new OscarMovieWritter();
    }

    @Bean
    public Job importUserJob(JobRepository jobRepository,
            JobCompletionNotificationListener listener, Step step1) {
        return new JobBuilder("importUserJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build();
    }


    @Bean
    public Step step1(JobRepository jobRepository,
            PlatformTransactionManager transactionManager, OscarMovieWritter writer) {
        return new StepBuilder("step1", jobRepository)
                .<OscarMovie, OscarMovie>chunk(100, transactionManager)
                .reader(reader())
                .processor(processor())
                .writer(writer)
                .build();
    }

}
