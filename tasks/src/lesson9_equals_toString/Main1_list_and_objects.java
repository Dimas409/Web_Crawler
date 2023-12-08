package lesson9_equals_toString;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main1_list_and_objects {
    public static void main(String[] args) {
        //два фрукта считаются одинаковыми, если их название совпадает
        Scanner scn = new Scanner(System.in);
        ArrayList<Fruit> fruits = new ArrayList<>();
        fruits.add(new Fruit("apple", 20));
        fruits.add(new Fruit("orange", 25));
        fruits.add(new Fruit("qiwi", 30));

        System.out.println("1. юзер вводит с консоли название фрукта и хочеть проверить: есть он или нет");
        System.out.print("Enter name: ");
        String fruitName = scn.next();
        Fruit fruit = new Fruit(fruitName, 20);

        if(fruits.contains(fruit)){
            System.out.println("фрукт содержится в списке");
        }else{
            System.out.println("фрукт не содержится в списке");
        }

        //метод contains будет делать следующие операции:
        System.out.println(fruits.get(0).equals(fruit));
        System.out.println(fruits.get(1).equals(fruit));
        System.out.println(fruits.get(2).equals(fruit));


        System.out.println("2. юзер вводит название фрукта и хочет изменть его цену");
        fruitName = scn.next();
        int index = fruits.indexOf(new Fruit(fruitName, 0));
        if(index != -1){
            System.out.print("Enter new price: ");
            Fruit f = fruits.get(index);
            f.setPrice(scn.nextInt());
            System.out.println("цена изменена!");
        }else{
            System.out.println("фрукт не найден");
        }

        System.out.println("выведем все элементы из списка");
        for (Fruit fruit1 : fruits) {
            System.out.println(fruit1); //toString вызывается в этой строке автоматически
        }


        System.out.println("3. юзер хочет удалить фрукт по названию");
        fruitName = scn.next();
        //вернет true в случае успешного удаления
        if(fruits.remove(new Fruit(fruitName, 0))){
            System.out.println("фрукт удален");
        }else{
            System.out.println("фрукт не найден");
        }

        System.out.println("выведем все элементы из списка");
        for (Fruit fruit1 : fruits) {
            System.out.println(fruit1); //toString вызывается в этой строке автоматически
        }
        //сравнение двух объектов
        Fruit f1 = new Fruit("qiwi", 30);
        Fruit f2 = new Fruit("qiwi", 30);
        Fruit f3 = f1; //f3 будет хранить такую же ссылку, как и f1 (на один и тот же объект)

        f1.setName("apple123123123"); //изменение названия приведет к изменению в f1 и f3
        System.out.println(f1.getName());
        System.out.println(f3.getName());
        System.out.println(f1 == f3); //сравнение по ссылке двух переменных, хранящие ссылку на один и тот же объект
        System.out.println(f1.equals(f2)); //сравнение по названию двух разных объектов


    }
}

class Fruit{
    private String name;
    private int price;

    public Fruit(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fruit fruit = (Fruit) o;
        return Objects.equals(name, fruit.name);
    }

    @Override
    public String toString() {
        return "name: " +name+", price: "+price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}