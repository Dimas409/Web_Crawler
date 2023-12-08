package lesson10_static;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        //red, black, white
        //создать класс Car с методом перекраски и класс Pain (раскраска) с методом изменения цвета у кисточки
        MyColor.add("blue");
        Car car = new Car();
        car.changeColor();

        Paint paint = new Paint();
        paint.changeColor();


        //пример готовых статических методов и полей
        System.out.println(Math.max(2, 3));
        System.out.println(Math.PI);

    }
}

class MyColor{
    private static ArrayList<String> colors = new ArrayList<>();

    //статический блок (статический конструктор): срабатывает ОДИН раз при ПЕРВОМ обращении к ЛЮБОМУ статическому элементу класса (полю, методу)
    static{
        System.out.println("static block!");
        add("red");
        add("black");
        add("white");
    }

    public static void add(String color){
        if(color != null && !colors.contains(color)){
            colors.add(color);
        }
    }

    public static boolean checkColor(String color){
        return colors.contains(color);
    }
}
class Car{
    String color;


    //нестатический - аналог конструктора, только без параметров. Срабатывает при каждом создании нового объекта, как и конструтор
    {
        System.out.println("not static block");
    }

    public void changeColor(){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter color: ");
        String color = scn.next();
        if(MyColor.checkColor(color)){
            this.color = color;
        }else{
            System.out.println("Цвет введен не корректно");
        }
    }
}
class Paint{
    String color;

    public void changeColor(){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter color: ");
        String color = scn.next();
        if(MyColor.checkColor(color)){
            this.color = color;
        }
        else{
            System.out.println("Цвет введен не корректно");
        }
    }
}
