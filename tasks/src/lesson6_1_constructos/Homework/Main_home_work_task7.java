package lesson6_1_constructos.Homework;

import java.util.Scanner;

public class Main_home_work_task7 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        SprayPaint[] sprays = new SprayPaint[] {
                new SprayPaint("green", 10),
                new SprayPaint("red", 20),
                new SprayPaint("yellow", 40),
                new SprayPaint("blue", 30)};
        boolean exit = false;
        int max = 0;
        int index = 0;
        while (!exit) {
            System.out.println("""
                    1. Вывести все баллончики
                    2. Вывести название цвета и объем самого большого баллончика
                    3. Нарисовать картинку
                    4. Выход""");
            int input = scn.nextInt();
            switch (input) {
                case 1 -> {
                    for (SprayPaint spray : sprays) {
                        spray.printInfo();
                    }
                }
                case 2 -> {
                    for (int i = 0; i < sprays.length; i++) {
                        if (sprays[i].volume > max){
                            max = sprays[i].volume;
                            index = i;
                        }
                    }
                    if (sprays[index].volume == max){
                        System.out.println(sprays[index].color + " - " + sprays[index].volume);
                    }
                }
                case 3 -> {
                    System.out.println("Какой цвет вы хотите выбрать?");
                    String color = scn.next();
                    System.out.println("Какое количество пшиков нужно?");
                    int pshik = scn.nextInt();
                    boolean isEnough = false;
                    for (SprayPaint spray : sprays) {
                        if (spray.color.equals(color) && spray.volume >= pshik) {
                            for (int i = pshik; i > 0; i--) {
                                spray.pshik();
                                isEnough = true;
                            }
                        }
                    }
                    if (isEnough) {
                        System.out.println(" Рисунок готов!");
                    } else {
                        System.out.println("Недостаочно пшиков!");
                    }
                }
                case 4 -> exit = true;
            }
        }
    }
}
class SprayPaint {
    public int volume;
    public String color;

    public SprayPaint(String color, int volume) {
        this.volume = volume;
        this.color = color;
    }

    public void pshik() {
        System.out.println("Пшик");
        volume -= 1;
    }

    public void printInfo() {
        System.out.println("Объем баллончика: " + volume +" Цвет: " +  color);
    }

}