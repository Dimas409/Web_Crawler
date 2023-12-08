package lesson8_inheritance.Homework;

public class Main_home_work_task2 {
    public static void main(String[] args) {
        CalcSimpleSalary calcSimpleSalary = new CalcSimpleSalary(15505);
        System.out.println(calcSimpleSalary.salaryMinusTax());
        BonusSalary bonusSalary = new BonusSalary(15505, 2000);
        System.out.println(bonusSalary.salaryMinusTaxPlusBonus());

    }
}
class CalcSimpleSalary {
    private final double salary;

    public CalcSimpleSalary(double salary) {
        this.salary = salary;
    }


    public double salaryMinusTax() {
        return salary * 0.87;
    }
}
class BonusSalary extends CalcSimpleSalary {
    private final double bonus;

    public BonusSalary(double salary, double bonus) {
        super(salary);
        this.bonus = bonus;
    }

    public double salaryMinusTaxPlusBonus() {

        return salaryMinusTax() + bonus;
    }
}