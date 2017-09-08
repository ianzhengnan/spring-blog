package com.ian.sblog.chapter7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MethodPerformance {

    private long begin;
    private long end;
    private String serviceMethod;
    private static final Logger log = LoggerFactory.getLogger(MethodPerformance.class);

    public MethodPerformance(String serviceMethod){
        this.serviceMethod = serviceMethod;
        this.begin = System.currentTimeMillis();
    }

    public void printPerformance(){
        end = System.currentTimeMillis();
        long elapse = end - begin;
        log.debug(serviceMethod + "花费" + elapse + "毫秒。");
    }

}
