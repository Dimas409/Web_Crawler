package lesson2.Homework;



import java.util.Random;
import java.util.Scanner;

public class Main_home_work_task1 {
    public static void main (String[] args){
//        Задача 1 Создать массив на 10 элементов, заполнить его числами в диапазоне от
//        100 до 1000. Пользователь вводит с консоли числа m и n, вывести на консоль
//        числа из массива, которые находятся в диапазоне от m до n.
//        К примеру, есть массив {1,8,4}, m = 2, n = 10 тогда программа должна вывести:8 4
        Random rnd = new Random();
//        int[] arr = {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000};
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(100, 1000);
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        Scanner scn = new Scanner(System.in);
        System.out.print("Input number m: ");
        int m = scn.nextInt();
        System.out.print("Input number n: ");
        int n = scn.nextInt();


        for (int i = 0; i < arr.length; i++){
            if (m <= arr[i] && n >= arr[i]){
                System.out.println(arr[i]);
            }



        }


    }
}
