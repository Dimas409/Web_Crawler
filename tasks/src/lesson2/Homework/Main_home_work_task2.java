package lesson2.Homework;

public class Main_home_work_task2 {
    public static void main (String[] args){
//        Задача 2 Создать массив на 10 элементов, заполнить его числами
//        в диапазоне от 0 до 100, вывести элементы массива в вместе с их индексами.
//        К примеру, есть массив {1,8,4}, тогда программа должна вывести:
//        0: 1
//        1: 8
//        2: 4
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        for (int i = 0; i < arr.length; i++){
            System.out.println(i +":"+ arr[i]);
        }

    }
}
