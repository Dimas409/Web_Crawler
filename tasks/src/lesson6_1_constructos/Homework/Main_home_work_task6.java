package lesson6_1_constructos.Homework;
import java.util.Objects;
import java.util.Scanner;

public class Main_home_work_task6 {
    public static void main(String[] args) {
        Character[] characters = new Character[10];
        Scanner scn = new Scanner(System.in);
        String name;
        int strength;
        int input = 0;
        int index = 0;
        while (input != 10) {
            System.out.println("""
                            ГЛАВНОЕ МЕНЮ
                    1. Добавить нового персонажа
                    2. Добавить персонажу одну победу (юзер вводит имя персонажа с консоли)
                    3. Добавить персонажу одно поражение (юзер вводит имя персонажа с консоли)
                    4. Вывести имя самого сильного персонажа (по силе удара)
                    5. Вывести имя самого непобедимого персонажа (по кол-ву побед)
                    6. Вывести персонажа с наибольшим кол-вом побед за вычетом его поражений
                    7. Показать всех персонажей
                    8. Меню статистики
                    9. Выход""");
            input = scn.nextInt();
            if (input == 1) {
                if( index < characters.length){
                    System.out.println("Введите имя персонажа: ");
                    name = scn.next();
                    System.out.println("Введите количество силы персонажа: ");
                    strength = scn.nextInt();
                    int catchDuplicate = 0;
                    for (int i = 0; i < index; i++) {
                        if(characters[i] != null && Objects.equals(characters[i].name, name)){
                            catchDuplicate++;
                        }
                    }
                    if (catchDuplicate == 0){
                        Character character = new Character(name, strength);
                        characters[index] = character;
                        characters[index].print();
                        index++;
                    }
                    else {
                        System.out.println("Такое имя уже есть! Придумайте другое!");
                    }
                }
            } else if (input == 2) {
                System.out.println("Введите имя персонажа: ");
                name = scn.next();
                for (Character character : characters) {
                    if (character != null && character.name.equals(name)) {
                        character.addWins();
                        character.print();
                    }
                }
            } else if (input == 3) {
                System.out.println("Введите имя персонажа: ");
                name = scn.next();
                for (Character character : characters) {
                    if (character != null && character.name.equals(name)) {
                        character.addDefeats();
                        character.print();
                    }
                }
            } else if (input == 4) {
                Character maxStrength = new Character(null, 0);
                for (int i = 0; i < characters.length - 1; i++) {
                    if (characters[i] != null && characters[i].strength >= maxStrength.strength) {
                        maxStrength = characters[i];
                    }
                }
                maxStrength.print();
            } else if (input == 5) {
                Character maxWins = new Character(null, 0);
                for (int i = 0; i < characters.length - 1; i++) {
                    if (characters[i] != null && characters[i].numberOfWins >= maxWins.numberOfWins) {
                        maxWins = characters[i];
                    }
                }
                maxWins.print();
            } else if (input == 6) {
                Character maxWinsWODef = new Character(null, 0);
                for (int i = 0; i < characters.length - 1; i++) {
                    if (characters[i] != null && (characters[i].numberOfWins - characters[i].numberOfDefeats) >= maxWinsWODef.numberOfWins) {
                        maxWinsWODef = characters[i];
                    }
                }
                maxWinsWODef.print();
            } else if (input == 7) {
                for (Character character : characters) {
                    if (character != null) {
                        character.print();
                    }
                }
            } else if (input == 8) {
                if (index <= 0) {
                    System.out.println("Сначала нужно добавить перснажа");
                } else {
                    for (Character value : characters) {
                        if (value != null && value.numberOfDefeats == 0 && value.numberOfWins == 0) {
                            System.out.println("Не было ни одного боя. Статистика не доступна");
                            break;
                        } else {
                            while (input != 5) {
                                System.out.println("""
                                    1. Скрыть статистику выбранного персонажа
                                    2. Отображать статистику выбранного персонажа
                                    3. Скрыть статистику всех персонажей
                                    4. Отображать статистику всех персонажей
                                    5. Выход в главное меню""");
                                input = scn.nextInt();
                                if (input == 1) {
                                    System.out.println("Введите имя персонажа статистику которого вы хотите скрыть: ");
                                    name = scn.next();
                                    for (Character character : characters) {
                                        if (character != null && character.name.equals(name)) {
                                            character.hideStat();
                                        }
                                    }
                                } else if (input == 2) {
                                    System.out.println("Введите имя персонажа статистику которого вы хотите показать: ");
                                    name = scn.next();
                                    for (Character character : characters) {
                                        if (character != null && character.name.equals(name)) {
                                            character.showStat();
                                        }
                                    }
                                } else if (input == 3) {
                                    for (Character character : characters) {
                                        if (character != null) {
                                            character.hideStat();
                                        }
                                    }
                                } else if (input == 4) {
                                    for (Character character : characters) {
                                        if (character != null) {
                                            character.showStat();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

class Character {
    String name;
    int strength;
    int numberOfWins = 0;
    int numberOfDefeats = 0;
    boolean hide = false;



    public Character(String name, int strength) {
        this.name = name;
        this.strength = strength;
    }

    public void addWins() {
        numberOfWins += 1;
    }

    public void addDefeats() {
        numberOfDefeats += 1;
    }

    public void hideStat() {
        hide = true;
    }

    public void showStat() {
        hide = false;
    }
    public void print() {
//        System.out.println("Имя персонажа: " + name + "\nПоказатель силы персонажа: " + strength + "\n");
//        if (numberOfDefeats > 0 || numberOfWins > 0 && !hide) {
//            System.out.println("Количество поражений: " + numberOfDefeats +
//                               "\nКоличество побед: " + numberOfWins + "\n");
//        }
        System.out.println((numberOfDefeats > 0 || numberOfWins > 0 && !hide)? "Имя персонажа: " + name +
                "\nПоказатель силы персонажа: " + strength + "\n" + "Количество поражений: " + numberOfDefeats +
                "\nКоличество побед: " + numberOfWins + "\n": "Имя персонажа: " + name +
                "\nПоказатель силы персонажа: " + strength + "\n");

    }


}
