package com.company;

import static com.company.Main.numberOfThreads;

public class SThread extends Thread {

    private int counterOfStrings;
    public SThread obj;

    SThread(int counterOfStrings, SThread obj, String nameOfThread) {
        super(nameOfThread);
        this.counterOfStrings = counterOfStrings;
        this.obj = obj;
    }

    @Override
    public void run() {
        if (numberOfThreads == 1) {
            for (int i = 0; i < counterOfStrings; i++) {
                System.out.println(Thread.currentThread().getName());
            }
        } else {
            for (int i = 0; i < counterOfStrings; i++) {
                if (!(Thread.currentThread().getName().equals("Thread-0")) && (i == 0)) {
                    synchronized (obj) {
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
                System.out.print(Thread.currentThread().getName() + " ");
                if (Thread.currentThread().getName().equals("Thread-" + (numberOfThreads - 1))) {
                    System.out.println();
                }
                synchronized (obj) {
                    synchronized (this) {
                        this.notify();
                    }
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }
}
