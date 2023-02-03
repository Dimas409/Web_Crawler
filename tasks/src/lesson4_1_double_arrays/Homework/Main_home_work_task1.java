package lesson4_1_double_arrays.Homework;

import java.util.Arrays;
import java.util.Random;

public class Main_home_work_task1 {
    public static void main(String[] args) {
//        Задача 1 Создать двумерный массив 2 на 4. Проинициализировать его случайными числами
//        от -10 до 10. Вывести двумерный массив на консоль в виде таблицы любым способом.
//        Найти максимальный и минимальный элементы во всем массиве
        int[][] arr = new int[2][4];
        Random rnd = new Random();
        int max = 0;
        int min = 0;
//        Заполнение массива случайными числами
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = rnd.nextInt(-10, 10);
            }
            System.out.println(Arrays.toString(arr[i]));
        }
//          Нахождение максимального и минимального значения в двумерном массиве
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (max < arr[i][j]) {
                    max = arr[i][j];
                }
                if (min > arr[i][j]) {
                    min = arr[i][j];
                }

            }

        }
        System.out.println("Min " + min);
        System.out.println("Max " + max);
//        int firstRowIndex = 0;
//        int[] firstArr = arr[firstRowIndex];
//        int secondRowIndex = 1;
//        int[] secondArr = arr[secondRowIndex];
//        for (int i = 0; i < firstArr.length; i++) {
//            max = Math.max(max, firstArr[i]);
//            min = Math.min(min, firstArr[i]);
//
//        }
//        for (int i = 0; i < secondArr.length; i++) {
//            max2 = Math.max(max2, secondArr[i]);
//            min2 = Math.min(min2, secondArr[i]);
//        }
//        int max;
//        int min;
//        if (max > max2) {
//            max = max;
//        } else {
//            max = max2;
//        }
//        if (min < min2) {
//            min = min;
//        } else {
//            min = min2;
//        }
//        System.out.println("max " + max);
//        System.out.println("min " + min);
//
    }


}
