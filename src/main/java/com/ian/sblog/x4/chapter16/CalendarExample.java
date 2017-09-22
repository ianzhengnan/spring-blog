package com.ian.sblog.x4.chapter16;

import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
//import org.quartz.TriggerUtils;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.AnnualCalendar;
import org.quartz.impl.triggers.CronTriggerImpl;

import java.util.ArrayList;
import java.util.Calendar;
//import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarExample {

    public static void main(String[] args) throws Throwable{
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();

        AnnualCalendar holidays = new AnnualCalendar();

        // 不是quartz的Calendar
        Calendar laborDay = new GregorianCalendar();
        laborDay.add(Calendar.MONTH, 5);
        laborDay.add(Calendar.DATE, 1);

        Calendar nationalDay = new GregorianCalendar();
        nationalDay.add(Calendar.MONTH, 10);
        nationalDay.add(Calendar.DATE, 1);

        ArrayList<Calendar> calendars = new ArrayList<>();
        calendars.add(laborDay);
        calendars.add(nationalDay);

        holidays.setDaysExcluded(calendars); // 排除五一，国庆两天

        scheduler.addCalendar("holidays", holidays, false, false);

        JobDetailImpl jobDetail = new JobDetailImpl();
        jobDetail.setName("job1");
        jobDetail.setGroup("group1");
        jobDetail.setJobClass(SimpleJob.class);

        CronTriggerImpl cronTrigger = new CronTriggerImpl();
        cronTrigger.setCronExpression("* 36 14 * * ?");
        cronTrigger.setName("test");
        cronTrigger.setDescription(cronTrigger.getName());
        cronTrigger.setCalendarName("holidays");

        scheduler.scheduleJob(jobDetail, cronTrigger);
        scheduler.start();

    }
}
