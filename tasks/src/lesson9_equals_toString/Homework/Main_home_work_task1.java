package lesson9_equals_toString.Homework;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main_home_work_task1 {
    public static void main(String[] args) {
        ArrayList<Gun> guns = new ArrayList<>();
        guns.add(new Gun("Crown & King Auto-5", 185, 600));
        guns.add(new Gun("Nagant M1895 Officer", 91, 96));
        guns.add(new Gun("Mosin-Nagant M1891", 136, 490));
        guns.add(new Gun("Vetterli 71 Karabiner", 130, 105));
        guns.add(new Gun("Specter 1882", 200, 188));
        Scanner scn = new Scanner(System.in);
        int input = 0;
        while (input != 5) {
            System.out.println("""
                    1. Вывести все оружия на консоль
                    2. Найти самое мощное по урону оружие
                    3. Юзер вводит название оружия, программа выводит его урон и цену
                    4. Удалить любое оружие из списка. Юзер вводит название оружия для удаления.
                    5. Выход""");
            input = scn.nextInt();
            if (input == 1) {
                for (Gun gun : guns) {
                    System.out.println(gun);
                }
            } else if (input == 2) {
                Gun maxGun = null;
                for (Gun gun : guns) {
                    if (maxGun == null) {
                        maxGun = gun;
                    } else if (gun.getDamageOfGun() > maxGun.getDamageOfGun()) {
                        maxGun = gun;
                    }
                }
                System.out.println("самое мощное оружие: "+maxGun);
            } else if (input == 3) {
                System.out.println("Введите название оружия: ");
                scn.nextLine();
                String nameOutputGun = scn.nextLine();
                int index = guns.indexOf(new Gun(nameOutputGun, 0, 0));
                if (index == -1) {
                    System.out.println("Оружение не найдено");
                } else {
                    System.out.println(guns.get(index));
                }
            } else if (input == 4) {
                System.out.println("Введите название оружия: ");
                scn.nextLine();
                String nameDeleteGun = scn.nextLine();
                if (guns.remove(new Gun(nameDeleteGun, 0, 0))) {
                    System.out.println("Оружие удалено");
                } else {
                    System.out.println("Оружие найдено");
                }
            }
        }


    }
}

class Gun {
    private String nameOfGun;
    private int damageOfGun;
    private int priceOfGun;

    public Gun(String nameOfGun, int damageOfGun, int priceOfGun) {
        this.nameOfGun = nameOfGun;
        this.damageOfGun = damageOfGun;
        this.priceOfGun = priceOfGun;
    }

    public String getNameOfGun() {
        return nameOfGun;
    }

    public void setNameOfGun(String nameOfGun) {
        this.nameOfGun = nameOfGun;
    }

    public int getDamageOfGun() {
        return damageOfGun;
    }

    public void setDamageOfGun(int damageOfGun) {
        this.damageOfGun = damageOfGun;
    }

    public int getPriceOfGun() {
        return priceOfGun;
    }

    public void setPriceOfGun(int priceOfGun) {
        this.priceOfGun = priceOfGun;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gun gun = (Gun) o;
        return Objects.equals(nameOfGun, gun.nameOfGun);
    }


    @Override
    public String toString() {
        return "Название оружия: " + nameOfGun +
                ", Урон оружия: " + damageOfGun +
                ", цена оружия: " + priceOfGun;
    }
}