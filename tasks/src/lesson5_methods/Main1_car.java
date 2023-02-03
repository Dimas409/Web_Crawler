package lesson5_methods;

import java.util.Random;

public class Main1_car {
    public static void main(String[] args) {
//        Задача 5 Создать класс Car с полями:
//        марка
//        максимальная скорость
//        пробег (изначально у всех автомобилей равен нулю)
//
//        В мейне создать массив на 10 элементов и заполнить его объектами класса Car.
//                Выполните пункты:
//        1. Выведите все автомобили
//        2. Выведите автомобили с ненулевым пробегом
//        3. найдите максимальную скорость среди всех автомобилей
        Car[] cars = new Car[10];
        String[] modelsToyota = {"Alphard", "C-HR", "Camry", "Corolla",
                "Fortuner", "Hiace", "Highlander", "Hilux", "RAV4", "2000GT"};
        int[] arrMaxSpeed = {219, 200, 195, 210, 185, 180, 150, 180, 170, 190};
        Random rnd = new Random();
        for (int i = 0; i < cars.length; i++) {
            Car car = new Car();
            car.model = modelsToyota[i];
            car.maxSpeed = arrMaxSpeed[i];
            car.mileage = rnd.nextInt(0, 100000);
            cars[i] = car;

        }

        System.out.println("All cars:");
        for (int i = 0; i < cars.length; i++) {
//            System.out.println("Toyota: " + cars[i].model + " Max speed: " +
//                    cars[i].maxSpeed + " Mileage: " + cars[i].mileage);
            cars[i].printInfo();
        }
        System.out.println("Cars with not empty mileage");
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].mileage > 0) {
//                System.out.println("Cars with mile Toyota: " + cars[i].model + " Max speed: " +
//                        cars[i].maxSpeed + " Mileage: " + cars[i].mileage);
                cars[i].printInfo();
            }
        }
        //TODO: исправить поиск максимума
        int maxIndex = 0;
        int maxSpeed = 0;
        for (int i = 0; i < cars.length - 1; i++) {
//            if (cars[i].maxSpeed > cars[i + 1].maxSpeed) {
//                maxSpeed = cars[i].maxSpeed;
//                maxIndex = i;
//            } else {
//                maxSpeed = cars[i + 1].maxSpeed;
//                maxIndex = i;
//            }
            if (maxSpeed < cars[i].maxSpeed) {
                maxSpeed = cars[i].maxSpeed;
                maxIndex = i;
            }
        }

//        System.out.println("Max speed auto Toyota: " + cars[maxIndex].model + " Max speed: " +
//                cars[maxIndex].maxSpeed + " Mileage: " + cars[maxIndex].mileage);
        System.out.print("Max speed car: ");
        cars[maxIndex].printInfo();


    }

}

class Car {
    String model;
    int maxSpeed;
    int mileage;

    void printInfo(){
        System.out.println("Toyota: " + model + " Max speed: " + maxSpeed + " Mileage: " + mileage);
    }
}
