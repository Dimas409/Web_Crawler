package lesson2.Homework;

import java.util.Scanner;

public class Main_home_work_task4 {
    public static void main(String[] args){
//        Задача 4 Создать массив на 5 элементов,заполнить его числами с консоли,
//        вывести элементы массива в одну строку.
//        Найти среднее арифметическое.
        Scanner scn = new Scanner(System.in);
        int[] arr = new int[5];
        int middle = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();

            sum = sum + arr[i];
        }
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("");
        middle = sum / arr.length;

        System.out.println("Middle arithmetic value " + middle );


    }
}
