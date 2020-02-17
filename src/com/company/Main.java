package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {
    public static final int Passenger = 100;

    public static void main(String[] args) throws InterruptedException {
        Semaphore sem = new Semaphore(4, true);
        CountDownLatch cdl = new CountDownLatch(Passenger+1);
        for (int i = 1; i <=Passenger ; i++) {
            Passenger passenger = new Passenger(sem, cdl,i);
            passenger.start();
            Thread.sleep(100);
        }
        while (cdl.getCount()>1){
            Thread.sleep(100);
        }

        Thread.sleep(1000);
        cdl.countDown();
        System.out.println("Автобус выехал");



    }
}
