package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            if ((args.length == 0) || (args.length > 2))
                throw new IOException("Пустой массив аргументов");
            double result;
            switch (args[1]) {
                case "+":
                    result = Double.parseDouble(args[0]) + Double.parseDouble(args[2]);
                    System.out.print("Операнд 1 = " + args[0] + "\n Операция = " + args[1] + "\n Операнд 2 = " + args[2] +
                                     "\nСумма = " + result);
                    break;
                case "-":
                    result = Double.parseDouble(args[0]) - Double.parseDouble(args[2]);
                    System.out.print("Операнд 1 = " + args[0] + "\n Операция = " + args[1] + "\n Операнд 2 = " + args[2] +
                                     "\nРазность = " + result);
                    break;
                case "*":
                    result = Double.parseDouble(args[0]) * Double.parseDouble(args[2]);
                    System.out.print("Операнд 1 = " + args[0] + "\n Операция = " + args[1] + "\n Операнд 2 = " + args[2] +
                                     "\nПроизведение = " + result);
                    break;
                case "/":
                    if (args[2].equals("0"))
                        throw new ArithmeticException("Divide by zero");
                    result = Double.parseDouble(args[0]) / Double.parseDouble(args[2]);
                    System.out.print("Операнд 1 = " + args[0] + "\n Операция = " + args[1] + "\n Операнд 2 = " + args[2] +
                                     "\nЧастное = " + result);
                    break;
                    default:
                        System.out.println("Недопустимая операция");
            }
        }
        catch (NumberFormatException e) {
            System.out.println("Операнд не является числом");
    }
        catch (ArithmeticException e) {
            System.out.println("На ноль делить нельзя");
        }
        catch (IOException e) {
            System.out.println("Нет агрументов командной строки или их слишком много");
        }
}
}
