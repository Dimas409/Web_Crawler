package Generics.igra;

import javax.swing.*;

public abstract class Participant {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Participant(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
