package lesson11_polymorfizm;

public class Circle extends Shape {
    int r;

    public Circle(int r) {
        this.r = r;
    }

    double getSquare(){
        return Math.PI*r*r;
    }
}
