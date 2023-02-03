package lesson5_methods;

import java.util.Random;
import java.util.Scanner;

public class Main4_bankAccount {
    public static void main (String[] args) {
        //Создать метод расчета дохода за год по вкладу
        BankAccount[] bankAccounts = new BankAccount[10];
        Random rnd = new Random();

        for (int i = 0; i < bankAccounts.length; i++) {
            BankAccount account = new BankAccount();
            int number;
            boolean dublicate;
            do {
                dublicate = false;
                number = rnd.nextInt(636782, 867923);
                for (int j = 0; j < bankAccounts.length; j++) {
                    if (bankAccounts[i] != null && bankAccounts[i].number == number) {
                        dublicate = true;
                        break;
                    }
                }
            }while(dublicate);
            account.number = number;
            int balance = rnd.nextInt(5000, 30000);
            account.balance = balance;
            bankAccounts[i] = account;
        }

        Scanner scn = new Scanner(System.in);
        int input = 0;
        while (input != 3) {

            System.out.println("" +
                    "1. Вывести все счета\n" +
                    "2. Найти счет, владелец которого заработает больше всех процентов, \n" +
                    "если будет держать деньги на нем целый год.\n" +
                    "Прибыль за год вычисляется по формуле сумма на счету * процент на остаток / 100\n" +
                    "3. Выход");
            input = scn.nextInt();
            if (input == 1) {
                for (int i = 0; i < bankAccounts.length; i++) {
                   bankAccounts[i].printInfo();
                }
            }
            if (input == 2) {
                double maxDohod = 0;
                int maxIndex = 0;
                for (int i = 0; i < bankAccounts.length; i++) {
                    double dohod = bankAccounts[i].getDohodForYear();
                    if (dohod > maxDohod) {
                        maxDohod = dohod;
                        maxIndex = i;
                    }
                }
                System.out.println("счет с максимальным доодом "+maxDohod+":");
                bankAccounts[maxIndex].printInfo();

            }

        }




    }
}

class BankAccount {
    int number;
    int balance;
    int interestBalance=3;

    double getDohodForYear(){
        return  balance * interestBalance / 100.0;
    }

    void printInfo(){
        System.out.println("Номер счета: " + number +
                " Баланс счета: " + balance +
                " Процент на остаток: " + interestBalance + " %");
    }
}