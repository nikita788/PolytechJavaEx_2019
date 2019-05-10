package com.company;


public class Main {

    public static void main(String[] args) {
        try {
            int valueArgs = Integer.parseInt(args[0]);
            if (valueArgs == 0) {
                throw new ArrayIndexOutOfBoundsException();
            }
            Storage store = new Storage();
            Producer producer = new Producer(store, valueArgs);
            Customer customer = new Customer(store, valueArgs);
            new Thread(customer).start();
            new Thread(producer).start();
        }
        catch (IllegalArgumentException e) {
            System.out.println("Вместо числа введен другой символ");
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Отсутствует аргумент командной строки, или он равен 0");
        }
    }
}
