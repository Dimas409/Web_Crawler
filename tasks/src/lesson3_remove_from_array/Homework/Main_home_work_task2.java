package lesson3_remove_from_array.Homework;

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

        Scanner scn = new Scanner(System.in);
        String[] arr = {"one", "two", "three", "four", "five"};
        int index = 0;
        System.out.print("Enter the value: ");
        String input = scn.next();
        for (int i = 0; i < arr.length; i++) {
            if (Objects.equals(input, arr[i])) {
                index = i;
            }
        }
        for (int i = index; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length-1] = null;
        System.out.println(Arrays.toString(arr));
    }
}
