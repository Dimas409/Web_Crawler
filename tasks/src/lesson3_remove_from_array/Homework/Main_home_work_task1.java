package lesson3_remove_from_array.Homework;

import java.util.Arrays;
import java.util.Scanner;

public class Main_home_work_task1 {
    public static void main (String[] args) {
//        Задача 1 Есть массив
//        String[] arr = {"one", "two", "three", "four", "five"}
//
//        Далее юзер вводит с консоли индекс.
//        Удалите элемент под индексом с помощью сдвига влево
        Scanner scn = new Scanner(System.in);
        String[] arr = {"one", "two", "three", "four", "five"};
        System.out.println("Enter the index of number to delete it.");
        int input = scn.nextInt();
        for (int i = input; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];


        }
        arr[arr.length - 1] = null;
        System.out.println(Arrays.toString(arr));

    }
}
