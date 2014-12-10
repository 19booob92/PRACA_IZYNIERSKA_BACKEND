package com.pwr.quizzer;

import java.sql.Date;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

import com.pwr.quizzer.core.AnnealingTresholds;


public class WebInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        
        try {
            setScheduler();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return application.sources(MainConfiguration.class);
    }

    private void setScheduler() throws SchedulerException {
        JobDetail job = new JobDetail();
        job.setName("dummyJobName");
        job.setJobClass(AnnealingTresholds.class);

        SimpleTrigger trigger = new SimpleTrigger();
        trigger.setStartTime(new Date(System.currentTimeMillis() + 1000));
        trigger.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
        trigger.setRepeatInterval(30000);

        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        scheduler.scheduleJob(job, trigger);
    }
}
