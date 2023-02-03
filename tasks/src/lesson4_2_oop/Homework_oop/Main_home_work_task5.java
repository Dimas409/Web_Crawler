package lesson4_2_oop.Homework_oop;

import java.util.Arrays;
import java.util.Random;

public class Main_home_work_task5 {
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
        int[] maxSpeed = {219, 200, 195, 210, 185, 180, 150, 180, 170, 190};
        Random rnd = new Random();
        for (int i = 0; i < cars.length; i++) {
            Car car = new Car();
            car.model = modelsToyota[i];
            car.maxSpeed = maxSpeed[i];
            car.mileage = rnd.nextInt(0, 100000);
            cars[i] = car;

        }
        int maxSpeed1 = 0;

        for (int i = 0; i < cars.length; i++) {
            System.out.println("Toyota: " + cars[i].model + " Max speed: " +
                    cars[i].maxSpeed + " Mileage: " + cars[i].mileage);
        }
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].mileage > 0) {
                System.out.println("Cars with mile Toyota: " + cars[i].model + " Max speed: " +
                        cars[i].maxSpeed + " Mileage: " + cars[i].mileage);
            }
        }
        int maxIndex = 0;
        for (int i = 0; i < cars.length - 1; i++) {
            if (cars[i].maxSpeed > cars[i + 1].maxSpeed) {
                maxSpeed1 = cars[i].maxSpeed;
                maxIndex = i;
            } else {
                maxSpeed1 = cars[i + 1].maxSpeed;
                maxIndex = i;
            }
        }

        System.out.println("Max speed auto Toyota: " + cars[maxIndex].model + " Max speed: " +
                cars[maxIndex].maxSpeed + " Mileage: " + cars[maxIndex].mileage);


    }

}

class Car {
    String model;
    int maxSpeed;
    int mileage;
}
