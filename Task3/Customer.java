package com.company;

public class Customer implements Runnable {
    private Storage store;
    private int counter;

    Customer(Storage store, int counter) {
        this.store = store;
        this.counter = counter;
    }

    public void run() {
        Thread.currentThread().setName("Customer thread");
            for (int i = 0; i < counter; i++) {
                store.get(i, counter);
            }
    }
}
