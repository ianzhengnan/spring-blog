package com.ian.sblog.x4.chapter16;

import com.ian.sblog.x4.chapter16.quartz.SimpleJob;
import org.junit.Test;
import org.quartz.CronExpression;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;

public class CronTriggerRunner {

    @Test
    public void testCronTrigger() {

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

            // 这里让主线程睡眠一会儿让前面的job得以执行，否者job会随着主线程的退出而退出，而看不到执行结果
            Thread.currentThread().sleep(10000);


        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
