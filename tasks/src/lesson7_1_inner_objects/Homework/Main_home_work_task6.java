package lesson7_1_inner_objects.Homework;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main_home_work_task6 {
    public static void main(String[] args) {
        Random rnd = new Random();
        Scanner scn = new Scanner(System.in);
        //TODO: заменить три списка на список ArrayList<Character>
        ArrayList<Character> characters = new ArrayList<>();
        String[] classes = {"воин", "маг", "лекарь"};
        String[] names = {"Маша", "Саша", "Вася", "Петя", "Дима"};
        int index;
        for (int i = 0; i < 5; i++) {
            Character character = new Character(null, null, 0);
            index = rnd.nextInt(classes.length);
            character.setClas(classes[index]);
            character.setDamage(rnd.nextInt(100, 1000));
            character.setName(names[i]);
            characters.add(character);
        }
        int input = 0;
        String person;
        while (input != 4) {
            System.out.println();
            System.out.println("""
                    1. Вывести всех доступных персонажей
                    2. Юзер вводит с консоли требуемый класс персонажа, программа должна вывести из массива всех персонажей, чей класс совпадает с введенным с консоли.
                    3. Юзер вводит с консоли урон, которым должен обладать персонаж. Выведите на консоль всех персонажей, чей урон больше или равен введенному с консоли
                    4. Юзер вводит класс и урон. Выведите всех персонажей, чей класс совпадает с введенным и чей урон больше или равен введенному
                    5. Выход""");
            input = scn.nextInt();
            if (input == 1) {
                for (Character character : characters) {
                    System.out.println(character.toString());
                }
            }else if (input == 2) {
                System.out.println("Введите класс персонажа чтобы увидеть всех персонажей данного класса.");
                person = scn.next();
                for (Character character : characters) {
                    if (character.getClas().equals(person)) {
                        System.out.println(character);
                    }
                }
            } else if (input == 3) {
                System.out.println("Введите урон которым должен обладать персонаж: ");
                input = scn.nextInt();
                for (Character character : characters) {
                    if (character.getDamage() >= input) {
                        System.out.println(character);
                    }
                }
            } else if (input == 4) {
                System.out.println("Введите класс: ");
                person = scn.next();
                System.out.println("Введите урона: ");
                input = scn.nextInt();
                for (Character character : characters) {
                    if (character.getDamage() >= input && character.getClas().equals(person)) {
                        System.out.println(character);
                    }
                }
            } else if (input == 5) {
                break;
            }
        }
    }
}
class Character {
    private String name;
    private String clas;
    private int damage;

    Character(String name, String clas, int damage) {
        this.name = name;
        this.clas = clas;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClas() {
        return clas;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public String toString() {
        return "Имя = " + name +
                ", Класс = " + clas +
                ", Урон =" + damage;
    }
}
