package lesson11_polymorfizm;

public class Rectangle extends Shape {
    int a,b;

    public Rectangle(int a, int b) {
        this.a = a;
        this.b = b;
    }

    double getSquare(){
        return a*b;
    }
}
