package com.pwr.quizzer;

import static com.pwr.quizzer.utils.PointsAvg.evaluateValues;

import java.sql.Date;
import java.util.List;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

import com.pwr.quizzer.model.CourseGenere;
import com.pwr.quizzer.service.CourseService;
import com.pwr.quizzer.service.CourseServiceImpl;


public class WebInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        
        return application.sources(MainConfiguration.class);
    }
}
