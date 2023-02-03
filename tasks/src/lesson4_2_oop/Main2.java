package lesson4_2_oop;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        //создали объект класса Account (создали реальный аккаунт)
//        Account account1 = new Account();
//        account1.login = "admin";
//        account1.password = "admin123";
//        account1.age = 18;
//        System.out.println(account1.login+" "+account1.password);
//
//        Account account2 = new Account();
//        account2.login = "user";
//        account2.password = "123";
//        account2.age = 20;
//        System.out.println(account2.login+" "+account2.password);
//
//        Account[] accountArr = new Account[5];
//        accountArr[0] = account1;
//        accountArr[1] = account2;

        //Как заполнить массив аккаунтов автоматически
//        Account[] accountArr = new Account[5];
//        String[] logins = {"admin", "user1", "nagibator", "smooth", "test"};
//        String[] passwords = {"123", "6432sdf", "abc21"};
//        Random rnd = new Random();
//        for (int i = 0; i < accountArr.length; i++) {
//            Account account = new Account();
//            account.age = rnd.nextInt(18, 80);
////            account.login = "login"+i;
////            account.password = "password"+i;
//
//            //вариант 2:
//            account.login = logins[i];
//            int pass_index = rnd.nextInt(passwords.length);
//            account.password = passwords[pass_index];
//
//            //сохраняем в массиве
//            accountArr[i] = account;
//
//        }
//
//        for (int i = 0; i < accountArr.length; i++) {
//            System.out.println(accountArr[i].login+" "+accountArr[i].password+" "+accountArr[i].age);
//        }
//
//        System.out.println("Юзер вводит логин и пароль, проверить, есть ли такой аккаунт");
//        Scanner scn = new Scanner(System.in);
//        System.out.println("Enter login: ");
//        String log = scn.next();
//        System.out.println("Enter password: ");
//        String pass = scn.next();
//        for (int i = 0; i < accountArr.length; i++) {
//            if(accountArr[i].login.equals(log) && accountArr[i].password.equals(pass)){
//                System.out.println("Welcome!");
//            }
//        }


        Scanner scn = new Scanner(System.in);
        int input = 0;
        int count = 0;
        Account[] accountArr = new Account[5];
        while (input != 4) {
            System.out.println("1. регистрация");
            System.out.println("2. вход в аккаунт");
            System.out.println("3. Вывести все доступные профили.");
            System.out.println("4. Выход");
            input = scn.nextInt();
            switch (input) {
                case 1 -> {
                    Account account = new Account();
                    System.out.println("Enter login: ");
                    account.login = scn.next();
                    System.out.println("Enter password: ");
                    account.password = scn.next();
                    accountArr[count] = account;
                    count++;
                }

                case 2 -> {
                    System.out.println("Enter login: ");
                    String log = scn.next();
                    System.out.println("Enter password: ");
                    String pass = scn.next();
                    boolean exist = false;
                    for (int i = 0; i < accountArr.length; i++) {
                        if (accountArr[i] != null && accountArr[i].login.equals(log) && accountArr[i].password.equals(pass)) {
                            System.out.println("Welcome!");
                            exist = true;
                        }
                    }
                    if (!exist) {
                        System.out.println("Неверный логин или пароль");
                    }
                }
                case 3 -> {
                    for (int i = 0; i < accountArr.length; i++) {
                        if(accountArr[i]!=null) {
                            System.out.println(Arrays.toString(accountArr));
                        }
                    }
                }
            }
        }
    }
}

class Account {
    String login;
    String password;

    int age;
}
