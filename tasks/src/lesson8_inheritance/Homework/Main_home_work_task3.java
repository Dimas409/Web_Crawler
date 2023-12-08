package lesson8_inheritance.Homework;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_home_work_task3 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        ArrayList<Worker> workers = new ArrayList<>();
        System.out.println("Введите доход компании: ");
        int income = scn.nextInt();
        System.out.println("Введите количество часов отработанное сотрудниками компании: ");
        int hours = scn.nextInt();
        BaseSalary baseSalary = new BaseSalary();
        baseSalary.setSalary(100000);
        baseSalary.setName("Ivan");
        baseSalary.setIncome(income);
        workers.add(baseSalary);
        PercentSalary percentSalary = new PercentSalary();
        percentSalary.setSalary(80000);
        percentSalary.setPercent(1);
        percentSalary.setIncome(income);
        percentSalary.setName("Semen");
        workers.add(percentSalary);
        HourlySalary hourlySalary = new HourlySalary();
        hourlySalary.setHourPrice(1000);
        hourlySalary.setName("Vanya");
        hourlySalary.setIncome(income);
        workers.add(hourlySalary);
        for (Worker worker : workers) {
            System.out.println(worker.getName() + " отработал " + hours + " часов и заработал " + worker.calcSalary(hours) + " руб.");
        }
    }
}
class Worker {
    private String name;
    private int income;
    public int calcSalary(int hours) {
        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }
}
class BaseSalary extends Worker {
    private int salary;

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public int calcSalary(int hours) {
        return salary;
    }
}
class PercentSalary extends BaseSalary {
    private  int percent;

    public double getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    @Override
    public int calcSalary(int hours) {
        return  (getSalary() + ((getIncome() * percent)/100));
    }

}
class HourlySalary extends Worker {
    private int hourPrice;

    public int getHourPrice() {
        return hourPrice;
    }

    public void setHourPrice(int hourPrice) {
        this.hourPrice = hourPrice;
    }

    @Override
    public int calcSalary(int hours) {
        return hours * hourPrice;
    }
}