package lesson2.Homework;

public class Main_home_work_task3 {
    public static void main (String[] args){
//        Задача 3 Создать массив на 5 элементов, заполнить его числами в диапазоне
//        от -10 до 100, вывести элементы массива в одну строку. Найти минимальный,
//        максимальный и сумму элементов.
        int[] arr = {-10, -5, 0, 65, 100};
        int max = arr[0];
        int min = arr[0];
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] > max){
                max = arr[i];
            }
            if (arr[i] < min){
                min = arr[i];
            }
            sum += arr[i];
            System.out.print(arr[i]+ " ");

        }
        System.out.println("");
        System.out.println("Min value: "+ min);
        System.out.println("Max value: "+ max);
        System.out.println("Sum of values:"+ sum);

    }
}
