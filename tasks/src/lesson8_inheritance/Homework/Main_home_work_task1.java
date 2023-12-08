package lesson8_inheritance.Homework;

public class Main_home_work_task1 {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println("Калькулятор ");
        System.out.println("Минус: " + calculator.minus( 20.5, 10.3));
        System.out.println("Сумма: " + calculator.sum(26.3, 56.7));
        CalculatorPro calculatorPro = new CalculatorPro();
        System.out.println("Калькулятор PRO");
        System.out.println("Сумма: " + calculatorPro.sum(22.02, 33.43));
        System.out.println("Минус: " + calculatorPro.minus(33.34, 31.02));
        System.out.println("Разделить: " + calculatorPro.divide( 67.46, 24.32));
        System.out.println("Умножить: " + calculatorPro.mult(45.32, 76.22));
        CalculatorEconomic calculatorEconomic = new CalculatorEconomic();
        System.out.println("Экономический калькулятор");
        System.out.println("Сумма: " + calculatorEconomic.sum(27.26, 38.47));
        System.out.println("Минус: " + calculatorEconomic.minus(36.47, 27.32));
        System.out.println("Конвертер рубли в доллары: " + calculatorEconomic.convertRubToDollar(1500, 76.32));

    }
}
class Calculator {

    public double sum(double a, double b) {
        return a + b;
    }
    public double minus(double a, double b) {
        return a - b;
    }

}

class CalculatorPro extends Calculator {
    public double mult(double a, double b) {
        return a * b;
    }
    public double divide(double a, double b) {
        return a / b;
    }

}
class CalculatorEconomic extends Calculator {
    public double convertRubToDollar(double rub, double course) {
        return rub / course;
    }
}