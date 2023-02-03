package lesson5_methods;

import java.util.Random;

public class Main5_rectangle {
    public static void main(String[] args) {
        Random rnd = new Random();
        Rectangle[] arr = new Rectangle[10];
        for (int i = 0; i < arr.length; i++) {
            Rectangle rec = new Rectangle();
            rec.a = rnd.nextInt(1, 10);
            rec.b = rnd.nextInt(1, 10);
            arr[i] = rec;
        }

        System.out.println("1. Вывести все прямоугольники и их площадь");
        for (int i = 0; i < arr.length; i++) {
            arr[i].printInfo();
        }

        System.out.println("2. Вывести прямоугольники с площадью больше 5");
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].getSquare() > 10) {
                arr[i].printInfo();
            }
        }
    }
}

class Rectangle{
    int a, b;

    public void printInfo(){
        System.out.println("a = "+a+", b = "+b+", square = "+getSquare());
    }
    //возвращает площадь прямоугольника
    public int getSquare(){
        return a*b;
    }

}