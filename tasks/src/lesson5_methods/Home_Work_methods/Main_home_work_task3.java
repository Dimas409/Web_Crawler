package lesson5_methods.Home_Work_methods;

import java.util.Random;
import java.util.Scanner;

public class Main_home_work_task3 {
    public static void main (String[] args) {
        Laptop[] laptops = new Laptop[5];
        Random rnd = new Random();
        for (int i = 0; i < laptops.length; i++) {
            Laptop laptop = new Laptop();
            laptop.cores = rnd.nextInt(1, 8);
            laptop.ram = rnd.nextInt(4, 32);
            laptop.videoRam = rnd.nextInt(1, 4);
            laptops[i] = laptop;
        }
        int count = 1;
        for (int i = 0; i < laptops.length; i++) {

            System.out.println("Ноутбук номер :" + count );
            laptops[i].printInfoLaptop();
            System.out.print(" Количество FPS: ");
            laptops[i].printFPS();
            System.out.println("*********************");

            count++;

        }
        Scanner scn = new Scanner(System.in);
        int input = 0;
        while (input != 5) {
            System.out.println(
                    "1. Вывести все видеокарты\n" +
                    "2. Посчитать fps ноутбука под индексом x\n" +
                    "3. Прокачать ноутбук под индексом x (юзер вводит x и новое значение для cores и videoRam)\n" +
                    "4. Найти самую мощный ноутбук по значению fps " +
                            "(нужно найти целиком объект и вывести его поля на консоль)\n" +
                    "5. Выход");
            input = scn.nextInt();
            if (input == 1) {
                for (int i = 0; i < laptops.length; i++) {
                    System.out.print("Карта № " + (i+1));
                    laptops[i].printInfoVideoRam();
                }
            }
            if (input == 2) {
                System.out.println("Введите номер индекса ноутбука у которого вы хотите узнать количество FPS: ");
                int index = scn.nextInt();
                System.out.println("Количество FPS интересующего вас ноутбука: ");
                laptops[index].printFPS();

            }
            if (input == 3) {
                System.out.println("Введите индекс ноутбука который вы хотите прокачать: ");
                int index = scn.nextInt();
                System.out.println("Введите новое значение количества ядер: ");
                laptops[index].cores = scn.nextInt();
                System.out.println("Введтие новое значение количества видео памяти: ");
                laptops[index].videoRam = scn.nextInt();
                System.out.println(" Новые параметры ноутбука колличество ядер:");
                laptops[index].printInfoLaptop();
            }
            if (input == 4) {
                int max = 0;
                int maxIndex = 0;
                for (int i = 0; i < laptops.length; i++) {
                    for (int j = 0; j < laptops.length; j++) {
                         max = Math.max(max, laptops[i].calcFPS());
                         maxIndex = i;
                    }
                }
                System.out.println(" Самый мощный ноутбук из списка");
                laptops[maxIndex].printInfoLaptop();
                System.out.print(" Количество FPS: " + max + "\n");

            }
        }



    }
}
class Laptop{
    int ram;
    int cores;
    int videoRam;
    public  void printInfoVideoRam( ){
            System.out.println(" объем памяти " + videoRam + " gb.");


    }
    int calcFPS(){
        return (ram*2)+(cores*3)+(videoRam*4);
    }
    void printFPS() {
        System.out.println(calcFPS());
    }

     void printInfoLaptop(){
        System.out.println(" Количество ядер: "
                + cores + "\n Количество оперативной памяти: " +
                ram + " gb." + "\n Количество видео памяти: " + videoRam + " gb. "+"fps: "+calcFPS());
    }
}