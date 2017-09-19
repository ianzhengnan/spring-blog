package com.ian.sblog.x4.chapter7.advisor;

public class WaiterDelegate {

    private Waiter waiter;

    public void service(String clientName){
        waiter.greetTo(clientName);
        waiter.serveTo(clientName);
    }

    public void setWaiter(Waiter waiter){
        this.waiter = waiter;
    }
}
