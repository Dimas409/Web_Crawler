package lesson5_methods.Home_Work_methods;

import java.util.Random;
import java.util.Scanner;

public class Main_home_work_task5 {
    public static void main(String[] args) {
        Card[] cards = new Card[5];
        int[] cardValues = {7, 6, 10, 9, 8};
        String[] cardMasts = {"бубы", "черви", "трефы", "пики"};
        //Card[] arr =
        Random rnd = new Random();
        Scanner scn = new Scanner(System.in);

        for (int i = 0; i < cards.length; i++) {
            Card card = new Card();
            int cardValueIndex = rnd.nextInt(cardValues.length);
            card.value = cardValues[cardValueIndex];
            int cardMastIndex = rnd.nextInt(cardMasts.length);
            card.mast = cardMasts[cardMastIndex];
            cards[i] = card;
            card.printCards();
        }
        int points = 0;
        int allPoints = 0;
        boolean guessNum = false;
        boolean guessMas = false;
        for (int i = 1; i < 4; i++) {
            int random = rnd.nextInt(0, 4);
            System.out.println("Раунд: " + i);
            System.out.println("Я загадал карту попробуй угадать!");
            System.out.println("Какое значение?");
            int guessValue = scn.nextInt();
            if (guessValue == cards[random].value) {
                System.out.println("Правильно!");
                points++;
                guessNum = true;
            } else {
                System.out.println("Не правильно!");
            }
            System.out.println("Какая масть?");
            String guessMast = scn.next();
            if (guessMast.equals(cards[random].mast)) {
                System.out.println("Правильно!");
                points++;
                guessMas = true;
            } else {
                System.out.println("Не правильно!");
            }
            if (guessMas && guessNum) {
                points++;
            }
            cards[random].printCards();
            allPoints += points;
            System.out.println("За раунд № " + i + " вы заработали очков: " + points);
            System.out.println("Всего очков: " + allPoints);
            points = 0;
        }

    }
}

class Card {
    int value;
    String mast;

    public void printCards() {
        System.out.println(" Значение карты: " + value
                + " Масть карты: " + mast);
    }


}