package com.ian.sblog.x4.chapter16;

import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.AnnualCalendar;

public class CalendarExample {

    public static void main(String[] args) throws Throwable{
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();

        AnnualCalendar holidays = new AnnualCalendar();
    }
}
