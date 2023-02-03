package lesson5_methods;

import java.util.Random;
import java.util.Scanner;

public class Main2_character {
    public static void main (String[] args) {
//        Задача 6 Создать класс Character (персонаж игры) с полями
//        название персонажа
//        класс персонажа (войн, маг, лекарь)
//        урон персонажа
//
//
//        В мейне создайте массив на 5 объектов класса Character, заполните его объектами класса Character.
//        Заполнение можете сделать вручную, либо в цикле.
//
//        После заполнения выведите на консоль информацию о всех персонажах (их название, класс, урон).
//
//                Далее выполните задачи:
//        1. Юзер вводит с консоли требуемый класс персонажа,
//        программа должна вывести из массива всех персонажей, чей класс совпадает с введенным с консоли.
//        2. Юзер вводит с консоли урон, которым должен обладать персонаж.
//        Выведите на консоль всех персонажей, чей урон больше или равен введенному с консоли
//        3. Юзер вводит класс и урон. Выведите всех персонажей,
//        чей класс совпадает с введенным и чей урон больше или равен введенному.
        Character[] characters = new Character[5];
        String[] names = {"Ниа", "Кира", "Гумберт", "Виктор", "Эдвард"};
        String[] characterOfClasses = {"Воин", "Маг", "Лекарь"};
        int[] damageOfCharacters = {516, 416, 490, 437, 375};
        Random rnd = new Random();

        for (int i = 0; i < characters.length; i++) {
            Character character = new Character();
            int index_character = rnd.nextInt(characterOfClasses.length);
            character.characterClass = characterOfClasses[index_character];
            character.name = names[i];
            character.damageOfCharacter = damageOfCharacters[i];
            characters[i] = character;

        }
        System.out.println("Вот доступные для выбора персонажи: ");
        for (int i = 0; i < characters.length; i++) {
            characters[i].printInfo();
        }
        int input = 0;
        while (input != 4) {
            Scanner scn = new Scanner(System.in);
            System.out.println("Введите цифру в соответствии сдействием которое вы хотите: \n" +
                    "1. Ввести класс персонажа\n" +
                    "2. Ввести урон которым должен обладать персонаж\n" +
                    "3. Введите класс и урон персонажей\n" +
                    "4. Выход\n");
            input = scn.nextInt();
            if (input == 1) {
                System.out.println("Введите класс персонажа (Воин, Маг, Лекарь) ");
                String inputName = scn.next();
                for (int i = 0; i < characters.length; i++) {
                    if (characters[i].characterClass.equals(inputName)) {
                        characters[i].printInfo();
                    }
                }
            }
            if (input == 2) {
                System.out.println("Введите урон которым должен обладать персонаж: ");
                int damage = scn.nextInt();
                for (int i = 0; i < characters.length; i++) {
                    if (damage <= characters[i].damageOfCharacter) {
                        characters[i].printInfo();
                    }
                }
            }
            if (input == 3) {
                System.out.println("Введите урон: ");
                int damage = scn.nextInt();
                System.out.println("Введите класс: ");
                String inputName = scn.next();
                for (int i = 0; i < characters.length; i++) {
                    if (characters[i].characterClass.equals(inputName) &&
                            (damage <= characters[i].damageOfCharacter))
                        characters[i].printInfo();

                }
            }


        }


    }


}

class Character {
    String name;
    String characterClass;
    int damageOfCharacter;

    void printInfo() {
        System.out.println("Имя персонажа: " + name + "." +
                " Класс персонажа: " + characterClass + "." +
                " Урон персонажа: " + damageOfCharacter);
    }

}