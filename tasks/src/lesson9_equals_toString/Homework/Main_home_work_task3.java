package lesson9_equals_toString.Homework;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main_home_work_task3 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        //TODO: добавить конструкторы и переписать заполнение списков
        ArrayList<Apple> apples = new ArrayList<>();
        apples.add(new Apple("Спартан", 80, "Красный"));
        apples.add(new Apple("Голден",95,"зеленый"));
        apples.add(new Apple("Ананасное",65,"золотисто-желтый"));
        apples.add(new Apple("Ауксис",85, "ярко-малиновый"));
        ArrayList<Lemon> lemons = new ArrayList<>();
        lemons.add(new Lemon("Павловский",120,3));
        lemons.add(new Lemon("Мейер" ,110,2));
        lemons.add(new Lemon("Китайский", 125,4));
        lemons.add(new Lemon("Дженоа", 150,5));
        int input = 0;
        String color;
        String name;
        while (input != 5) {
            System.out.println("""
                    1. Вывести все яблоки
                    2. Узнать цену яблока (юзер вводит название и цвет яблока)
                    3. Вывести все лимоны
                    4. Узнать цену лимона (юзер вводит с консоли название и степень кислоты лимона)""");
            input = scn.nextInt();
            if (input == 1) {
                for (Apple value: apples) {
                    System.out.println(value);
                }
            } else if (input == 2) {
                System.out.println("Введите цвет яблока");
                color = scn.next();
                System.out.println("Введите название яблока");
                name = scn.next();
                //TODO: заменить цикл на indexOf
                int indexApple = apples.indexOf(new Apple(name, 0, color));
                System.out.println("Цена яблок за один килограмм: " + apples.get(indexApple).getPriceOfFruit());
            } else if (input == 3) {
                for (Lemon value : lemons) {
                    System.out.println(value);
                }
            } else if (input == 4) {
                System.out.println("Степень кислоты");
                int acid = scn.nextInt();
                System.out.println("Введите название лимона");
                name = scn.next();
                //TODO: заменить цикл на indexOf
                int indexLemon = lemons.indexOf(new Lemon(name, 0, acid));
                System.out.println("Цена лимонов за один килограмм: " + lemons.get(indexLemon).getPriceOfFruit());
            }
        }


    }
}
class Fruit {
    private String nameOfFruit;
    private int priceOfFruit;

    public Fruit(String nameOfFruit, int priceOfFruit) {
        this.nameOfFruit = nameOfFruit;
        this.priceOfFruit = priceOfFruit;
    }

    public String getNameOfFruit() {
        return nameOfFruit;
    }

    public void setNameOfFruit(String nameOfFruit) {
        this.nameOfFruit = nameOfFruit;
    }

    public int getPriceOfFruit() {
        return priceOfFruit;
    }

    public void setPriceOfFruit(int priceOfFruit) {
        this.priceOfFruit = priceOfFruit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fruit fruit = (Fruit) o;
        return Objects.equals(nameOfFruit, fruit.nameOfFruit);
    }

    @Override
    public String toString() {
        return "Название фрукта " + nameOfFruit +
                ", цена " + priceOfFruit;
    }
}
class Apple extends Fruit {
    private String colorOfApple;

    public Apple(String nameOfFruit, int priceOfFruit, String colorOfApple) {
        super(nameOfFruit, priceOfFruit);
        this.colorOfApple = colorOfApple;
    }

    public String getColorOfApple() {
        return colorOfApple;
    }

    public void setColorOfApple(String colorOfApple) {
        this.colorOfApple = colorOfApple;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Apple apple = (Apple) o;
        return Objects.equals(colorOfApple, apple.colorOfApple) && super.equals(apple);
    }

    @Override
    public String toString() {
        return  "Сорт яблок: " + getNameOfFruit() +
                " цвет яблок: " + colorOfApple +
                " цена яблок: " + getPriceOfFruit();
    }
}
class Lemon extends Fruit {
    private int degreeOfAcid;

    public Lemon(String nameOfFruit, int priceOfFruit, int degreeOfAcid) {
        super(nameOfFruit, priceOfFruit);
        this.degreeOfAcid = degreeOfAcid;
    }


    public int getDegreeOfAcid() {
        return degreeOfAcid;
    }
    public void setDegreeOfAcid(int degreeOfAcid) {
        this.degreeOfAcid = degreeOfAcid;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Lemon lemon = (Lemon) o;
        //TODO: убрать дублированный код: Objects.equals(getNameOfFruit(), lemon.getNameOfFruit());
        return degreeOfAcid == lemon.degreeOfAcid && super.equals(lemon);
    }

    @Override
    public String toString() {
        return " Сорт лимона: "  + getNameOfFruit()+
                " Степень кислоты: " + degreeOfAcid +
                " Цена лимонов: " + getPriceOfFruit();
    }
}