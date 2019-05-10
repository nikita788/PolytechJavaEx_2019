package com.company;

public class Main {
    public static int numberOfThreads;
    public static void main(String[] args) {
        try {
            numberOfThreads = Integer.parseInt(args[0]);
            int numberOfStrings = Integer.parseInt(args[1]);
            SThread[] mass = new SThread[numberOfThreads];
            if (numberOfThreads == 1) {
                new SThread(numberOfStrings, null, "Thread-0").start();
            } else {
                for (int i = 0; i < numberOfThreads; i++) {
                    if (i == 0) {
                        mass[i] = new SThread(numberOfStrings, null, "Thread-" + i);
                    } else {
                        mass[i] = new SThread(numberOfStrings, mass[i - 1], "Thread-" + i);
                    }
                }
                mass[0].obj = mass[numberOfThreads - 1];
                for (int i = numberOfThreads - 1; i >= 0; i--) {
                    mass[i].start();
                }
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
