package lesson4_1_double_arrays.Homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main_home_work_task1 {
    public static void main(String[] args) {
//        Задача 1 Создать двумерный массив 2 на 4. Проинициализировать его случайными числами
//        от -10 до 10. Вывести двумерный массив на консоль в виде таблицы любым способом.
//        Найти максимальный и минимальный элементы во всем массиве
        Random rnd = new Random();
        ArrayList<Integer> list = new  ArrayList<>();
        for(int i = 0; i < 4; i++) {
            list.add(rnd.nextInt(-10, 10));
        }
        System.out.println(list);
        int maX = 0;
        for (int i = 0; i < 4; i++) {
            if (list.get(i) > maX){
                maX = list.get(i);
            }
        }
        System.out.println(maX);

        int[][] arr = new int[2][4];
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
        for (int[] ints : arr) {
            for (int anInt : ints) {
                if (max < anInt) {
                    max = anInt;
                }
                if (min > anInt) {
                    min = anInt;
                }

            }

        }
        System.out.println("Min " + min);
        System.out.println("Max " + max);
        List<Integer> list1 = Arrays.stream(arr).flatMap(row -> Arrays.stream(row).boxed()).collect(Collectors.toList());
        System.out.println(list1);





    }


}
