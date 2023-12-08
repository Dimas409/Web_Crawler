package lesson9_equals_toString.Homework;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main_home_work_task2 {
    public static void main(String[] args) {
        ArrayList<Cat> cats = new ArrayList<>();
        cats.add(new Cat("Мурзик", 2.6, "Серый" ));
        cats.add(new Cat("Пушистик", 2.9, "Белый"));
        cats.add(new Cat("Барсик", 3.5, "Мраморный"));
        cats.add(new Cat("Васька", 3.3, "Чёрный" ));
        cats.add(new Cat("Арчи", 2.7, "Черепаховый"));
        Scanner scn = new Scanner(System.in);
        int input = 0;
        String nameCat;
        String colorCat;
        while (input != 4) {
            System.out.println("""
                    1. Вывести всех котов
                    2. Юзер вводит имя кота и его цвет, программа выводит вес кота
                    3. Удалить кота из списка (юзер вводит имя и цвет)""");
            input = scn.nextInt();
            if (input == 1) {
                for (Cat cat : cats) {
                    System.out.println(cat);
                }
            } else if (input == 2) {
                System.out.println("Введите имя кота: ");
                nameCat = scn.next();
                System.out.println("Введите цвет кота: ");
                colorCat = scn.next();
                int index = cats.indexOf(new Cat(nameCat, 0, colorCat));
                if (index != -1) {
                    System.out.println(cats.get(index).getWeightOfCat());
                } else {
                    System.out.println("Имя кота или цвет введены неверно!");
                }
            } else if (input == 3) {
                System.out.println("Введите имя кота: ");
                String delNameCat = scn.next();
                System.out.println("Введите цвет кота: ");
                String delColorCat = scn.next();
                //TODO: удалить через метод remove
                cats.remove(new Cat(delNameCat, 0, delColorCat));
            }
        }

    }
}
class Cat {
    private String nameOfCat;
    private double weightOfCat;
    private String colorOfCat;

    public Cat(String nameOfCat, double weightOfCat, String colorOfCat) {
        this.nameOfCat = nameOfCat;
        this.weightOfCat = weightOfCat;
        this.colorOfCat = colorOfCat;
    }

    public String getNameOfCat() {
        return nameOfCat;
    }

    public void setNameOfCat(String nameOfCat) {
        this.nameOfCat = nameOfCat;
    }

    public double getWeightOfCat() {
        return weightOfCat;
    }

    public void setWeightOfCat(double weightOfCat) {
        this.weightOfCat = weightOfCat;
    }

    public String getColorOfCat() {
        return colorOfCat;
    }

    public void setColorOfCat(String colorOfCat) {
        this.colorOfCat = colorOfCat;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return Objects.equals(nameOfCat, cat.nameOfCat) && Objects.equals(colorOfCat, cat.colorOfCat);
    }

    @Override
    public String toString() {
        return " Кличка кота " + nameOfCat +
                ", вес " + weightOfCat +
                ", цвет " + colorOfCat ;
    }
}