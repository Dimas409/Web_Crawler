package lesson3_remove_from_array.Homework;

import java.util.ArrayList;
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
        ArrayList<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        System.out.println("Enter the index of number to delete it.");
        int input = scn.nextInt();
        list.remove(input);
        System.out.println(list);

    }
}
