package lesson6_1_constructos.Homework;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main_home_work_task5 {
    public static void main(String[] args) {
        MyArray array = null;
        Scanner scn = new Scanner(System.in);
        int input = 0;
        while (input != 9) {
            System.out.println("""
                    1. Создать массив (конструктор по умолчанию)
                    2. Создать массив на n элементов (пользователь вводит количество элементов)
                    3. Создать массив с элементами в своем диапазоне
                    4. Создать массив размером n с элементами в своем диапазоне
                    5. Вывести элементы на консоль
                    6. Найти максимум
                    7. Найти минимум
                    8. Найти сумму
                    9. Выход""");
            input = scn.nextInt();
            if (input == 1) {
                array = new MyArray();
            }
            if (input == 2) {
                System.out.println("Введите размер массива: ");
                int size = scn.nextInt();
                array = new MyArray(size);
            }
            if (input == 3) {
                array = new MyArray(45, 89);
            }
            if (input == 4) {
                System.out.println("Введите размер массива: ");
                int size = scn.nextInt();
                array = new MyArray(size, 55, 126);
            }
            if (input == 5) {
                array.printArray();
            }
            if (input == 6) {
                System.out.println(array.findMax());
            }
            if (input == 7) {
                System.out.println(array.findMin());
            }
            if (input == 8) {
                System.out.println(array.findSum());
            }

        }

    }
}
class MyArray {
    Random rnd = new Random();
    int[] arr;
    //TODO: убрать дублированный код из конструкторов за счет вызова конструктора из конструктора
    public MyArray() {
        this(5);
    }
    public MyArray(int size) {
        arr = new int [size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(-10, 10);
        }
    }
    public MyArray(int start, int end) {
        this(5, start, end);
    }
    public MyArray(int size, int start, int end) {
        arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(start, end);

        }
    }
    public void printArray() {
        System.out.println(Arrays.toString(arr));
    }
    public int findMax() {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
    public int findMin() {
        int min = 0;
        for (int i = 0; i < arr.length-1; i++) {
            //TODO: переписать через Math.min
            min = Math.min(min, arr[i]);
        }
        return min;
    }
    public int findSum() {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}