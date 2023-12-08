package lesson11_polymorfizm.Homework;

public class Task1 {
    public static void main(String[] args) {
        CalculatorEconomic calculatorEconomic = new CalculatorEconomic();
        System.out.println(calculatorEconomic.convertRubToDollar(500, 76));
        System.out.println(calculatorEconomic.divide(1000, 35));
        System.out.println(calculatorEconomic.minus(3456, 15363));
        System.out.println(calculatorEconomic.multiply(355, 6677));
        System.out.println(calculatorEconomic.sum( 254545, 344590));

    }
}
class Calculator {
    public double sum(double a, double b) {
        return a+b;
    }
    public double minus(double a, double b) {
        return a-b;
    }
    public double multiply(double a, double b) {
        return a*b;
    }
    public double divide(double a, double b) {
        return a/b;
    }
}
class CalculatorEconomic extends Calculator {

    public double convertRubToDollar(double rub, double curse) {
        return rub/curse;
    }
}