package lesson9_equals_toString;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        ArrayList<RealEstate> list = new ArrayList<>();
        list.add(new RealEstate(100, 3, true, "red"));
        list.add(new RealEstate(60, 2, true, "brown"));
        list.add(new RealEstate(40, 1, false, "red"));

        System.out.println("1. юзер хочет узнать цвет дома");
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter square: ");
        int square = scn.nextInt();
        System.out.print("Enter roomsCount: ");
        int roomsCount = scn.nextInt();
        System.out.print("Enter hasLift: ");
        boolean hasList = scn.nextBoolean();


        int index = list.indexOf(new RealEstate(square, roomsCount, hasList, null));
        if(index != -1){
            System.out.println("цвет дома: "+list.get(index).getColor());
        }else{
            System.out.println("объект не найден");
        }


    }
}

//недвижимость
class RealEstate{
    private double square;
    private int roomsCount;
    private boolean hasLift; //есть ли лифт в доме
    private String color; //цвет дома

    public RealEstate(double square, int roomsCount, boolean hasLift, String color) {
        this.square = square;
        this.roomsCount = roomsCount;
        this.hasLift = hasLift;
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RealEstate that = (RealEstate) o;

        return that.square == square && roomsCount == that.roomsCount && hasLift == that.hasLift;
    }

    public String getColor() {
        return color;
    }
}

