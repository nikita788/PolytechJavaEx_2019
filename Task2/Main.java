package com.company;


import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
      try {
            final int massIndex = Integer.parseInt(args[0]);
            if (massIndex == 0)
                throw new ArrayIndexOutOfBoundsException("Размер массива равен 0");
            Product[] mass = new Product[massIndex];
            for(int i = 0; i < massIndex; i++) {
                int randomNumber = ThreadLocalRandom.current().nextInt(1,4);
                switch (randomNumber) {
                    case 1:
                        mass[i] = new Book();
                        break;
                    case 2:
                        mass[i] = new Shoe();
                        break;
                    case 3:
                        mass[i] = new Toy();
                        break;
                    case 4:
                        mass[i] = new Picture();
                        break;
                }
            }
            for(Product var : mass) {
                System.out.println(var.whoAmI());
            }
            System.out.println("Now only Present objects");
            for(Product var : mass) {
                if(var instanceof Present)
                    System.out.println(((Present) var).itCanBePresented());
            }
       }
      catch (NumberFormatException e) {
          System.out.println("В качестве аргумента используется не число");
      }
      catch (ArrayIndexOutOfBoundsException e) {
          System.out.println("Отсутствует аргумент командной строки или он равен 0");
      }
}
}
