package com.ian.sblog.x4.chapter16.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;

import java.util.Map;

public class MyJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        Map dataMap = context.getJobDetail().getJobDataMap();
        String size = (String) dataMap.get("size");

        ApplicationContext ctx = (ApplicationContext) dataMap.get("applicationContext");
        System.out.println("Size: " + size);
        dataMap.put("size", size + "0");

    }
}
