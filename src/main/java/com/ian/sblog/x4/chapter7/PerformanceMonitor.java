package com.ian.sblog.x4.chapter7;

public class PerformanceMonitor {

    private static ThreadLocal<MethodPerformance> performanceRecord =
            new ThreadLocal<>();

    public static void begin (String method){
        System.out.println("begin monitor...");
        MethodPerformance mp = new MethodPerformance(method);
        performanceRecord.set(mp);
    }

    public static void end(){
        System.out.println("end monitor....");
        MethodPerformance mp = performanceRecord.get();
        mp.printPerformance();
    }
}
