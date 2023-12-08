package lesson11_polymorfizm;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //создать общий список фигур и вычислить площадь каждой фигуры
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Rectangle(2,3));
        shapes.add(new Circle(2));

        for (Shape shape : shapes) {
            System.out.println(shape.getSquare()); //пример полиморфизма
        }
    }
}
