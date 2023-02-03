package lesson2.Homework;

import java.util.Scanner;

public class Main_home_work_task5 {
    public static void main(String[] args){
//        Задача 5 Создать массив на 5 элементов, заполнить его строками с консоли.
//        Далее, после заполнения, считать с консоли одну строку и проверить, есть ли она в массиве.
//        Программа должна вывести: Строка есть в массиве или Строки нет в массиве

        Scanner scn = new Scanner(System.in);
        String[] arr = new String[5];
        System.out.println("Fill the array");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.next();
            System.out.println(arr[i]);
        }
        System.out.println("Input the line to check it exist in the array");
        String check = scn.next();
        boolean isExist = false;
        for (int i = 0; i < arr.length; i++){
            if(check.equals(arr[i])){
                System.out.println("The line is exist in the array");
                isExist = true;
            }
        }
        if(!isExist){
            System.out.println("The line has not exist in this array");
        }


    }
}
