package lesson7_2_arrayList;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();
        ArrayList<Integer> list = new ArrayList<>(); //10
//        ArrayList<String> list2 = new ArrayList<>(); //10
//        ArrayList<Double> list3 = new ArrayList<>(); //10
//        ArrayList<Fruit> list4 = new ArrayList<>(); //10
        for (int i = 0; i < 5; i++) {
            list.add(rnd.nextInt(-10,10));
        }
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i+": "+list.get(i));
        }

        //CONTAINS - проверяет на наличие и возвраащет true/false
        if(list.contains(3)){
            System.out.println("число есть в списке");
        }else{
            System.out.println("числа нет в списке");
        }

        //IndexOf - возвращает индекс элемента, либо -1, если элемент не найден
        int index = list.indexOf(3);
        if(index == -1){
            System.out.println("числа нет в списке");
        }else{
            System.out.println("Число находится под индексом: "+index);
        }

        //REMOVE - удаление
        //удалим элемент под индексом 1
        Integer removed = list.remove(1); //возвращает удаленный элемент
        System.out.println("вы удалили число: "+removed);
        System.out.println(list);

        //удалим элемент по значению (удалим число 1)
        Integer val = 1;
        boolean remove = list.remove(val);//возвращает true, если удаление произошло
        if(remove){
            System.out.println("число удалено");
        }else{
            System.out.println("число не найдено");
        }
        System.out.println(list);


        //contains, remove, indexOf с объектами пока работать не будут
        //поэтому их надо делать вручную
        ArrayList<Fruit> fruits = new ArrayList<>();
        fruits.add(new Fruit("apple", 10));
        fruits.add(new Fruit("orange", 20));

        String name = "apple";
        int price = 10;
        boolean exist = false;
        for (Fruit fruit : fruits) {
            if (fruit.name.equals(name) && fruit.price == price) {
                exist = true;
                break;
            }
        }
        if(!exist){
            System.out.println("не сущестует");
        }else{
            System.out.println("существует");
        }

    }
}

class Fruit{
    String name;
    int price;

    public Fruit(String name, int price) {
        this.name = name;
        this.price = price;
    }
}