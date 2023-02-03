package lesson5_methods.Home_Work_methods;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main_home_work_task4 {
    public static void main(String[] args) {
        BankCard[] bankCards = new BankCard[5];
        String[] cardHolder = {"Ivan", "Katerina", "Jack", "Dmitriy", "Semion"};
        Random rnd = new Random();
        for (int i = 0; i < bankCards.length; i++) {
            BankCard bankCard = new BankCard();
            bankCard.cashback = rnd.nextInt(100, 2000);
            bankCard.balance = rnd.nextInt(1000, 5000);
            bankCard.holder = cardHolder[i];
            bankCards[i] = bankCard;

        }
        for (int i = 0; i < bankCards.length; i++) {
            bankCards[i].printInfo();
        }

        Scanner scn = new Scanner(System.in);
        int input = 0;
        while (input != 5) {
            System.out.println(
                    "1. Вывести все карты\n" +
                            "2. Сделать покупку (юзер вводит индекс карты x, сумму покупки price. " +
                            "Покупку можно сделать только, если на карте баланс больше цены покупки)\n" +
                            "3. Потратить кэшбэк на карте (юзер вводит индекс карты x, вам нужно перевести деньги с " +
                            "cashback на balance, то есть просто увеличить balance на сумму cashback, после чего обнулить cashback)\n" +
                            "4. Сделать покупку2 (юзер вводит не индекс, а имя владельца карты (holder) и сумму покупки price)\n" +
                            "5. Выход");
            input = scn.nextInt();
            if (input == 1) {
                for (int i = 0; i < bankCards.length; i++) {
                    bankCards[i].printInfo();
                }
            }
            if (input == 2) {
                System.out.println(" Введите индекс карты: ");
                int cardIndex = scn.nextInt();
                System.out.println(" Введите сумму покупки: ");
                int price = scn.nextInt();

                if (price <= bankCards[cardIndex].balance) {
                    bankCards[cardIndex].pay(price);
                    bankCards[cardIndex].getCashback(price);
                    bankCards[cardIndex].printInfo();
                }


            }
            if (input == 3) {
                System.out.println(" Введите индекс карты: ");
                int cardIndex = scn.nextInt();
                bankCards[cardIndex].balance += bankCards[cardIndex].cashback;
                bankCards[cardIndex].cashback = 0;
                bankCards[cardIndex].printInfo();

            }
            if (input == 4) {
                System.out.println(" Введите имя владельца карты: ");
                String nameHolder = scn.next();
                System.out.println(" Введите сумму покупки: ");
                int price = scn.nextInt();
                for (int i = 0; i < bankCards.length; i++) {
                    if (Objects.equals(nameHolder, bankCards[i].holder)) {
                        bankCards[i].pay(price);
                        bankCards[i].getCashback(price);
                        bankCards[i].printInfo();
                        break;
                    }
                }
            }
        }

    }
}

class BankCard {
    String holder;
    int balance;
    int cashback;

    void printInfo() {
        System.out.println(" Владелец карты " + holder +
                " Балланс " + balance + " Кэшбэк " + cashback);
    }

    int pay(int price) {
        return balance -= price;
    }

    int getCashback(int price) {
        return cashback += (2 * price) / 100;
    }


}