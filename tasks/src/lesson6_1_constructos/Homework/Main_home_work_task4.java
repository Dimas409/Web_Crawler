package lesson6_1_constructos.Homework;

public class Main_home_work_task4 {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.abs("-25"));
        System.out.println(calc.maxValue("25", "35"));
        System.out.println(calc.abs(-25));
        System.out.println(calc.minValue("-25", "-52"));
        System.out.println(calc.maxValue(25.72, 63.52));
        System.out.println(calc.abs(-352.63));
        System.out.println(calc.maxValue(5, 6));
        System.out.println(calc.minValue(25, 63));
        System.out.println(calc.minValue(-63.45, -25.3));

    }
}
class Calculator {

    //TODO: убрать по максимому дублированный код
    public int minValue (int a, int b) {
        return Math.min(a, b);
    }
    public int maxValue (int a, int b) {
        return Math.max(a, b);
    }
    public int abs (int a) {
        return Math.abs(a);
    }
    public double maxValue (double a, double b) {
        return Math.max(a, b);
    }
    public double minValue (double a, double b) {
        return Math.min(a, b);
    }
    public double abs (double a) {
        return Math.abs(a);
    }

    public int maxValue (String a, String b) {
        return maxValue(Integer.parseInt(a), Integer.parseInt(b));
    }
    public int minValue (String a, String b) {
        return minValue(Integer.parseInt(a), Integer.parseInt(b));
    }
    public int abs (String a) {
        return abs(Integer.parseInt(a));
    }
}