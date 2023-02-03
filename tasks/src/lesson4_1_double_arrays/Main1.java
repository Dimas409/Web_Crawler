package lesson4_1_double_arrays;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        //2(0,0) 3(0,1) 4 (0,2)
        //5(1,0) 2(1,1) 1(1,2)


//        int[] arr1 = {{1,2,3},{5,4,3},{10,2,5}};
//        int[] arr2 = {5,2,1};
//
//        int[][] doublyArr = new int[2][3];
//        doublyArr[0] = arr1;
//        doublyArr[1] = arr2;


        //Заполнение двумерного массива
        //2 - кол-строк или кол-во одномерных массивов
        //3 - кол-во элементов одномерного массива
        int[][] doublyArr = new int[2][3];
        Random rnd = new Random();
        //заполнение вручную
//        doublyArr[0][0] = rnd.nextInt(1,10);
//        doublyArr[0][1] = rnd.nextInt(1,10);
//        doublyArr[0][2] = rnd.nextInt(1,10);
//
//        doublyArr[1][0] = rnd.nextInt(1,10);
//        doublyArr[1][1] = rnd.nextInt(1,10);
//        doublyArr[1][2] = rnd.nextInt(1,10);

        //заполнение циклом
        //doublyArr.length - дает всегда первую цифру (кол-во строк или одномерных массивов)
        //doublyArr[i].length - дает всегад вторую цифру (кол-во элементов в одномерном массиве под индексом i)
        for (int i = 0; i < doublyArr.length; i++) {
            for (int j = 0; j < doublyArr[i].length; j++) {
                //System.out.println(i+" "+j);
                doublyArr[i][j] = rnd.nextInt(1,10);
            }
            System.out.println(Arrays.toString(doublyArr[i]));
        }


        Scanner scn = new Scanner(System.in);
        System.out.println("юзер вводит индекс строки, найти максимальное значение в этой строке");
        System.out.print("Enter индекс строки: ");
        int row_index = scn.nextInt();
        int[] arr = doublyArr[row_index]; //выписываем одномерный массив из строки row_index и сохраняем его в отдельную переменную
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        System.out.println("max = " + max);




        System.out.println("Пример ступенчатого массива (когда кол-во элементов у одномерных массов разное)");
        int[][] d = new int[3][];
        d[0] = new int[]{1,2};
        d[1] = new int[]{1,2,3};
        d[2] = new int[]{10};

        for (int i = 0; i < d.length; i++) {
            System.out.println(Arrays.toString(d[i]));
        }








    }
}
