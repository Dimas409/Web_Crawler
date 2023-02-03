package lesson5_methods.Home_Work_methods;

import java.util.Scanner;

public class Main_home_work_task1 {
    public static void main (String[] args) {
        Calculator calculator = new Calculator();
        Scanner scn = new Scanner(System.in);
        int input = 0;
        while (input != 8) {
            System.out.println(
                    """
                            1. Сложить (нужно считать два числа и вызвать метод sum)
                            2. Умножить (нужно считать два числа вызвать метод multiply)
                            3. Вычесть (нужно считать два числа вызвать метод minus)
                            4. Разделить (нужно считать два числа вызвать метод divide)
                            5. Наибольшее (нужно считать два числа вызвать метод greater)
                            6. Наименьшее (нужно считать два числа вызвать метод lesser)
                            7. Модуль (нужно считать одно число вызвать метод abs)
                            8. Выход""");
            input = scn.nextInt();
            int a=0;
            int b=0;
            if(input >=1 && input <= 6) {
                a = calculator.readInt("Enter a: ");
                b = calculator.readInt("Enter b: ");
            }
            if (input == 1) {
                System.out.println("Сумма двух чисел: " + calculator.sum(a,b));
            }
            if (input == 2) {
                System.out.println("Результат умножения: " + calculator.multiply(a,b));
            }
            if (input == 3) {
                System.out.println("Результат вычитания: " + calculator.minus(a,b));
            }
            if (input == 4) {
                System.out.println("Результат деления: " + calculator.divide(a,b));
            }
            if (input == 5) {
                System.out.println("Максимальное число:  " + calculator.greater(a,b));
            }
            if (input == 6) {
                System.out.println("Наименьшее число: " + calculator.lesser(a,b));
            }
            if (input == 7) {
                a = calculator.readInt("Enter a: ");
                System.out.println("Абсолютное значение: " + calculator.abs(a));
            }

        }
    }

}
class Calculator {

    Scanner scn = new Scanner(System.in);

    int sum(int a, int b) {
        return a + b;
    }

    int minus(int a, int b) {
        return a - b;
    }

    int multiply(int a, int b) {
        return a * b;
    }

    int divide(int a, int b) {
        return a / b;
    }

    int greater(int a, int b) {
        return Math.max(a, b);

    }
    int lesser(int a, int b) {
        return Math.min(a, b);
    }
    int abs(int a) {
        return Math.abs(a);
    }
    int readInt(String text) {
        System.out.print(text);
        return scn.nextInt();
    }

}