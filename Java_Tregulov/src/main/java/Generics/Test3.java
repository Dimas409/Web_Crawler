package Generics;

import java.util.ArrayList;
import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        List<? extends Number> list30 = new ArrayList<Integer>();
        List<Double> list1= new ArrayList<>();
        list1.add(3.14);
        list1.add(3.15);
        list1.add(3.16);
        showListInfo(list1);
        List<String> list2 = new ArrayList<>(List.of("ok", "privet", "poka"));
        showListInfo(list2);
        ArrayList<Double> list3= new ArrayList<>();
        list3.add(3.14);
        list3.add(3.15);
        list3.add(3.16);
        System.out.println(summ(list3));

        ArrayList<Integer> list4= new ArrayList<>();
        list4.add(3);
        list4.add(35);
        list4.add(30);
        System.out.println(summ(list4));

    }
    static void showListInfo(List<?> list){
        System.out.println("Мой лист содержит следующие элементы: " + list);
    }
    public static double summ (ArrayList<? extends Number> arrayList){
        double summ = 0;
        for(Number n : arrayList){
            summ+=n.doubleValue();
        }
        return summ;
    }
}
