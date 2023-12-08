package lesson10_static;

public class Main {
    public static void main(String[] args) {
        System.out.println(Calculator.sum(2, 3));
        System.out.println(Calculator.PI);



        //1. внутри статических методов нельзя использовать объектные (нестатические) поля или методы
        //2. внутри объектных методов можно использовать статические поля и методы
        System.out.println(Rectangle.name);
        Rectangle rec = new Rectangle(2, 3);
        System.out.println(rec);

    }
}

class Rectangle{
    int a;
    int b;

    public Rectangle(int a, int b) {
        this.a = a;
        this.b = b;
    }

    static String name = "Rectangle";


    double getSquare(){
        return a*b;
    }


    @Override
    public String toString() {
        return name +
                ": a=" + a +
                ", b=" + b;
    }
}