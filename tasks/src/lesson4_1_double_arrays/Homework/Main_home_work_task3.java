package lesson4_1_double_arrays.Homework;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main_home_work_task3 {
    public static void main(String[] args) {
//        Задача 3 Создать двумерный массив 2 на 4. Проинициализировать его случайными числами от
//        -10 до 10. Вывести двумерный массив на консоль в виде таблицы любым способом.
//        Юзер вводит индекс строки, найти сумму элементов в этой строке.
        Random rnd = new Random();
        int[][] doubleArr = new int[2][4];
        for (int i = 0; i < doubleArr.length; i++) {
            for (int j = 0; j < doubleArr[i].length; j++) {
                doubleArr[i][j] = rnd.nextInt(-10, 10);
            }
            System.out.println(Arrays.toString(doubleArr[i]));
        }
        Scanner scn = new Scanner(System.in);
        System.out.print("Введите индекс строки: ");
        int inpIndex = scn.nextInt();
        int[] arr = doubleArr[inpIndex];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        System.out.println("Сумма равна: " + sum);


    }
}
