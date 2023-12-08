package lesson10_static.Homework;

public class Main_home_work_task1 {
    public static void main(String[] args) {
        System.out.println(MyMath.abs(-25.25));
        System.out.println(MyMath.getCircleSquare(5));
        System.out.println(MyMath.pow(5, 2));
    }
}
class MyMath {

    static double PI = 3.14;
    public static double pow (double val, int stepen) {
        return Math.pow(val, stepen);
    }
    public static double abs(double val) {
        return Math.abs(val);
    }
    public static double getCircleSquare(double r) {
        return PI * r * r;
    }

}