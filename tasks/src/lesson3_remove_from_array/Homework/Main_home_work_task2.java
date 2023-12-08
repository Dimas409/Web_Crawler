package lesson3_remove_from_array.Homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main_home_work_task2 {
    public static void main (String [] args) {

//        Задача 2 Есть массив
//        String[] arr = {"one", "two", "three", "four", "five"}
//
//        Далее юзер вводит с консоли строчку.
//        Найдите строчку в массиве и удалите ее с помощью сдвига влево
        ArrayList<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        Scanner scn = new Scanner(System.in);
        int index ;
        System.out.print("Enter the value: ");
        String input = scn.next();
        index = list.indexOf(input);
        list.remove(index);
        System.out.println(list);
    }
}
