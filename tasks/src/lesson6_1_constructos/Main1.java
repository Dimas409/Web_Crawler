package lesson6_1_constructos;

import java.util.Random;

public class Main1 {
    public static void main(String[] args) {
        //Отличия конструкторов от методов:
        //1. Конструкторы называются в точности как их класс
        //2. у конструкторов нет типа возвраращемого значени (ни void, ни int....)
        //3. констр-ы вызываются автоматически при создании объекта, вручную вызвать невозможно


        //Создать массив карт и заполнить его третмя начальными картами
//        Card[] arr = {new Card("черви", 6), new Card("буби", 7), new Card("крести", 8)};
//        Random rnd = new Random();
//        int index = rnd.nextInt(arr.length);
//        arr[index].printCards();



        //Заполним массив карт в цикле
        Card[] cards = new Card[5];
        int[] values = {7, 6, 10, 9, 8};
        String[] masts = {"бубы", "черви", "трефы", "пики"};
        Random rnd = new Random();
        for (int i = 0; i < cards.length; i++) {
            int valueIndex = rnd.nextInt(values.length);
            int mastIndex = rnd.nextInt(masts.length);
            cards[i] = new Card(masts[mastIndex], values[valueIndex]);
            cards[i].printCards();
        }


    }
}

class Card {
    String mast;
    int value;

    String color;
    int redkost;

    //когда есть две переменные с одинаковым именем, приоритет всегда отдается локальной переменной
    //чтобы пометить переменную как глобальную, нужно обращаться к ней через ключевое слово this
    //this - ссылка на объект внутри его же класса


    public Card(String mast, int value) {
        this.mast = mast;
        this.value = value;
    }

    public void printCards() {
        System.out.println(" Значение карты: " + value
                + " Масть карты: " + mast);
    }
}