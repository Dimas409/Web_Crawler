package lesson3_remove_from_array;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        //Более простой способ удаления, но он изменяет порядок элементов


        Scanner scn = new Scanner(System.in);
        String[] arr = {"10", "20", "30", "40", "50", null, null};
        int size = 5;
        int input = 0;
        while(input!=3){
            System.out.println("1. Add");
            System.out.println("2. Remove by index");
            System.out.println("3. Print");
            System.out.println("4. Exit");
            input = scn.nextInt();
            if(input == 1){
                System.out.print("Enter value: ");
                arr[size] = scn.next();
                size++;
            }
            else if(input == 2){
                System.out.print("Enter index: ");
                int index = scn.nextInt();
                String lastItem = arr[size-1]; //берем последний элемент из массива
                arr[index] = lastItem; //копируем последний элемент на место удаляемого
                arr[size-1] = null; //удаляем последний элемент
                size--; //уменьшаем кол-во имеющихся элементов
                //index = 1
                //size = 5
                //10 20 30 40 50 null null

                //10 null 30 40 null null null

            }

        }
    }
}
