package lesson7_1_inner_objects.Homework;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main_home_work_task5 {
    public static void main(String[] args) {
        Random rnd = new Random();
        Scanner scn = new Scanner(System.in);
        //TODO: создать класс BankCard и заменить три списка на список ArrayList<BankCard>
        ArrayList<BankCard> bankCards = new ArrayList<>();
//        ArrayList<Integer> balance = new ArrayList<>();
//        ArrayList<Integer> cashback = new ArrayList<>();
        String[] holders = {"Вася", "Петя", "Катя", "Наташа", "Степан"};
        int index;
        for (int i = 0; i < 5; i++) {
            BankCard bankCard = new BankCard(null, 0, 0);
            bankCard.setHolder(holders[i]);
            bankCard.setBalance(rnd.nextInt(1000, 5000));
            bankCard.setCashback(rnd.nextInt(100, 2000));
            bankCards.add(bankCard);
        }
        int price;
        int input = 0;
        while (input != 5){
            System.out.println("""
                    1. Вывести все карты
                    2. Сделать покупку 
                    3. Потратить кэшбэк на карте 
                    4. Сделать покупку
                    5. Выход""");
            input = scn.nextInt();
            int tempBalance;
            int tempCashback;
            String tempHolder;
            if (input == 1) {
                for (BankCard bankCard : bankCards) {
                    System.out.println(bankCard.toString());
                }
                System.out.println();
            } else if (input == 2) {
                System.out.println("Введите индекс карты: ");
                index = scn.nextInt();
                System.out.println("Введите сумму покупки: ");
                price = scn.nextInt();
                if(bankCards.get(index).getBalance() >= price) {
                    tempBalance = bankCards.get(index).getBalance();
                    tempBalance-= price;
                    bankCards.get(index).setBalance(tempBalance);
                    tempCashback = bankCards.get(index).getCashback();
                    tempCashback = tempCashback + (price * 2/100);
                    bankCards.get(index).setCashback(tempCashback);
                } else {
                    System.out.println("На карте не достаточно средств");
                }
            } else if (input == 3) {
                System.out.println("Введите индекс карты: ");
                index = scn.nextInt();
                tempBalance = bankCards.get(index).getBalance();
                tempCashback = bankCards.get(index).getCashback();
                tempBalance += tempCashback;
                bankCards.get(index).setBalance(tempBalance);
                bankCards.get(index).setCashback(0);
            } else if (input == 4) {
                System.out.println("Введите имя владельца карты: ");
                tempHolder = scn.next();
                System.out.println("Введите сумму покупки");
                price = scn.nextInt();
                for (int i = 0; i < bankCards.size(); i++) {
                    if (bankCards.get(i).getHolder().equals(tempHolder) && bankCards.get(i).getBalance() >= price){
                        index = bankCards.get(i).getHolder().indexOf(tempHolder);
                        tempBalance = bankCards.get(index).getBalance();
                        tempCashback = bankCards.get(index).getCashback();
                        tempBalance -= price;
                        bankCards.get(index).setBalance(tempBalance);
                        tempCashback = tempCashback + (price * 2)/100;
                        bankCards.get(index).setCashback(tempCashback);
                    }
                }
            } else if (input == 5){
                break;
            }
        }

    }
}
class BankCard {
    private String holder;
    private int balance;
    private int cashback;

    public BankCard(String holder, int balance, int cashback) {
        this.holder = holder;
        this.balance = balance;
        this.cashback = cashback;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getCashback() {
        return cashback;
    }

    public void setCashback(int cashback) {
        this.cashback = cashback;
    }

    @Override
    public String toString() {
        return "Держатель карты = " + holder +
                ", Балланс = " + balance +
                ", Кешбэк =" + cashback ;
    }
}
