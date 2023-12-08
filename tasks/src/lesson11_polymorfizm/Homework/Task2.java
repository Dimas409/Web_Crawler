package lesson11_polymorfizm.Homework;

public class Task2 {
    public static void main(String[] args) {
        Player player = new Player("Варвар", 300);
        Mage mage = new Mage("Маг", 300);
        Healer healer = new Healer("Лекарь", 300);
        player.attack();
        mage.attack();
        healer.attack();


    }
}
class Player {
    String name;
    int damage;

    public Player(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public void attack() {
        System.out.println(name + " атакует простой атакой уроном " + damage);
    }
}
class Mage extends Player {
    public Mage(String name, int damage) {
        super(name, damage);
    }

    public void attack() {
        System.out.println(name + " атакует магической атакой уроном " + damage*2);
    }
}
class Healer extends Player {
    public Healer(String name, int damage) {
        super(name, damage);
    }

    public void attack() {
        System.out.println(name + " исцеляет здоровье на величину " + damage/2);
    }
}