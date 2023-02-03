package lesson5_methods;

import java.util.Scanner;

public class Main3_return {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a: ");
        int x = scn.nextInt();  //10
        System.out.print("Enter b: ");
        int y = scn.nextInt(); //20

        //найти среднее арфметическое двух чисел:
        int sum = calculator.sum(x, y); //30
        System.out.println("avereage = " + sum / 2);

        //найти сумму чисел
        System.out.println("sum = " + calculator.sum(2, 3));

        //найти деление чисел
        double result = calculator.divide(2, 3);
        System.out.println("divide = " + result);



//        String login = calculator.findLogin();
    }
}

class Calculator {
    //a,b - параметры метода
    int sum(int a, int b) {
        return a + b;
    }
    //a,b - параметры метода
    int minus(int a, int b) {
        return a - b;
    }

    int mult(int a, int b) {
        return a * b;
    }

    double divide(double a, double b) {
        return a / b;
    }


    String findLogin() {
        //ищем логин
        return "admin";
    }
}
