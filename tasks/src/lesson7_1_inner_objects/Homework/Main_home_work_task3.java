package lesson7_1_inner_objects.Homework;

import java.util.Random;
import java.util.Scanner;

public class Main_home_work_task3 {
    public static void main(String[] args) {
        Superman superman = new Superman();
        Random rdn = new Random();
        Scanner scn = new Scanner(System.in);
        //TODO: цикл должен заканчиваться, если высота больше 1000 или меньше -100
        while (superman.getTotalHeight() >= -100 && superman.getTotalHeight() <= 1000) {
            System.out.println("Супермен врезался или нет(yes, no) : ");
            String input = scn.next();
            if(input.equals("yes")){
                //TODO: доделать сеттер
                superman.setCurrentHeight(-50);
                System.out.println(superman.totalHeight());
            }else {
                //TODO: доделать сеттер
                superman.setCurrentHeight(rdn.nextInt(100, 200));
                System.out.println(superman.totalHeight());
            }
        }
        if(superman.getCurrentHeight() <= -100){
            System.out.println("Супермен проиграл");
        }
        if (superman.getCurrentHeight() >= 1000){
            System.out.println("Супермен победил");
        }

    }
}
class Superman {
    private int currentHeight = 0;
    private int totalHeight = 0;

    public int getTotalHeight() {
        return totalHeight;
    }

    public int getCurrentHeight() {
        return currentHeight;
    }

    public void setCurrentHeight(int currentHeight) {
        this.currentHeight = currentHeight;
    }
    public int totalHeight() {
        return totalHeight += currentHeight;
    }


}