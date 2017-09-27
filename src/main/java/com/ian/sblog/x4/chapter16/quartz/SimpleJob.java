package com.ian.sblog.x4.chapter16.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

public class SimpleJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println(jobExecutionContext.getTrigger().getDescription() + " tiggered. Time is " + (new Date()));
    }
}