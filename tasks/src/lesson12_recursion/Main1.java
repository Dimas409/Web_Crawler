package lesson12_recursion;

import java.util.ArrayList;

public class Main1 {
    public static void main(String[] args) {
        //1. вывести hello world 10 раз с помощью рекурсии
//        task1(0);

        //2. вывести числа от start до end
        //task2(10, 16);

        //3. вывести список чисел с помощью рекурсии
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        task3(list, 0);

    }

    static void task3(ArrayList<Integer> list, int i){
        int sum = 0;
        if(i<list.size()) {
            System.out.println(list.get(i));
            task3(list, i+1);
        }
    }

    static void task2(int start, int end){
        if(start<end) {
            System.out.println(start);
            task2(start+1, end);
        }
    }


    static void task1(int i){
        if(i<5) {
            System.out.println(i+": hello world");
            task1(i+1);
        }
    }
}
