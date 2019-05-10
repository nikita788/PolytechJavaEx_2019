package com.company;


public class Storage {
    private int storeValue = 0;

    public synchronized void put(int value) {
        System.out.println("Producer: " + Thread.currentThread().getName() + " generated number is: "
                + value);
        storeValue = value;
        notify();
        try {
            wait();
        }
        catch (InterruptedException e) {
        }
    }

    public synchronized void get(int c, int d) {
        if (storeValue != 0) {
            notify();
        }
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        System.out.println("Customer: " + Thread.currentThread().getName() + " " + storeValue);
            if (c == d - 1) {
                notify();
            }
    }
}
