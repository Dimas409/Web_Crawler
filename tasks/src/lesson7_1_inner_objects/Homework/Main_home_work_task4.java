package lesson7_1_inner_objects.Homework;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main_home_work_task4 {
    public static void main(String[] args) {
        Random rnd = new Random();
        Scanner scn = new Scanner(System.in);
        String[] masts = {"бубны", "черви", "пики", "крести"};
        String[] values = {"валет", "король", "дама", "туз", "десять" };
        //TODO: заменить два списка на один список ArrayList<Card>
        ArrayList<Card> cards = new ArrayList<>();
        int index;
        for(int i = 0; i < 5; i++) {
            Card card = new Card(null, null);
            index = rnd.nextInt(masts.length);
            card.setMast(masts[index]);
            index = rnd.nextInt(values.length);
            card.setValue(values[index]);
            cards.add(i, card);
            System.out.println(card);
        }
        String guessValue;
        String guessMast;
        int points = 0;
        int totalPoints = 0;
        boolean mastB = false;
        boolean valueB = false;
        for (int i = 0; i < 3; i++) {
            index = rnd.nextInt(0, 5);
            System.out.println("Я загадал карту, попробуй угадать.");
            System.out.println("Какое значение? ");
            guessValue = scn.next();
            if(guessValue.equals(cards.get(index).getValue())){
                System.out.println("Правильно!");
                points++;
                valueB = true;
            }else {
                System.out.println("Не правильно!");
            }
            System.out.println("Какая мать? ");
            guessMast = scn.next();
            if(guessMast.equals(cards.get(index).getMast())) {
                System.out.println("Правильно");
                points++;
                mastB = true;
            } else {
                System.out.println("Не правильно!");
            }
            if (valueB && mastB) {
                points++;
            }
            totalPoints += points;
            System.out.println("За раунд "+ i + " вы заработали: " + points + " очков.");
            points = 0;
            System.out.println("Всего очков: " + totalPoints);

        }

        }

    }
    class Card {
    private String mast;
    private String value;

        public Card(String mast, String value) {
            this.mast = mast;
            this.value = value;
        }

        public String getMast() {
            return mast;
        }

        public void setMast(String mast) {
            this.mast = mast;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Масть = " + mast +
                    ", Значение = " + value;
        }
    }
