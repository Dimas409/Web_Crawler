package lesson4_1_double_arrays.Homework;

import java.util.Arrays;
import java.util.Random;

public class Main_home_work_task2 {
    public static void main(String[] args) {
//        Задача 2 Создать двумерный массив 2 на 3. Проинициализировать его случайными числами от
//        -10 до 10. Вывести двумерный массив на консоль в виде таблицы любым способом.
//        После каждой строчки матрицы вывести пять звездочек.
//        Пример:
//        4 2 3
//        *****
//        4 1 3
//        *****
        Random rnd = new Random();
        int[][] doublyArr = new int[2][3];
        for (int i = 0; i < doublyArr.length; i++) {
            for (int j = 0; j < doublyArr[i].length; j++) {
                doublyArr[i][j] = rnd.nextInt(-10, 10);
            }
        }
        printArray(doublyArr);
    }

    private static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
                System.out.print(" ");
            }
            System.out.println();
            System.out.println("*****");

        }
    }
}
