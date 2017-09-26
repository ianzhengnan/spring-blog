package com.ian.sblog.x4.chapter16.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.StatefulJob;

import java.util.Map;

public class MySimpleJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        Map dataMap = context.getTrigger().getJobDataMap();
        String count = (String) dataMap.get("count");
        dataMap.put("count", 30); // change value of count
    }
}
