package lesson4_2_oop;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        String[] loginArr = new String[5];
        String[] passwordArr = new String[5];



        int index = 0;
        Scanner scn = new Scanner(System.in);
        int input = 0;
        while(input!=4){
            System.out.println("1. регистрация");
            System.out.println("2. вход в аккаунт");
            System.out.println("3. Выход");
            input = scn.nextInt();
            switch (input){
                case 1->{
                    System.out.println("Enter login: ");
                    String log = scn.next();
                    System.out.println("Enter password: ");
                    String pass = scn.next();
                    loginArr[index] = log;
                    passwordArr[index] = pass;
                    index++;
                }

                case 2->{
                    System.out.println("Enter login: ");
                    String log = scn.next();
                    System.out.println("Enter password: ");
                    String pass = scn.next();
                    boolean exist = false;
                    for (int i = 0; i < index; i++) {
                        if(loginArr[i].equals(log) && passwordArr[i].equals(pass)){
                            System.out.println("Welcome!");
                            exist = true;
                        }
                    }
                    if(!exist){
                        System.out.println("Неверный логин или пароль");
                    }
                }
            }
        }
    }
}
