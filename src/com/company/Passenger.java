package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Passenger extends Thread {
    CountDownLatch cdl;
    Semaphore sem;
    private int id;

    public Passenger(Semaphore sem, CountDownLatch cdl, int id) {
        this.sem = sem;
        this.id = id;
        this.cdl = cdl;
    }

    public synchronized void run() {
        try {
            sem.acquire();
            System.out.println("пассажир " + id + " покупает билет");
            sleep(1000);
            System.out.println("пассажир " + id + " купил билет");
            sem.release();
            System.out.println("пассажир " + id + " сел в автобус");
            cdl.countDown();
            cdl.await();
        } catch (Exception e) {
        }
    }
}
