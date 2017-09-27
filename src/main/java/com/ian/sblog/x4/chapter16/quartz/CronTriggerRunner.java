package com.ian.sblog.x4.chapter16.quartz;

import org.quartz.CronExpression;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;

public class CronTriggerRunner {

    public static void main(String[] args) {

        try{
            JobDetailImpl jobDetail = new JobDetailImpl();
            jobDetail.setName("job1_2");
            jobDetail.setGroup("jgroup1");
            jobDetail.setJobClass(SimpleJob.class);

            CronTriggerImpl cronTrigger = new CronTriggerImpl();
            cronTrigger.setName("job1_2");
            cronTrigger.setDescription(cronTrigger.getName());

            CronExpression cexp = new CronExpression("0/5 * * * * ?"); // 每五秒钟运行一次
            cronTrigger.setCronExpression(cexp);

            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = schedulerFactory.getScheduler();
            scheduler.scheduleJob(jobDetail, cronTrigger);
            scheduler.start();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}