package lesson8_inheritance;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main1 {
    public static void main(String[] args) {
        Student student1 = new Student("Ivan", 20, 4);
        Student student2 = new Student("Ivan", 20, 4);

        Worker worker1 = new Worker("Semen", 21, "IT");
        Worker worker2 = new Worker("Semen", 21, "IT");

        student1.printInfo();
        worker1.printInfo();

        //Object o = new Object();

        System.out.println(student1 == student2);
        System.out.println(student1.equals(student2));
        System.out.println(worker1.equals(worker2));

        ArrayList<Fruit> fruits = new ArrayList<>();
        fruits.add(new Fruit("apple", 11));
        fruits.add(new Fruit("orange", 10));


//        System.out.println("contains: "+fruits.contains(new Fruit("apple", 0)));
        int index = fruits.indexOf(new Fruit("orange", 0));
        if(index == -1){
            System.out.println("Фрукт не найден");
        }else{
            System.out.println("цена: "+fruits.get(index).price);
        }


        //TOSTRING
        Fruit orange = new Fruit("orange", 20);
        System.out.println(orange);

        //рекурсия  
//        test(0);
    }

    static void test(int i){
        if(i<10) {
            System.out.println(i+" hello");
            test(i+1);
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
}

//Human - родительский класс или суперкласс
class Human{
    String name;
    int age;

//    public Human() {
//        super(); //вызывается конструктор родительского класса Object
//    }

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void printInfo(){
        System.out.print(name+" "+age+" ");
    }
}

//класс Student наследует поля, методы и конструкторы (если они есть) из класса Human
//Student - наследник или подкласс
class Student extends Human{
    double averageMark;

    public Student(String name, int age, double averageMark) {
        super(name, age);
        this.averageMark = averageMark;
    }

    //переопределение (overrides) родительского метода в классе-наследнике
    //перепределение позволяет изменить реализцаию родительского метода в наследнике
    @Override
    void printInfo() {
        super.printInfo(); //обращаемся к родительскому методы
        System.out.println(averageMark);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return name.equals(student.name) && age == student.age && averageMark == student.averageMark;
    }
}

class Worker extends Human{
    String profession;

    public Worker(String name, int age, String profession) {
        super(name, age);
        this.profession = profession;
    }

    @Override
    void printInfo() {
        super.printInfo();
        System.out.println(profession);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return profession.equals(worker.profession) && name.equals(worker.name) && worker.age == age;
    }

}