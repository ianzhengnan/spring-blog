package com.ian.sblog.x4.chapter16;

import org.junit.Test;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.SimpleTriggerImpl;

import java.util.Date;

public class SimpleTriggerRunner {

    @Test
    public void testSimpleTrigger() throws Throwable{

        JobDetailImpl jobDetail = new JobDetailImpl();
        jobDetail.setGroup("jgroup1");
        jobDetail.setName("job1_1");
        jobDetail.setJobClass(SImpleJob.class);

        SimpleTriggerImpl simpleTrigger = new SimpleTriggerImpl();
        simpleTrigger.setName("job1_1");
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
