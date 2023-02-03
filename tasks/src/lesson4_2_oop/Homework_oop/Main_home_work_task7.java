package lesson4_2_oop.Homework_oop;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main_home_work_task7 {
    public static void main (String[] args) {
//        Задача 7 Создать класс BankAccount с полями
//        сумму на счету
//        номер счета (уникальное значение)
//        процент на остаток (годовой процент)
//
//        Создайте массив счетов на 10 элементов и заполните его рандомно.
//        Не забудьте, что номер счета при этом не должен повторяться.
//                Создайте меню:
//        1. Вывести все счета
//        2. Вывести сумму на счете по номеру (юзер вводит номер счета)
//        3. Сделать перевод. Юзер вводит номер счета-отправителя, номер счета-получателя и сумму перевода.
//        Сделайте проверку, что баланса отправителя хватает для перевода
//        4. Найти счет, владелец которого заработает больше всех процентов, если будет держать деньги на нем целый год.
//        Прибыль за год вычисляется по формуле сумма на счету * процент на остаток / 100
//        5. Выход
//
//        Для пункта 3 вам нужно найти объект счета отправителя и получателя.
//        Проверить,что у отправителя на балансе хватает денег для перевода нужной суммы.
//        Если денег хватает, вам нужно уменьшить баланс отправителя на эту сумму и
//        увеличить баланс получателя на эту сумму (636782, 867923)
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
        while (input != 5) {

            System.out.println("" +
                    "           1. Вывести все счета\n" +
                    "           2. Вывести сумму на счете по номеру (юзер вводит номер счета)\n" +
                    "           3. Сделать перевод. Юзер вводит номер счета-отправителя, \n" +
                    "           номер счета-получателя и сумму перевода.\n" +
                    "           Сделайте проверку, что баланса отправителя хватает для перевода\n" +
                    "           4. Найти счет, владелец которого заработает больше всех процентов, \n" +
                    "           если будет держать деньги на нем целый год.\n" +
                    "           Прибыль за год вычисляется по формуле сумма на счету * процент на остаток / 100\n" +
                    "           5. Выход");
            input = scn.nextInt();
            if (input == 1) {
                for (int i = 0; i < bankAccounts.length; i++) {
                    System.out.println("Номер счета: " + bankAccounts[i].number +
                            " Баланс счета: " + bankAccounts[i].balance +
                            " Процент на остаток: " + bankAccounts[i].interestBalance + " %");
                }
            }
            if (input == 2) {
                System.out.println(" Введите номер счета: ");
                int numberAccount = scn.nextInt();
                for (int i = 0; i < bankAccounts.length; i++) {
                    if (bankAccounts[i].number == numberAccount) {
                        System.out.println("Номер счета: " + bankAccounts[i].number +
                                " Баланс счета: " + bankAccounts[i].balance +
                                " Процент на остаток: " + bankAccounts[i].interestBalance + " %");
                    }
                }
            }
            if (input == 3) {
                System.out.println("Введите счет отправителя: ");
                int senderAccount = scn.nextInt();
                System.out.println("Введите счет получателя");
                int receiverAccount = scn.nextInt();
                System.out.println("Введите сумму перевода: ");
                int sumSend = scn.nextInt();
                boolean isEnough = false;
                for (int i = 0; i < bankAccounts.length; i++) {
                    if (bankAccounts[i].number == senderAccount
                            && bankAccounts[i].balance >= sumSend) {
                        bankAccounts[i].balance -= sumSend;
                        isEnough = true;
                        System.out.println("Номер счета: " + bankAccounts[i].number +
                                " Баланс счета: " + bankAccounts[i].balance +
                                " Процент на остаток: " + bankAccounts[i].interestBalance + " %");
                    }
                    if (bankAccounts[i].number == receiverAccount && isEnough) {
                        bankAccounts[i].balance += sumSend;
                        System.out.println("Номер счета: " + bankAccounts[i].number +
                                " Баланс счета: " + bankAccounts[i].balance +
                                " Процент на остаток: " + bankAccounts[i].interestBalance + " %");
                    }
                    if (!isEnough) {
                        System.out.println(" Денег на счете не достаточно! ");
                    }
                }
            }
            if (input == 4) {
                int maxDohod = 0;
                int maxIndex = 0;
                for (int i = 0; i < bankAccounts.length; i++) {
                    int dohod = bankAccounts[i].balance * bankAccounts[i].interestBalance / 100;
                    if (dohod > maxDohod) {
                        maxDohod = dohod;
                        maxIndex = i;
                    }
                }
                System.out.println("Номер счета: " + bankAccounts[maxIndex].number +
                        " Баланс счета: " + bankAccounts[maxIndex].balance +
                        " Процент на остаток: " + bankAccounts[maxIndex].interestBalance + " у.е., dohod = "+maxDohod);
            }

        }




    }
}

class BankAccount {
    int number;
    int balance;
    int interestBalance=3;
}