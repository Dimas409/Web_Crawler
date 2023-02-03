package lesson5_methods.Home_Work_methods;

import java.util.Scanner;

public class Main_home_work_task2 {
    public static  void main (String[] args) {
        Scanner scn = new Scanner(System.in);
        Solution solution = new Solution();
        System.out.println("Введите число а: ");
        int a = scn.nextInt();
        System.out.println("Введите число b: ");
        int b = scn.nextInt();
        System.out.println("Введите число с: ");
        int c = scn.nextInt();
        System.out.println("Число х в уравнении а*х+b=c равно: ");
        System.out.println(solution.equation(a, b, c));
        System.out.println("Максимальное число среди а и b: ");
        System.out.println(solution.maxNumber(a, b));
        System.out.println("Число а в квадрате равно: ");
        System.out.println(solution.squareNumber(a));
        System.out.println("Значение факториала числа а: ");
        System.out.println(solution.factorial(a));
        System.out.println("Значение факториала числа а рекурсивный метод: ");
        System.out.println(solution.recFactorial(a));
        System.out.println("Решение квадратного уравнения вида a*x^2 + b*x + c = 0 равно: ");
        System.out.println(solution.squareEquation(a, b, c));

    }



}
class Solution {
    int equation(int a, int b, int c){
        return (c/a)-(b/a);
    }
    int maxNumber(int a, int b){
        return Math.max(a, b);
    }

    int squareNumber(int a){
        return a*a;
    }
    int factorial(int f){
        int result = 1;
        for (int i = 1; i <= f; i++) {
            result *= i;

        }
        return result;
    }
    int recFactorial(int f){
        if(f <= 1) {
            return 1;
        }
        else {
            return f * recFactorial(f-1);
        }
    }
    int squareEquation (int a, int b, int c) {
        return (b*b) - 4*a*c;
    }

}