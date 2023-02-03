package lesson3_remove_from_array;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        //Более правильный способ удаления с сохранением порядка через смещение всех элементов справа от удаленного влево


        Scanner scn = new Scanner(System.in);
        String[] arr = {"10", "20", "30", "40", "50"};
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
                //10 20 30 40 50
                //начинаем смещение от удаленного
                for (int i = index; i < size - 1; i++) {
                    arr[i] = arr[i+1]; //коприуем элемент под большьим индекс на позицию под меньшим на единицу индексом
                }
                arr[size-1] = null; //обнуляем последний элемент, чтобы не оставалось дубликатов
                size--;

            }

        }
    }
}
