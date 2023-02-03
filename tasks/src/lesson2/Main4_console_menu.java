package lesson2;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Main4_console_menu {
    public static void main(String[] args) {
        //Написать программу - авторизацию по логину и паролю. Создать два массива:
        // один хранит логин (arrLogins), другой - пароль(arrPasswords).
        // Каждая пара логин-пароль находится на одинаковом индексе в обоих списках.
        // То есть, к примеру, под индексом 0 в массиве arrLogins будет хранится логин пользователя,
        // а его пара - пароль будет храниться под индексом 0, но уже в массиве arrPasswords.
        //
        //Создать консольное меню:
        //
        //1. Зарегистрироваться
        //2. Вход в систему
        //3. Удалить логин и пароль
        //4. Выход из аккаунта
        //5. Отобразить приватный текст, доступный только авторизованному пользователю
        //6. Изменить пароль
        //7. Выход
        //
        //При выборе пункта 1 программа запрашивает логин и пароль у пользователя для его регистрации и добавляет их в массивы, если их там еще нет. Если такая пара логин-пароль уже есть в массивах, программа выводит текст "Пара логин-пароль уже заняты".
        //
        //При выборе пункта 2 пользователь вводит логин и пароль для авторизации. Программа проверяет, что такая пара есть и в успешном случае выводит на консоль "Успешная авторизация", иначе "Неверный логин или пароль".
        //
        //При выборе пункта 3 программа завершает совю работу.


        String[] logins = new String[5];
        String[] passwords = new String[5];


        Scanner scn = new Scanner(System.in);
        int new_account_index = 0;
        int user_index = -1; //это индекс, под которы находятся логин и пароль юзера, который зашел в аккаунт
        String secret_word = "I like Python!";
        int input = 0;
        while(input!=7){
            System.out.println("1. Зарегистрироваться\n" +
                    "2. Вход в систему\n" +
                    "3. Удалить логин и пароль\n" +
                    "4. Выход из аккаунта\n" +
                    "5. Отобразить приватный текст, доступный только авторизованному пользователю\n" +
                    "6. Изменить пароль\n" +
                    "7. Выход");
            input = scn.nextInt();
            if(input == 1){
                System.out.print("Enter login: ");
                String login = scn.next();
                System.out.print("Enter password: ");
                String password = scn.next();
                logins[new_account_index] =login;
                passwords[new_account_index] =password;
                new_account_index++;
            }
            else if(input == 2){
                System.out.print("Enter login: ");
                String login = scn.next();
                System.out.print("Enter password: ");
                String password = scn.next();
                boolean exist = false;
                for (int i = 0; i < logins.length; i++) {
                    if(logins[i]!=null && logins[i].equals(login) && passwords[i].equals(password)){
                        System.out.println("welcome!");
                        user_index = i; //запоминаем индекс, под которым зашел юзер (он будет 100% положительный)
                        exist = true;
                    }
                }
                if(!exist){
                    System.out.println("Invalid login or password");
                }
            }
            else if(input == 3){
                //проверяем, заходил ли юзер в свой аккаунт
                if(user_index>=0){
                    logins[user_index] = null;
                    passwords[user_index] = null;
                    user_index = -1; //юзер выходит из аккаунта
                    System.out.println("Аккаунт удален");
                }else{
                    System.out.println("Вы должны войти в аккаунт");
                }
            }
            else if(input == 4){
                //проверяем, заходил ли юзер в свой аккаунт
                if(user_index>=0){
                    //выходим из аккаунта
                    user_index = -1;
                    System.out.println("Вы вышли из аккаунта");
                }else{
                    System.out.println("Вы должны войти в аккаунт");
                }
            }
            else if(input == 5){
                //проверяем, заходил ли юзер в свой аккаунт
                if(user_index>=0){
                    System.out.println(secret_word);
                }else{
                    System.out.println("Вы должны войти в аккаунт");
                }
            }
            else if(input == 6){
                //проверяем, заходил ли юзер в свой аккаунт
                if(user_index>=0){
                    System.out.print("Enter new password: ");
                    passwords[user_index] = scn.next();
                    System.out.println("Пароль изменен");
                }else{
                    System.out.println("Вы должны войти в аккаунт");
                }
            }



        }
    }
}
