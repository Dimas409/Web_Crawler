package lesson12_recursion.Homework;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Task2 {
    public static void main(String[] args) {
        enter();
    }
    public static void enter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер карты: ");
        String idNumber = scanner.next();
        String regex = "^i[0-9,a-z]{3}d$";
        if (idNumber.matches(regex)){
            System.out.println("Корректно");
        } else {
            System.out.println("Попробуйте ввести еще раз");
            enter();
        }


    }
}
