package lesson2.Homework;

import java.util.Objects;
import java.util.Scanner;

public class Main_home_work_task6 {
    public static void main(String[] args) {
//        Задача 6 Сделать список покупок на 5 элементов в виде массива.
//        Создать консольное меню:
//        1. Добавить покупку (юзер вводит название покупки.
//        Новую покупку можно добавить только, если ее еще нет в списке)
//        2. Вывести список покупок (все элементы, кроме null)
//        3. Вывести на консоль количество добавленных покупок
//        (то есть результатом должно быть одно число - кол-во не null покупок)
//        4. Удалить покупку (юзер вводит индекс и нужно приравнять значение под индексом к null)
//        5. Выход

        Scanner scn = new Scanner(System.in);
        int input = 0;
        String purchase;
        String[] purchasesList = new String[5];
        int newPurchaseIndex = 0;
        while(input != 5) {

            System.out.println("""
                            1. Добавить покупку (юзер вводит название покупки.
                            Новую покупку можно добавить только, если ее еще нет в списке)
                            2. Вывести список покупок (все элементы, кроме null)
                            3. Вывести на консоль количество добавленных покупок
                            (то есть результатом должно быть одно число - кол-во не null покупок)
                            4. Удалить покупку (юзер вводит индекс и нужно приравнять значение под индексом к null)
                            5. Выход\
                    """);
            input = scn.nextInt();
            if (input == 1){
                System.out.println("Введите название покупки");
                purchase = scn.next();
                int toManyPurchases = 0;
                for (int i = 0; i < purchasesList.length; i++){
//                    if (purchasesList[i]!=null && purchasesList[i].equals(purchase)){
                    if (Objects.equals(purchasesList[i], purchase)){
                        toManyPurchases++;
                    }
                }
                if(toManyPurchases==0) {
                    purchasesList[newPurchaseIndex] = purchase;
                    newPurchaseIndex++;
                    System.out.println("Добавлено");
                }else{
                    System.out.println("Покупка уже есть");
                }
            }
            else if (input == 2) {
                for (int i = 0; i < purchasesList.length; i++) {
                    if (purchasesList[i] != null ) {
                        System.out.println(purchasesList[i]);
                    }

                }
            }
            else if (input == 3) {
                System.out.println("Количество покупок: " + newPurchaseIndex);
            }
            else if (input == 4) {
                System.out.print("Enter index: ");
                int index = scn.nextInt();
                for (int i = index; i < newPurchaseIndex -1; i++) {
                    purchasesList[i] = purchasesList[i + 1];
                }
                purchasesList[newPurchaseIndex - 1] = null;
                newPurchaseIndex--;

            }
        }
    }
}
