package com.ian.sblog.x4.chapter16;

import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.SimpleTriggerImpl;

import java.util.Date;

public class SimpleJobTest {

    public static void main(String[] args) throws Exception{
        JobDetailImpl jobDetail = new JobDetailImpl();
        jobDetail.setGroup("jgroup1");
        jobDetail.setName("job1_1");
        jobDetail.setJobClass(SimpleJob.class);

        SimpleTriggerImpl simpleTrigger = new SimpleTriggerImpl();
        simpleTrigger.setName("job1_1");
        simpleTrigger.setDescription(simpleTrigger.getName());
        simpleTrigger.setGroup("jgroup1");
        simpleTrigger.setStartTime(new Date());
        simpleTrigger.setRepeatInterval(2000);
        simpleTrigger.setRepeatCount(100);

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.scheduleJob(jobDetail, simpleTrigger);
        scheduler.start();
    }
}
