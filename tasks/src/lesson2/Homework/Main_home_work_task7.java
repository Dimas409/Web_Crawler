package lesson2.Homework;

import java.util.Objects;
import java.util.Scanner;

public class Main_home_work_task7 {
    public static void main (String[] args) {
//        Задача 7 Создать игру в угадайку:
//        программа загадывает число от 1 до 5, юзер вводит с консоли свой вариант.
//        Если юзер угадал, ему засчитывается одно очко.
//        Для запуска игры, юзер должен зарегистрироваться и войти в свой аккаунт.
//        Количество очков юзера должно сохраняться в аккаунте.
//
//        Создайте консольное меню:
//        1. Регистрация
//        2. Вход
//        3. Выход
//
//        Если юзер вошел в свой аккаунт (пункт 2), у него открывается подменю:
//        1. Сыграть
//        2. Выйти в главное меню
        Scanner scn = new Scanner(System.in);
        System.out.println("Игра одгадай число.");
        int[] guessNum = {1, 2, 3, 4, 5};
        int input = 0;
        String[] logins = new String[5];
        String[] passwords = new String[5];
        int[] scores = new int[5]; //Массив количества очков
        int new_account_index = 0;
        int user_index = -1;
        int user_points = 0;

        while (input != 3){
            System.out.println("" +
                    "        1. Регистрация\n" +
                    "        2. Вход\n" +
                    "        3. Выход");
            input = scn.nextInt();
            if (input == 1) {
                System.out.println("Зарегестрируйтесь!");
                System.out.println("Введите логин:");
                String login = scn.next();
                System.out.println("Введите пароль:");
                String password = scn.next();
                logins[new_account_index] = login;
                passwords[new_account_index] = password;
                new_account_index++;

            }
            else if (input == 2) {
                System.out.println("Введите логин: ");
                String login = scn.next();
                System.out.println("Введите пароль: ");
                String password = scn.next();
                boolean isExist = false;
                for (int i = 0; i < logins.length; i++){
//                    if  (logins[i]!=null && passwords[i]!=null && logins[i].equals(login) && passwords[i].equals(password)) {
                      if (Objects.equals(logins[i], login) && Objects.equals(passwords[i], password))  {
                        user_index = i;
                        isExist = true;
                        System.out.println("Добро пожаловать!");
                        int secondInput = 0;
                        while (secondInput != 2) {
                            System.out.println("" +
                                    "        1. Сыграть\n" +
                                    "        2. Выйти в главное меню");
                            secondInput = scn.nextInt();
                            if(secondInput == 1) {
                                System.out.println("Введите число:");
                                int num = scn.nextInt();
                                for (int a = 0; a < guessNum.length; a++) {
                                    if (num == guessNum[a]){
                                        user_points++;
                                        System.out.println("Вы угадали.");
                                    }
                                }
                                System.out.println("У вас " + user_points + " очков.");
                                scores[user_index] += user_points;
                            }

                        }
                    }
                }
                if(!isExist) {
                    System.out.println("Такого пользователя не существует!");
                }
            }
            else if (input == 3) {
                if (user_index >= 0) {
                    user_index = -1;
                    System.out.println("Вы вышли из аккаунта.");

                } else {
                    System.out.println("Вы должны войти в аккаунт.");
                }
            }

        }
    }
}
