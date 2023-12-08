package lesson11_polymorfizm.Homework;

public class Task3 {
    public static void main(String[] args) {
        CalcSimpleSalary calcSimpleSalary = new CalcSimpleSalary(90000);
        BonusSalary bonusSalary = new BonusSalary(90000, 5000);
        System.out.println("Зарплата за вычетом налога: " + calcSimpleSalary.salaryMinusNalog());
        System.out.println("Зарплата за вычетом налога, плюс бонус: " + bonusSalary.salaryMinusNalog());


    }
}
class CalcSimpleSalary {
    double salary;

    public CalcSimpleSalary(double salary) {
        this.salary = salary;
    }

    public double salaryMinusNalog() {
        return salary*0.87;
    }
}
class BonusSalary extends CalcSimpleSalary{
    double bonus;

    public BonusSalary(double salary, double bonus) {
        super(salary);
        this.bonus = bonus;
    }

    public double salaryMinusNalog() {
        return super.salaryMinusNalog() + bonus;
    }
}