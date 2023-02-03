package lesson2.Homework;

import java.util.Objects;
import java.util.Scanner;

public class Main_home_work_task8 {
    public static void main (String[] args) {
//        Задача 8 Создать массив, хранящий паспортные данные пользователя.
//        Допустим паспорт содержит данные: серия, номер и имя.
//        Необходимо создать три массива, которые будут хранить данные паспорта.
//        Данные в массивах должны храниться таким образом, чтобы данные одного
//        паспорта хранились под одинаковым индексом во всех массивах.

//        В мейне создать консольное меню:
//        1. Добавить паспорт
//        2. Вывести все паспорта
//        3. Удалить паспорт
//        4. Проверить паспорт на существование
//        5. Выход
        Scanner scn = new Scanner(System.in);
        String[] serials = new String[5];
        String[] numbers = new String[5];
        String[] names = new String[5];
        int newPassportIndex = 0;
        int input = 0;
        while (input !=5){
            System.out.println("" +
                    "        1. Добавить паспорт\n" +
                    "        2. Вывести все паспорта\n" +
                    "        3. Удалить паспорт\n" +
                    "        4. Проверить паспорт на существование\n" +
                    "        5. Выход");
            input = scn.nextInt();
            if (input == 1){
                System.out.print("Введите серию паспорта: ");
                String serial = scn.next();
                System.out.print("Введите номер паспорта: ");
                String number = scn.next();
                System.out.print("Введите имя: ");
                String name = scn.next();
                serials[newPassportIndex] = serial;
                numbers[newPassportIndex] = number;
                names[newPassportIndex] = name;
                newPassportIndex++;

            }
            else if (input == 2) {
                for (int i = 0; i < serials.length; i++) {
                    if (serials[i] != null){
                        System.out.println(" Серия: " + serials[i] + "\n Номер: " + numbers[i] + "\n имя: " + names[i]);
                    }
                }
            }
            else if (input == 3) {
                System.out.print("Enter series: ");
                String series = scn.next();
                System.out.print("Enter number: ");
                String number = scn.next();
                System.out.println("Enter name: ");
                String name = scn.next();
                boolean isExist = false;
                for (int i = 0; i < newPassportIndex; i++) {
                    if(Objects.equals(serials[i], series) && Objects.equals(numbers[i], number)
                            && Objects.equals(names[i], name)) {
                        serials[i] = serials[i + 1];
                        numbers[i] = numbers[i +1];
                        names[i] = names[i + 1];
                        isExist = true;
                        System.out.println("Паспорт удален");
                    }
                }
                serials[newPassportIndex - 1] = null;
                numbers[newPassportIndex - 1] = null;
                names[newPassportIndex - 1] = null;
                newPassportIndex--;
                if(!isExist) {
                    System.out.println("Паспорт не найден!");
                }
               }

        }

    }
}
