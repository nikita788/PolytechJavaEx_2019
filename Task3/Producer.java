package com.company;

import java.util.concurrent.ThreadLocalRandom;

public class Producer implements Runnable {
    private Storage store;
    private int counter;

    Producer(Storage store, int count) {
        this.store = store;
        this.counter = count;
   }

    public void run() {
        Thread.currentThread().setName("Producer thread");
            for (int i = 0; i < counter; i++) {
                int randomValue = ThreadLocalRandom.current().nextInt(1, 100);
                store.put(randomValue);
            }
    }
}
