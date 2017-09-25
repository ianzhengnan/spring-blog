package com.ian.sblog.x4.chapter16.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;

import java.util.List;
import java.util.Set;

public class JDBCJobStoreRunner {

    public static void main(String[] args) throws Throwable{

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();

        List<String> triggerGroups = scheduler.getTriggerGroupNames();
        for (String triggerGroup : triggerGroups) {
            Set<TriggerKey> triggerKeys = scheduler.getTriggerKeys(GroupMatcher.triggerGroupEquals(triggerGroup));
            for (TriggerKey tk:
                 triggerKeys) {
                Trigger tg = scheduler.getTrigger(tk);
                if (tg instanceof SimpleTrigger){
                    scheduler.rescheduleJob(tk, tg);
                }
            }
        }
        if (!triggerGroups.isEmpty()){
            scheduler.start();
        }
    }
}
