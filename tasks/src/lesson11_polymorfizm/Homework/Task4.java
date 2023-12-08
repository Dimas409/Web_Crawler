package lesson11_polymorfizm.Homework;

import java.util.ArrayList;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите доход компании: ");
        int dohod = scanner.nextInt();
        ArrayList<Worker>workers = new ArrayList<>();
        workers.add(new BaseSalary("Ivan", dohod, 100000));
        workers.add(new PercentSalary("Semen", dohod, 80000, 1));
        workers.add(new HourSalary("Vanya", dohod, 1000));
        System.out.println("Введите количество часов которое отработал работник: ");
        int hours = scanner.nextInt();
        for (Worker worker : workers) {
            System.out.println(worker.name + " отработал " + hours + " часов и заработал " +  worker.calcSalary(hours));
        }

    }
}
class Worker {
    String name;
    int dohod;

    public Worker(String name, int dohod) {
        this.name = name;
        this.dohod = dohod;
    }

    public int calcSalary(int hours) {
        return 0;
    }


}
class BaseSalary extends Worker {
    int salary;

    public BaseSalary(String name, int dohod, int salary) {
        super(name, dohod);
        this.salary = salary;
    }
    @Override
    public int calcSalary(int hours) {
        return salary;
    }
}
class PercentSalary extends BaseSalary {
    int percent;

    public PercentSalary(String name, int dohod, int salary, int percent) {
        super(name, dohod, salary);
        this.percent = percent;
    }

    @Override
    public int calcSalary(int hours) {
        return salary + (dohod * percent / 100);
    }
}
class HourSalary extends Worker {
    int hourPrice;

    public HourSalary(String name, int dohod, int hourPrice) {
        super(name, dohod);
        this.hourPrice = hourPrice;
    }
    @Override
    public int calcSalary (int hours) {
        return hours * hourPrice;
    }
}